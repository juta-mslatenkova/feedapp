# Feed App

Demo Feed Homework App 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html) - Java framework which is used to build web applications.
* [MySQL](https://www.mysql.com/) - Open-Source Relational Database Management System

## Installing the application

### Configuration

- Set user and password  in WEB-INF/feed-servlet.xml for MySQL connection
- Set jdbcUrl if you are using not local MySQL DB

### Installation

There are several ways to run a Spring application on your machine. One way is to create new Tomcat Server configuration and run it from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Intellij Idea
- Open Run/Debug Configuration dialog 
- Select your application server (Tomcat)
- Add artefact for deployment: feed app:war exploded and apply configuration
- Run configuration. Application should be opened in new browser window
