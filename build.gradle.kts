buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
    }
}

plugins {
    id("org.jetbrains.intellij") version "0.4.15"
}

apply(plugin = "java")
apply(plugin = "kotlin")

version = "1.16"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.61")
    testImplementation("junit:junit:4.12")
}


intellij {
    pluginName = "Gradle Dependencies Helper"
    version = "LATEST-EAP-SNAPSHOT"
    updateSinceUntilBuild = false
    setPlugins("java", "Groovy", "gradle", "gradle-java", "Kotlin")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
}

tasks {
    wrapper {
        gradleVersion = "6.0.1"
    }
}
