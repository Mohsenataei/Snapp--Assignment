
plugins {
    id("com.android.library")
    id("kotlin-kapt")
}

dependencies {

//    implementation project(path: ':buildSrc')
    implementation (Dependencies.CommonLibs.kotlin)
    implementation(Dependencies.CommonLibs.coroutines)
    implementation(Dependencies.CommonLibs.arrowCore)
    implementation(Dependencies.CommonLibs.arrowSyntax)
    kapt (Dependencies.CommonLibs.arrowMeta)

    implementation(Dependencies.JetpackLibs.lifecycleExtensions)
    implementation(Dependencies.JetpackLibs.livedataKtx)

    implementation(Dependencies.CommonLibs.dagger)
    kapt (Dependencies.CommonLibs.daggerCompiler)

    implementation(Dependencies.JetpackLibs.room)
    implementation(Dependencies.JetpackLibs.roomKtx)
    kapt (Dependencies.JetpackLibs.roomCompiler)

    implementation(Dependencies.CommonLibs.gson)
    implementation(Dependencies.CommonLibs.retrofit)
    implementation(Dependencies.CommonLibs.retrofitGson)

    testImplementation(Dependencies.TestLibs.junit)
    testImplementation(Dependencies.TestLibs.mockitoKotlin)


}