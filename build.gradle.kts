import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.22"
    id("java-library")
    id("maven-publish")
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    group = "moe.rafal"
    version = "1.0-SNAPSHOT"

    sourceSets {
        main {
            java {
                setSrcDirs(listOf("src/main/kotlin"))
            }
        }

        test {
            java {
                setSrcDirs(listOf("src/test/kotlin"))
            }
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        withJavadocJar()
        withSourcesJar()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }

    repositories {
        mavenCentral()
    }

    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>("library") {
                    pom {
                        name.set(project.name)
                        from(components.getByName("java"))
                    }
                }
            }
        }
    }
}

subprojects {
    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")
    }

    dependencies {
        testImplementation("org.awaitility:awaitility:4.2.0")
        testImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")
        testImplementation(kotlin("test"))
    }

    tasks.test {
        useJUnitPlatform()
    }
}

repositories {
    mavenCentral()
}