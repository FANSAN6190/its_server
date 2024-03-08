plugins {
    java
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.its"
version = "0.0.1-SNAPSHOT"

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
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("jakarta.json:jakarta.json-api:2.0.1")
    implementation("io.github.cdimascio:java-dotenv:5.2.0")
    implementation("org.json:json:20240303")
    implementation("org.postgresql:postgresql:42.7.2")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.hibernate:hibernate-core:6.4.1.Final")

}


tasks.withType<Test> {
    useJUnitPlatform()
}
