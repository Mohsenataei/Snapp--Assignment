plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
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

    buildTypes {
        getByName(Config.BuildTypes.RELEASE) {
            isMinifyEnabled =  false
            proguardFiles (getDefaultProguardFile ("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Config.Libs.kotlin)
    implementation(Config.Libs.androidxCoreKtx)
    implementation(Config.Libs.androidXAppcompat)
    implementation(Config.Libs.androidXConstraintLayout)

    testImplementation(Config.TestLibs.jUnit)
    testImplementation(Config.TestLibs.extJUnit)
    testImplementation(Config.TestLibs.espresso)
}