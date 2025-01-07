extra["swagger-ui.version"] = "5.3.1"
extra["springdoc.version"] = "1.6.14"

plugins {
    java
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.1.5"
    id("org.openapi.generator") version "7.4.0"
}
val testcontainersVersion by extra("1.19.8")

group = "org.open-banking.com"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
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
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("org.springframework.data:spring-data-commons")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.14")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    testImplementation("io.rest-assured:rest-assured:4.2.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mysql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}
dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:$testcontainersVersion")
    }
}

tasks.named("openApiGenerate", org.openapitools.generator.gradle.plugin.tasks.GenerateTask::class) {
    generatorName = "spring"
    inputSpec = "${layout.projectDirectory}/src/main/resources/open-api/account-info-openapi.yaml"
    outputDir = "${layout.buildDirectory.get()}/generated/open-banking"
    invokerPackage = "com.open-banking.invoker"
    modelPackage = "com.open-banking.model"
    apiPackage = "com.open-banking.api"
    additionalProperties.put("interfaceOnly", "true")
    additionalProperties.put("basePackage", "com.open-banking")
}

// TASKS

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("copyGeneratedModelIntoProject", Copy::class) {
    copy {
        from("${layout.buildDirectory.get()}/generated/open-banking/src/main/java/com/open_banking/model")
        into("${layout.projectDirectory}/src/main/java/org/openbanking/com/model/external")
        include("**/*")
        dependsOn("openApiGenerate")
    }
}

//tasks.bootRun {
//    dependsOn( "openApiGenerate")
//}

tasks.build {
    dependsOn( "copyGeneratedModelIntoProject")
}