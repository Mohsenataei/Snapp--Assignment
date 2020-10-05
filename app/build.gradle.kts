plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    buildToolsVersion(Config.Android.buildToolsVersion)

    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdkVersion(Config.Android.minSdkVersion)
        targetSdkVersion(Config.Android.targetSdkVersion)
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dataBinding {
        isEnabled = true
    }

    buildTypes {
        getByName(Config.BuildTypes.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    implementation(Config.Libs.kotlin)
    implementation(Config.Libs.androidxCoreKtx)
    implementation(Config.Libs.androidXAppcompat)
    implementation(Config.Libs.androidXConstraintLayout)
    implementation(Config.CommonLibs.dagger)
    testImplementation(Config.TestLibs.jUnit)
    testImplementation(Config.TestLibs.extJUnit)
    testImplementation(Config.TestLibs.espresso)

    implementation(Config.CommonLibs.coroutines)
    implementation(Config.CommonLibs.coroutinesAndroid)
    implementation(Config.CommonLibs.arrowCore)
    implementation(Config.CommonLibs.arrowSyntax)
    kapt(Config.CommonLibs.arrowSyntax)

    // jetPack
    implementation(Config.JetpackLibs.lifecycleExtensions)
    implementation(Config.JetpackLibs.viewModelKtx)
    implementation(Config.JetpackLibs.livedataKtx)
    implementation(Config.JetpackLibs.room)
    implementation(Config.JetpackLibs.material)
    implementation(Config.JetpackLibs.constraintLayout)

    //TODO ("add hilt dependency injection later.")
    //dagger
    implementation(Config.CommonLibs.dagger)
    implementation(Config.CommonLibs.daggerAndroid)
    kapt(Config.CommonLibs.daggerCompiler)
    kapt(Config.CommonLibs.daggerAndroidCompiler)


    //retrofit and okhttp
    implementation(Config.CommonLibs.retrofit)
    implementation(Config.CommonLibs.retrofitGson)
    implementation(Config.CommonLibs.okHttpInterceptor)
    implementation(Config.CommonLibs.stetho)
    implementation(Config.CommonLibs.stetho_OkHttp)

    //Glide

    implementation(Config.CommonLibs.glide)
    kapt(Config.CommonLibs.glideCompiler)

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