plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.4"
}

group = "com.zcom"
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

intellij {
    version.set("2023.1")
    type.set("IC")
    plugins.set(listOf("com.intellij.java"))
}

tasks.named("initializeIntelliJPlugin") {
    enabled = false
}

tasks {
    patchPluginXml {
        sinceBuild.set("231")
        untilBuild.set("241.*")
    }
}
