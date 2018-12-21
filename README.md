# Ebs
Ebs Employee Service

# Requirements

* Java JDK 11
* Gradle >= 5.0
* Docker if running from docker image

Build project 

```sh
$ ./gradlew build
```

Run project

```sh
$ ./gradlew bootRun
```

Run Tests

```sh
$ ./gradlew test
```

Docker build

```sh
$ docker build -t ebs .
```

Docker run

```sh
$ docker run -p 8080:8080 ebs
```

Endpoints

Run the project and check the swagger endpoints at
- http://localhost:8080/swagger-ui.html#/
