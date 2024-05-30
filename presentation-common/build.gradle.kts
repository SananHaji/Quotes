plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.sananhaji.presentation_common"
}

dependencies {

    domain()
    moduleNeeds()
    compose()

}