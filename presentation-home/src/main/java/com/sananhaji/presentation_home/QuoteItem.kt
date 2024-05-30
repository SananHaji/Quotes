package com.sananhaji.presentation_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QuoteItem(quote: QuoteModel, onClickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(color = MaterialTheme.colorScheme.background, shape = MaterialTheme.shapes.large)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {

            Column(modifier = Modifier.weight(1f)) {
                Text(text = buildAnnotatedString { append(quote.quote) })
                Text(text = quote.authorName)
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_heart_gray),
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        onClickAction()
                    }
                    .width(24.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Preview
@Composable
fun QuoteItemPreview() {
    QuoteItem(quote = QuoteModel("1", "Məndə sığar iki cahan, mən bu cahana sığmazam", "Nəsimi")) {

    }
}
