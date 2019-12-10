# spring-petclinic-mybatis
 [![Build Status](https://cloud.drone.io/api/badges/artificerpi/spring-petclinic-mybatis/status.svg)](https://cloud.drone.io/artificerpi/spring-petclinic-mybatis)

  [![Sonarcloud Status](https://sonarcloud.io/api/project_badges/measure?project=artificerpi_spring-petclinic-mybatis&metric=alert_status)](https://sonarcloud.io/dashboard?id=artificerpi_spring-petclinic-mybatis) 
 [![SonarCloud Coverage](https://sonarcloud.io/api/project_badges/measure?project=artificerpi_spring-petclinic-mybatis&metric=coverage)](https://sonarcloud.io/component_measures/metric/coverage/list?id=artificerpi_spring-petclinic-mybatis)
 [![SonarCloud Bugs](https://sonarcloud.io/api/project_badges/measure?project=artificerpi_spring-petclinic-mybatis&metric=bugs)](https://sonarcloud.io/component_measures/metric/reliability_rating/list?id=artificerpi_spring-petclinic-mybatis)
 [![SonarCloud Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=artificerpi_spring-petclinic-mybatis&metric=vulnerabilities)](https://sonarcloud.io/component_measures/metric/security_rating/list?id=artificerpi_spring-petclinic-mybatis)

[中文](./README-zh.md)

This backend version of the Spring Petclinic application only provides a REST API. **There is no UI**.

The [spring-petclinic-angular project](https://github.com/spring-petclinic/spring-petclinic-angular) is a Angular front-end application witch consumes the REST API.

## Understanding the Spring Petclinic application with a few diagrams
<a href="https://speakerdeck.com/michaelisvy/spring-petclinic-sample-application">See the presentation here</a>

## Sample Feature Lists
*Compared to original version*

* Java Project based on `gradle`
* MyBatis Integration
* Springfox - Swagger UI Docs
* Spring Rest Docs Integration
* Drone CI automation
* SonarCloud Integration and code analysis


## Running petclinic locally
```bash
git clone https://github.com/artificerpi/spring-petclinic-mybatis.git
cd spring-petclinic-mybatis
docker-compose up -d
gradle bootRun
```

You can then access petclinic here: http://localhost:9966/petclinic/

* Swagger REST API documentation presented here (after application start):
<a href="http://localhost:9966/petclinic/swagger-ui.html">http://localhost:9966/petclinic/swagger-ui.html</a>

### Integrate it with `spring-petclinic-angular`

```bash
npm uninstall -g angular-cli @angular/cli
npm cache clean
npm install -g @angular/cli@latest

git clone https://github.com/spring-petclinic/spring-petclinic-angular.git

cd spring-petclinic-angular
npm install
ng serve
```

Screenshot of the Angular 5 client

*Tested: it's working with Anuglar 8 as well*

<img width="1427" alt="spring-petclinic-angular2" src="https://cloud.githubusercontent.com/assets/838318/23263243/f4509c4a-f9dd-11e6-951b-69d0ef72d8bd.png">


## Disclaimer
This project is a fork of [spring-petclinic-rest](https://github.com/spring-petclinic/spring-petclinic-rest.git), but the persisstent has been replaced with MyBatis. There are lots of modifications on original codes.
