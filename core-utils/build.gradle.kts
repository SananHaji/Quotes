plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.sananhaji.core_utils"
}

dependencies {

    moduleNeeds()
    compose()

}