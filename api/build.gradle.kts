plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("org.springframework.security:spring-security-core:6.2.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}