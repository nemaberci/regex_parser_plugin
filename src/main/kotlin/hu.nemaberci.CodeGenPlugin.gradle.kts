plugins {
    `java-base`
    `java-library`
    java
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    annotationProcessor("hu.nemaberci:code-gen:1.0-SNAPSHOT")
    api("hu.nemaberci:regex-api:1.0-SNAPSHOT")
}

