import hu.nemaberci.generator.CodeGeneratorOrchestrator
import java.nio.file.Files
import kotlin.streams.toList

plugins {
    `java-base`
    java
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("hu.nemaberci:code-gen:1.0-SNAPSHOT")
}

sourceSets["main"].java.srcDir(file("build/generated/sources/regex"))

task("generateRegex") {
    val codeGenOrchestrator = CodeGeneratorOrchestrator()
    val srcPath = file("src").toPath()
    println(
        Files.walk(srcPath)
            .filter { !srcPath.relativize(it).startsWith("generated_sources") }
            .filter { it.fileName.toString().endsWith(".java") }.toList()
    )
    sourceSets.forEach {
        println(it)
        println("qwe123")
        it.java.srcDirs.forEach { srcDir ->
            Files.walk(srcDir.toPath())
                .filter { sourceFile -> sourceFile.fileName.toString().endsWith(".java") }
                .forEach { sourceFile ->
                    run {
                        println(file("build/generated/sources/regex").toPath()
                            .resolve(srcDir.toPath().relativize(sourceFile))
                            .toFile())
                        codeGenOrchestrator.generateParser(
                            sourceFile.toFile(),
                            file("build/generated/sources/regex")
                        )
                    }
            }
        }
    }
}

tasks.withType<JavaCompile> {
    dependsOn("generateRegex")
}
