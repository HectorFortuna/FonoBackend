plugins {
	java
	jacoco
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.hectorfortuna.fonoBack"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
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
	implementation ("io.springfox:springfox-boot-starter:3.0.0")
	implementation ("org.postgresql:postgresql:42.5.1")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.withType<Test> {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
}

tasks {
	getByName<JacocoReport>("jacocoTestReport") {
		reports {
			xml.required.set(true)
			html.required.set(true)
		}
		afterEvaluate {
			classDirectories = files(classDirectories.files.map {
				fileTree(it) {
					include(
						"com/hectorfortuna/fonoBack/FonoBackend/controller/**",
						"com/hectorfortuna/fonoBack/FonoBackend/service/**"
					)
				}
			})
		}
	}
}
