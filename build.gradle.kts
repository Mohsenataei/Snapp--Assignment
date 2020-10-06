// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.3.72")

    repositories {
        mavenCentral()
        google()
        jcenter()
        maven { setUrl("https://maven.google.com") }
        maven { setUrl("https://jitpack.io") }
    }
    dependencies {
        classpath (Config.BuildPlugins.androidGradle)
        classpath (Config.BuildPlugins.kotlinGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { setUrl ("https://dl.bintray.com/arrow-kt/arrow-kt/") }

    }
}

tasks.register("clean" , Delete::class){
    delete(rootProject.buildDir)
}
