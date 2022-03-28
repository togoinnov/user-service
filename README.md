# user-service
User management service

## Prerequisites
### Local
* [Java 18 SDK](http://www.oracle.com/java/technologies/downloads/)
* [Maven](https://maven.apache.org/download.cgi)


### Docker
* [Docker](https://www.docker.com/get-docker)

## Starting the service
### Starting the postgres database docker image
```bash
$ cd docker && docker-compose -f docker-compose.yml up
```

### Compile he user-service
```bash
$ mvn clean install
```
### Start the service
right-click on `UserServiceApplication.java` and `Run 'UserServiceApplication'`

## Testing the service
Go to: http://localhost:8080/swagger-ui/index.html to test the API
