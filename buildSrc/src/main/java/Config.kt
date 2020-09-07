object Config {
    object Versions {
        const val kotlin = "1.3.72"
        const val gradle = "4.0.0"
    }
    object BuildPlugins {
        const val androidGradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Android {
        const val buildToolsVersion = "30.0.1"
        const val minSdkVersion = 21
        const val targetSdkVersion = 29
        const val compileSdkVersion = 29
        const val applicationId = "com.mohsen.architecture"
        const val versionMajor = 1
        const val versionMinor = 1
        const val versionPatch = 9
        const val versionCode = 1
        const val versionName = "1.0"
    }

    object BuildTypes {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    object Libs {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val androidxCoreKtx = "androidx.core:core-ktx:1.3.1"
        const val androidXAppcompat = "androidx.appcompat:appcompat:1.2.0"
        const val androidXConstraintLayout = "androidx.constraintlayout:constraintlayout:2.0.1"
    }

    object TestLibs{
        const val jUnit = "junit:junit:4.12"
        const val extJUnit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

}