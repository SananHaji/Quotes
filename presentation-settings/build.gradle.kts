plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.sananhaji.presentation_settings"
}

dependencies {

    presentationCommon()
    domain()
    moduleNeeds()
    compose()
    coreDesign()
    coreUtils()


}