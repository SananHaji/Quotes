plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.sananhaji.core_design"
}

dependencies {

    domain()
    moduleNeeds()
    compose()

}