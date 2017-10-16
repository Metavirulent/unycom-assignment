# uny-service

This is the application's REST APIs

## Demo Address
https://uny-service.alioktay.org

## Getting started

### Prerequisites

You need to have JDK 8 and Maven in your local machine

### Build & Run
Download source code from here. Run the code below on the working directory
```
mvn spring-boot:run
```
or
```
mvn clean install
java -jar ./target/uny-service-0.0.1-SNAPSHOT.jar
```
Now open your browser and type http://localhost:8080/

### Running tests
```
mvn test
```

## Docker
Additionally, you can build and run this project with docker

### Build & Run
```
docker build . -t alioktay/uny-service
docker run -d -p 8080:8080 -t alioktay/uny-service
```


## Built With
* [Spring Boot](https://projects.spring.io/spring-boot/) - Java Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [H2](http://www.h2database.com/html/main.html) - In-Memory Database


## Author
**Ali Oktay** - *alioktay@gmail.com* - [Github](https://github.com/alioktay)