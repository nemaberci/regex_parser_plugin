plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "hu.nemaberci"
version = "1.0.0"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("hu.nemaberci:code-gen:1.0-SNAPSHOT")
}

repositories {
    mavenCentral()
    mavenLocal()
}

publishing {
    repositories {
        mavenLocal()
    }
}
