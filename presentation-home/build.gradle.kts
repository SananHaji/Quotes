plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.sananhaji.presentation_home"
}

dependencies {

    presentationCommon()
    domain()
    moduleNeeds()
    compose()
    paging()
    coreDesign()

    implementation(Dependencies.googleSwiperefreshlayout)

}