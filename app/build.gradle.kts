plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Dependencies.Android.compileSdkVersion)
    buildToolsVersion(Dependencies.Android.buildToolsVersion)

    defaultConfig {
        applicationId = Dependencies.Android.applicationId
        minSdkVersion(Dependencies.Android.minSdkVersion)
        targetSdkVersion(Dependencies.Android.targetSdkVersion)
        versionCode = Dependencies.Android.versionCode
        versionName = Dependencies.Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dataBinding {
        isEnabled = true
    }

    buildTypes {
        getByName(Dependencies.BuildTypes.RELEASE) {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "MapboxAccessToken", Dependencies.Config.MapboxAccessToken)
        }

        getByName(Dependencies.BuildTypes.DEBUG) {

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.Libs.kotlin)
    implementation(Dependencies.Libs.androidxCoreKtx)
    implementation(Dependencies.Libs.androidXAppcompat)
    implementation(Dependencies.Libs.androidXConstraintLayout)

    implementation(Dependencies.CommonLibs.dagger)
    implementation(Dependencies.CommonLibs.daggerAndroid)
    kapt(Dependencies.CommonLibs.daggerAndroidCompiler)
    kapt(Dependencies.CommonLibs.daggerCompiler)

    testImplementation(Dependencies.TestLibs.junit)
    testImplementation(Dependencies.TestLibs.extJUnit)
    testImplementation(Dependencies.TestLibs.espresso)

    implementation(Dependencies.CommonLibs.coroutines)
    implementation(Dependencies.CommonLibs.coroutinesAndroid)
    implementation(Dependencies.CommonLibs.arrowCore)
    implementation(Dependencies.CommonLibs.arrowSyntax)
    kapt(Dependencies.CommonLibs.arrowSyntax)

    implementation(Dependencies.CommonLibs.mapBox)
    implementation(Dependencies.CommonLibs.mapBoxAnnotation)
    implementation("com.mapbox.mapboxsdk:mapbox-android-plugin-markerview-v9:0.4.0")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("com.tbuonomo:dotsindicator:4.2")

    implementation(project(Dependencies.Modules.data))


    // jetPack
    implementation(Dependencies.JetpackLibs.lifecycleExtensions)
    implementation(Dependencies.JetpackLibs.viewModelKtx)
    implementation(Dependencies.JetpackLibs.livedataKtx)
    implementation(Dependencies.JetpackLibs.room)
    implementation(Dependencies.JetpackLibs.material)
    implementation(Dependencies.JetpackLibs.constraintLayout)
    implementation(Dependencies.JetpackLibs.navigationFragment)
    implementation(Dependencies.JetpackLibs.navigationUi)
    implementation(Dependencies.JetpackLibs.fragment)

    //TODO ("add hilt dependency injection later.")
    //dagger
    implementation(Dependencies.CommonLibs.dagger)
    implementation(Dependencies.CommonLibs.daggerAndroid)
    kapt(Dependencies.CommonLibs.daggerCompiler)
    kapt(Dependencies.CommonLibs.daggerAndroidCompiler)


    //retrofit and okhttp
    implementation(Dependencies.CommonLibs.retrofit)
    implementation(Dependencies.CommonLibs.retrofitGson)
    implementation(Dependencies.CommonLibs.okHttpInterceptor)
    implementation(Dependencies.CommonLibs.stetho)
    implementation(Dependencies.CommonLibs.stetho_OkHttp)

    //Glide

    implementation(Dependencies.CommonLibs.glide)
    kapt(Dependencies.CommonLibs.glideCompiler)

    /*
    *  implementation Libs.Jetpack.lifecycleExtensions
    implementation Libs.Jetpack.viewModelKtx
    implementation Libs.Jetpack.livedataKtx
    implementation Libs.Jetpack.room
    implementation Libs.Jetpack.material
    implementation Libs.Jetpack.constraintLayout
    *
    * */

}