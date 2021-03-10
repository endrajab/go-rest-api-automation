# go-rest-api-automation

Project for QAE Take home test

## Project Structure
* `src/test/resouces/` directory:
    * `features` directory: Contains all feature file with contains scenario (Writing using gherkin language Cucumber)
* `wiresrc/test/java/com/endrajab/gorestapi` directory:
    * `steps`directory: Contains all definitions of the steps for gherking language
    * `model`directory: Contains all request and response model
    * `common` directory: java class for initiate request API
    * `wiremock-standalone-2.27.1.jar`: Wiremock jar file for Docker image
* `target` directory: Contains serenity report. This directory will show after run the test script.
* `README.md`: Project readme    


## Requirement

The following is list of project dependency.

* [Maven](https://maven.apache.org/)


## Installation

1. Install Maven


## Clone Test Repo
  
```
git clone git@github.com:endrajab/go-rest-api-automation.git
```

    
## How to Run Test Script
  

From Terminal change active directory to `go-rest-api-automation`
  
```
cd go-rest-api-automation
```

Run newman with the following command format
  
```
mvn clean verify -DTOKEN=<token>
```
e.g
```
mvn clean verify -DTOKEN=186b676368adfb9bc8ddf8986395be24a673f9dcbc042b1544e9b2273a34c2a4
```

## See Test Report

After run the test script, it will generate report stored in directory:

```
target/site/serenity/
```
Open index.html file in browser

