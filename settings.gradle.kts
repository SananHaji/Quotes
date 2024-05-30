pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Quotes"
include(":app")
include(":data-local")
include(":data-repository")
include(":data-remote")

val versions = mapOf(
    "coreKtx" to "1.12.0",
    "lifecycleRuntimeKtx" to "2.6.2",
    "hilt" to "2.48",
    "roomVersion" to "2.6.0"
)

val google = mapOf(
    "material" to "com.google.android.material:material:1.10.0"
)

val androidx = mapOf(
    "composeUi" to "androidx.compose.ui:ui",
    "composeUiGraphics" to "androidx.compose.ui:ui-graphics",
    "composeUiPreview" to "androidx.compose.ui:ui-tooling-preview",
    "composeUiMaterial3" to "androidx.compose.material3:material3",
    "composePlatformBom" to "androidx.compose:compose-bom:2023.03.00",
    "core" to "androidx.core:core-ktx:${versions["coreKtx"]}",
    "lifecycleRuntimeKtx" to "androidx.lifecycle:lifecycle-runtime-ktx:${versions["lifecycleRuntimeKtx"]}",
    "composeActivity" to "androidx.activity:activity-compose:${versions["composeActivity"]}",
    "navigationCompose" to "androidx.navigation:navigation-compose:2.7.5",
    "hiltNavigationCompose" to "androidx.hilt:hilt-navigation-compose:1.1.0",
    "appcompat" to "androidx.appcompat:appcompat:1.6.1",
)

val test = mapOf(
    "junit" to "junit:junit:4.13.2",
    "androidxJunit" to "androidx.test.ext:junit:1.1.5",
    "androidxEspresso" to "androidx.test.espresso:espresso-core:3.5.1",
    "androidxComposeUi" to "androidx.compose.ui:ui-test-junit4",
    "androidxComposeTooling" to "androidx.compose.ui:ui-tooling",
    "androidxComposeManifest" to "androidx.compose.ui:ui-test-manifest",
)

val hilt = mapOf(
    "android" to "com.google.dagger:hilt-android:${versions["hilt"]}",
    "compiler" to "com.google.dagger:hilt-android-compiler:${versions["hilt"]}"
)

val persistence = mapOf(
    "roomRuntime" to "androidx.room:room-runtime:${versions["roomVersion"]}",
    "roomCompiler" to "androidx.room:room-compiler:${versions["roomVersion"]}",
    "datastore" to "androidx.datastore:datastore-preferences:1.0.0"
)

val converter = mapOf(
    "gson" to "com.google.code.gson:gson:2.10.1"
)

val coroutines = mapOf(
    "coroutines" to "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1"
)

val firebase = mapOf(
    "platform" to "com.google.firebase:firebase-bom:32.6.0",
    "analytics" to "com.google.firebase:firebase-analytics",
    "firestore" to "com.google.firebase:firebase-firestore:24.9.1",
)

extra["androidx"] = androidx
extra["google"] = google
extra["test"] = test
extra["hilt"] = hilt
extra["persistence"] = persistence
extra["converter"] = converter
extra["coroutines"] = coroutines
extra["firebase"] = firebase
include(":presentation-common")
include(":domain")
include(":presentation-home")
include(":core-utils")
include(":core-design")
include(":presentation-settings")
