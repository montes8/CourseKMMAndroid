
buildscript {

    dependencies {
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.5")
    }
}
plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.1").apply(false)
    id("com.android.library").version("7.4.1").apply(false)
    id("com.google.dagger.hilt.android") version "2.44" apply false
    kotlin("android").version("1.8.10").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
