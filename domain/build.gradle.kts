plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.sananhaji.domain"
}

dependencies {

    moduleNeeds()
    compose()

}