plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.sananhaji.data_repository"
}

dependencies {

    moduleNeeds()
    domain()

    compose()
    paging()


}