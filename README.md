# DevNews

## Project Description

In this project we will be building the backend for a developer news site where users can create articles, comment them and categorize the articles by topics. 

## Technologies and tools

* Spring (boot)
* PostgreSQL
* Postman or curl (for API testing)
* Docker

## (Setup) 

the project is Initialize by using [Spring initializer](https://start.spring.io/). Using gradle and java 11 and the following dependencies:
                                  
* Spring Web
* Spring JPA
* PostgreSQL Driver

by using 'docker-compose up' command you can start the container and run the program on the IDE.

## (Articles)

By using Postman or curl you create a REST API for articles with the following specification:

| HTTP Method | HTTP Path | Action |
| ------------|-----------|--------|
| `GET` |`/articles` | return all articles. |
| `GET` | `/articles/{id}` | return a specific article based on the provided id.|
| `POST`| `/articles` | create a new article.|
| `PUT` | `/articles` | update the given article.|
| `DELETE` | `/articles` | delete the given article.|

## (Comments)

You can create a REST API for comments with the following specification:

| HTTP Method | HTTP Path | Action |
| ------------|-----------|--------|
| `GET` |`/comments` | return all comments. |
| `GET` | `/comments?articleId={articleId}` | return all comments with the given `articleId`.|
| `POST`| `/comments` | create a new comment.|
| `PUT` | `/comments` | update the given comment.|
| `DELETE` | `/comments` | delete the given comment.|

## (Topics)

Create a REST API for topics with the following specification:

| HTTP Method | HTTP Path | Action |
| ------------|-----------|--------|
| `GET` |`/topics` | return all topics. |
| `GET` | `/topics?articleId={articleId}` | return all topics related with the given `articleId`.|
| `POST`| `/topics` | create a new topic.|
| `PUT` | `/topics` | update the given topic.|
| `DELETE` | `/topics` | delete the given topic.|
| `GET` |`/articles?topicId={topicId}` | return all articles with the given `topicId`. |

