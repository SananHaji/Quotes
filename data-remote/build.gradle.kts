plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.sananhaji.data_remote"
}

dependencies {

    moduleNeeds()
    dataRepository()
    domain()
    compose()
    retrofit()

}