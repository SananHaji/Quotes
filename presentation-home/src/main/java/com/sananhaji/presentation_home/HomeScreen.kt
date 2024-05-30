package com.sananhaji.presentation_home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.sananhaji.presentation_common.state.Loading
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
        viewModel: HomeViewModel,
        navController: NavController
) {

    val quotePagingData = viewModel.quoteListPager.collectAsLazyPagingItems()
    val listState = rememberLazyListState()
    var isRefreshing by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    fun refresh() {
        isRefreshing = true
        quotePagingData.refresh()
    }

    fun scrollToBottom() {
        coroutineScope.launch { listState.animateScrollToItem(quotePagingData.itemCount) }
    }

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = {
            refresh()
        },
    ) {
        LazyColumn(
            state = listState
        ) {
            items(quotePagingData.itemCount) { index ->
                isRefreshing = false

                val quote = quotePagingData[index] ?: return@items
                QuoteItem(quote = quote) {
                    viewModel.submitAction(HomeUiAction.AddedQuoteToFavorites(quote.id))
                }
            }

            when {
                quotePagingData.loadState.refresh is LoadState.Loading -> item { Loading() }
                quotePagingData.loadState.append is LoadState.Loading -> item { LoadingItem() }
                quotePagingData.loadState.refresh is LoadState.Error -> {
                    isRefreshing = false

                    val e = quotePagingData.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage.orEmpty(),
                            modifier = Modifier.fillParentMaxSize(),
                            onRetry = { refresh() }
                        )
                    }

                    scrollToBottom()
                }

                quotePagingData.loadState.append is LoadState.Error -> {
                    val e = quotePagingData.loadState.append as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage.orEmpty(),
                            onRetry = { refresh() }
                        )
                    }

                    scrollToBottom()
                }

            }
        }
    }
}

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorItem(
    message: String,
    modifier: Modifier = Modifier,
    onRetry: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = message, color = MaterialTheme.colorScheme.error)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}

