# Take Home Challenge: Music Info API

## Overview
This exercise is meant to showcase your technical implementation & design abilities. It is expected that you will fork this repository in GitHub and share the link with us when complete. Please be prepared to explain the design. 

For the purposes of the exercise, pretend you're on a team working on a new website that customers can use to look up information about music. Other team members are handling the front end, but you're working on the back-end API.

## Instructions
Using Java8, and SpringBoot create a REST API with the following endpoints using the Controller Service Repository design pattern:

- Create a song
- Read a song
- Update a song
- Delete a song

The data model for the song should look something like this, and be stored in one of [mongo, mysql, H2]. 

```
{
    "isrc": "<string>",
    "title": "<string>",
    "artist": "<string>",
    "musicians": [
        {
            "name": "<string>",
            "contribution": "<string>"
        }
    ]
}
```

Unit tests should be created for the controller and service methods. 

## Bonus Instructions
1. Whenever a song is added, an asynchronous method should post the information to [webhook.site](https://webhook.site/). 
2. Have the application running in a Docker container. 


## Application Readme
This repository makes use of `Spring Data Rest` and `SpringDoc OpenApi` to quickly and effectively create and 
document Rest APIs whose purpose is to access database resources. For the purposes of this assessment we will be using
an in-memory `H2` database in order to persist our database entities. 

***Please Note:*** As of right now there is no service layer
within the application, in contradiction to the assessment specifications. The controller layer has been abstracted out thanks to
`Spring Data Rest` and the repository layer is found in the repository package. 

In order to start the app run `gradle clean build bootRun` from the project root

In order to start the app via `docker` use from the root of the project the following commands
1. `gradle clean build`
2. `docker build -t my-application .`
3. `docker run -p 8080:8080 my-application`

Please access the below URL for access to the swagger-ui in order to try out each
endpoint provided by `Spring Data Rest`.

`http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#`