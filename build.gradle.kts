plugins {
    id("java")
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"



}
application {
    mainClass.set("main.Reigns")
}
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "main.Reigns"
    }
}
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.9")
}

