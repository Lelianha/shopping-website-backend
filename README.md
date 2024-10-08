<a id="readme-top"></a>

<br>

<div align="center" >
  <img src="./images/Logo-README.png" alt="Logo" width="140" height="80">
  <h3 align="center"> Luxe Bags Shopping Website</h3 >
</div>

<br>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

## About The Project <img src="./images/bagIcon.png" width="30" height="30" />

Handbags are essential accessories for women, adding both style and charm.
LuxeBags was created with every woman's mood in mind,
offering a diverse selection to match any occasion, outfit, or personal taste

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With

![Java][java.com]

Java is one of the most popular programming languages in the world,
Java is a high-level, object-oriented programming language based on the concept of
"objects" and Data classes, so we can find them in a variety of technological fields such as:
Web applications, web servers, application servers, Database connection.


![SpringBoot][SpringBoot.com]

Spring Boot is an open-source, microservice-based Java web framework.
The Spring Boot framework creates a fully production-ready environment that is completely configurable using its prebuilt code within its codebase.
Also, it is just an extension of the already existing and expansive Spring frameworks,
but it has some specific features that make the application easier for working within the
developer ecosystem.


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->

## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites

List of things you need to use to run the project and the way to install each of them.

1. Download the free version of IntelliJ IDEA called  - Community Edition

[![IntelliJ IDEA][IntelliJIDEA.com]][IntelliJIDEA-url] 

2. download the JDK (Java Development Kit) version 11 from [JDK-11][jdk11-url]
<br><br>
3. In the build.gradle file should add the following external libraries:
   * implementation 'org.springframework.boot:spring-boot-starter'
   * implementation 'org.springframework.boot:spring-boot-starter-web'
   * implementation 'org.springframework.boot:spring-boot-starter-actuator'<br><br>

4. To view and query the database you can browse to [H2-console][H2console-url]

### Installation

List of steps you need to do to run the project.
1. Clone the repository
   ```sh
   git clone https://github.com/Lelianha/shopping-website-backend.git
   ```
2. Go to the created file `shopping-website-backend`
   ```sh
   cd shopping-website-backend
   ```
3. Install dependencies
   ```sh
   mvn install
   ```
4. Run the project
   ```sh
   mvn spring-boot:run
   ```
5. Access the application <br/>
   Open your browser and navigate to http://localhost:8080 to access the backend API.
<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Usage

In this project, we use java as a programing language and spring boot as a framework to create our microservice,
this project is used to save the website users' information and the details of their orders,
so we saved these details in the java class inside the model directory and organized them in tables that contain columns with the help of the repository and SQL,
These tables we access to show them using the H2 console.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contact

My Name - Lelian Hassn
<br>
My G-mail - Lelianhassn8514@gmail.com
<br>
Project
Link - [shopping-website-backend.git][project-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Acknowledgments

List of resources we find helpful and would like to give credit to!

* [GitHub Pages][gitHubPages-url]
* [JavadevJournal][JavadevJournal-url]
* [YouTube Channels][YouTubeChannels-url]
  <br><br><p align="right">(<a href="#readme-top">back to top</a>)</p><br><br>
  **Finally, I want to thank my teacher Ben Meir for the helpful GitHub
  repositories, [If you want to take a look at it click on the GitHub link][BenMeir-url]**

[java.com]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white
[springBoot.com]: https://img.shields.io/badge/springboot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white
[IntelliJIDEA.com]: https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white
[IntelliJIDEA-url]: https://www.jetbrains.com/idea/download/?source=google&medium=cpc&campaign=9730674410&term=intellij%20idea&content=602143185274&gclid=Cj0KCQiApKagBhC1ARIsAFc7Mc5_XB27foC3X3tIPLEXHfE-hwSQhp3J3sbWIODl4QaBGiWeE9t5AWUaAkcMEALw_wcB#section=windows
[jdk11-url]: https://www.oracle.com/il-en/java/technologies/javase/jdk11-archive-downloads.html
[H2console-url]: http://localhost:8080/h2-console
[project-url]: https://github.com/Lelianha/shopping-website-backend.git
[gitHubPages-url]:https://pages.github.com
[JavadevJournal-url]:https://www.javadevjournal.com/spring-boot/
[YouTubeChannels-url]: https://www.youtube.com/watch?v=msXL2oDexqw&list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x
[BenMeir-url]: https://github.com/benmeirr
