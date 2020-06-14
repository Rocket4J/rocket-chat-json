/*
 * This file is part of rocket-chat-json.
 *
 * rocket-chat-json is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * rocket-chat-json is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with rocket-chat-json.  If not, see <https://www.gnu.org/licenses/>.
 */
plugins {
    java

    id("com.github.ben-manes.versions") version "0.28.0"
}

group = "org.dreamexposure"
version = "0.1.0"

val immutablesVersion: String by extra("2.8.8")
val jacksonVersion: String by extra("2.11.0")
val junitVersion: String by extra("5.6.2")

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.immutables:value:$immutablesVersion")
    annotationProcessor("org.immutables:value:$immutablesVersion")

    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = sourceCompatibility
}

tasks {
    test {
        useJUnitPlatform()
    }

    dependencyUpdates {
        gradleReleaseChannel = "current"
    }

    wrapper {
        gradleVersion = "6.5"
        distributionType = Wrapper.DistributionType.ALL
    }
}
