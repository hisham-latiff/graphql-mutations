<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->




<!-- PROJECT LOGO -->
<br />
<div align="center">

<h3 align="center">GraphQL Using Default Scalar and Custom Scalar Spring Boot Demo Application</h3>

</div>





<!-- ABOUT THE PROJECT -->
## About The Project

[//]: # ([![Product Name Screen Shot][product-screenshot]]&#40;https://example.com&#41;)

This Project Demostrate Basic GraphQL Implementation in Spring Boot using on-memory database H2.
The data example use in this project illustrate the data of Book that have aggregation relation with Review data that will be manipulated using GraphQL Mutation.

The List of packages that will be defined in this project:-
1. Model - Data representation of project.
2. Repository - Interface that will be used to interact with data in DB.
3. Controller - Definition of functions to be executed upon GraphQL query call.
 





### Built With

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

* Maven
* Java





<!-- GETTING STARTED -->
## Getting Started



### Prerequisites

This project require Java Development Kit.
* Java JDK 17


### Installation

_Below is the installation instruction for this project._

[//]: # (1. Get a free API Key at [https://example.com]&#40;https://example.com&#41;)
1. Clone the repo
   ```sh
   git clone git@github.com:hisham-latiff/graphql-mutations.git
   ```
2. Install JDK and JRE
    - Installer file can be found at Java Website
    - Update Environment for JAVA_HOME
   ```sh
    %JAVA_HOME% = <jdk-directory> 
   ```


3. Build and run with `maven`. Make sure you are in project root directory.
   ```cmd
    mvnw spring-boot:run
   ```




## Querying GraphQL

_Below is the querying instruction for this project._

[//]: # (1. Get a free API Key at [https://example.com]&#40;https://example.com&#41;)
1. Open browser and go to      <a href="http://localhost:8181/graphiql">https://localhost:8181/graphiql</a>

2. Before Running Make sure <a href="https://github.com/hisham-latiff/GraphQL-in-Spring-Boot-Demo/blob/4d10287b5a03ac65b1ed7c89a936372f842a0cea/src/main/resources/application.properties">application.properties</a> file contains:-
   ```sh
    spring.datasource.name=books
    spring.h2.console.enabled=true
    spring.jpa.show-sql=true
    spring.graphql.servlet.enabled=true
    spring.graphql.graphiql.enabled=true
   ```
3. Mutation Querying GraphQL operation createBook.

   ```sh
    mutation CreateBook {
        createBook(title: "My new book", pages: 99, author: "Dan Vega") {
            id
            title
            pages
            author
        }
   }
   ```


4. Upon query success, graphql will return the data created in json object structure as below.
   ```json
      {
           "data": {
               "createBook": {
                   "id": "2",
                   "title": "My new book",
                   "pages": 99,
                   "author": "Dan Vega"
               }
           }
      }

   ```
   
5. Mutation Querying GraphQL operation addBook.

   ```sh
    mutation AddBook {
        addBook(book: { title: "My New Book", pages: 199, author: "Dan Vega" }) {
            id
            title
            pages
            author
        }
   }
   ```
   
6. Upon query success, graphql will return the data added in json object structure as below.
   ```json
      {
          "data": {
              "addBook": {
              "id": "3",
              "title": "My New Book",
              "pages": 199,
              "author": "Dan Vega"
              }
          }
      }

   ```
   
7. Mutation Querying GraphQL operation batchCreate.

   ```sh
    mutation BatchCreate {
        batchCreate(
            books: [
                { title: "Batch Book 1", pages: 99, author: "New Author" }
                { title: "Batch Book 2", pages: 99, author: "New Author" }
                { title: "Batch Book 3", pages: 99, author: "New Author" }
                { title: "Batch Book 4", pages: 99, author: "New Author" }
                { title: "Batch Book 5", pages: 99, author: "New Author" }
            ]
        ) {
              id
              title
              pages
              author
          }
   }
   ```
   
8. Upon query success, graphql will return the data created in json object structure as below.
   ```json
      {
          "data": {
              "batchCreate": [
                  {
                       "id": "4",
                       "title": "Batch Book 1",
                       "pages": 99,
                       "author": "New Author"
                  }, ...
              ]
          }
      }

   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>













