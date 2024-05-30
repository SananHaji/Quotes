plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.sananhaji.data_local"
}

dependencies {

    moduleNeeds()
    dataRepository()
    domain()
    compose()

    implementation(Dependencies.datastore)
}