# API Challenge

Design and create a RESTful API that could be used to manage a list of dog images. 

# Requirements

The operations we expect to see would be:

* List all of the available dog pictures grouped by breed
* List all of the available dog pictures of a particular breed
* Vote up and down a dog picture
* The details associated with a dog picture

The information the Dog Breed App needs to function is:

* A URL to a dog picture
* The number of votes a picture has received
* The dog's breed
* Any other information required to identify a specific dog

The Dog Breed App expects the response to be sorted by the number of votes a picture has received.

The API responses must be in JSON.

## Additional Voting Requirements

Each client is allowed to vote once for any particular dog picture.

# Setup

We provide you with a starter Spring Boot project. The project is already configured go use Spring MVC and talks to an 
in memory HSQLDB to store the results. Jackson is already included to provide JSON serialization and deserialization.

The Spring Boot Starter Test module is included to facilitate both unit and integration tests.

Please follow these steps:

* Clone api_challenge to your local workstation.
* Follow the instructions on the home page of your private repository to initialize it on your local workstation.
* Copy the code from the local copy of api_challenge to initialize your private repository.
* Push the copied code to the remote of your private repository.
* Push your edits to your private repository as you go

## Dependencies

- Maven
- Java 8

## Checking Out the Project

```
$ git clone https://gitlab.com/disney-vincentbenjamin/api_challenge.git
```

## Building

```
$ mvn package
```

## Running

You can run the app through Maven:

```
$ mvn spring-boot:run
```

or you can run the jar file from the build:

```
$ java -jar target/api_interview-0.1.0.jar
```

## Running in a Container

As you can see, the Dockerfile contains the information needed to create an image and running it. This is great since it allows us to test that the application runs regardless of our environment setup. 

Dockerfile is where we define the docker image and specify all the configurations required to run the app.

To build the image you can run:
 
```
$ docker build -t hacosta-apichallenge .
```

You can now see the list of all the docker images on your system using the following command: 

```
$ docker image ls 
```


Once the image has been build, you can run the application:
 
```
$ docker run -p 8080:8080 hacosta-apichallenge 
```

You can start the container in the background using detached mode. When you run: 

```
$ docker run -d -p 8080:8080 hacosta-apichallenge
```

This gives you the container ID. You can see a list of your containers by running: 

```
$ docker container ls
```


# Build, Deployment and Running

While this falls outside of the challenge, please consider the following as you get ready to discuss your solution with the team:

* How would you package this for deployment?
* How and where would you deploy this app?
* How can you tell that the app is up and running?
* How would you configure the app as it goes from dev, to qa and finally to production?
* How would you insulate the app from a downstream API if it had one.

# How to submit an authenticated request for the voting endpoints

The system uses a basic authentication example for Spring Boot. In particular, it uses the dependency:

In order to exercise that scenario, you can generate a header using a service like this:
https://www.blitter.se/utils/basic-authentication-header-generator/

The username is 'user' and the password 'password'...

Then, it must be sent as a header. This is how we know if the user has voted already or not. 

```xml
   <dependency>
      <groupId>org.springframework.security</groupId>
      <artifactId>spring-security-config</artifactId>
   </dependency>

   <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
   </dependency>
```

# Running the Test Cases

This project has added support for Cucumber. The features requested in the requirements section have been defined using Gherkin Syntax inside `src/test/resources/features` folder. 

In order to run the test cases, you can run: 
```
$ mvn clean install -Pintegration
```

# Submitting the Project

You will also receive an invitation to your own private repository on gitlab.com. Push your code to that repository as you go. Instructions are provided by gitlab.com on how to push your code to a new repo.

# Duration

In our tests, we found it to take us about 4 to 6 hours to build, however, we encourage you to spend enough time to polish/document/test your app. Commit times will be considered when ranking your solutions but meeting all requirements is paramount.  Please email us when all requirements are met.
The timestamp of your last commit will be used to gage how long you worked on this project.