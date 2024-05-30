import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val core = "androidx.core:core-ktx:${Versions.coreKtx}"

    const val androidxAppcompat = "androidx.appcompat:appcompat:1.7.0"

    const val googleMaterial = "com.google.android.material:material:1.10.0"
    const val googleSwiperefreshlayout = "com.google.accompanist:accompanist-swiperefresh:0.34.0"

    const val testJunit = "junit:junit:4.13.2"
    const val testAndroidxJunit = "androidx.test.ext:junit:1.1.5"
    const val testAndroidxEspresso = "androidx.test.espresso:espresso-core:3.5.1"

    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val composeHiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.composeHiltNavigation}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val datastore = "androidx.datastore:datastore-preferences:1.1.1"

    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"
    const val pagingCompose = "androidx.paging:paging-compose:${Versions.paging}"
}

fun DependencyHandler.core() {
    implementation(Dependencies.core)
}

fun DependencyHandler.androidx() {
    implementation(Dependencies.androidxAppcompat)
}

fun DependencyHandler.google() {
    implementation(Dependencies.googleMaterial)
}

fun DependencyHandler.test() {
    testImplementation(Dependencies.testJunit)
    androidTestImplementation(Dependencies.testAndroidxJunit)
    androidTestImplementation(Dependencies.testAndroidxEspresso)
}

fun DependencyHandler.moduleNeeds() {
    core()
    androidx()
    google()
    test()
    hilt()
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiKotlin)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeNavigation)
    implementation(Dependencies.composeHiltNavigation)
    debugImplementation(Dependencies.composeUiToolingPreview)
}

fun DependencyHandler.paging() {
    implementation(Dependencies.pagingCompose)
    implementation(Dependencies.pagingRuntime)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.domain() {
    implementation(project(":domain"))
}

fun DependencyHandler.dataLocal() {
    implementation(project(":data-local"))
}

fun DependencyHandler.dataRemote() {
    implementation(project(":data-remote"))
}

fun DependencyHandler.dataRepository() {
    implementation(project(":data-repository"))
}

fun DependencyHandler.coreUtils() {
    implementation(project(":core-utils"))
}

fun DependencyHandler.coreDesign() {
    implementation(project(":core-design"))
}

fun DependencyHandler.presentationCommon() {
    implementation(project(":presentation-common"))
}