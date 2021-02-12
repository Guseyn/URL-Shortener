# URL-Shortener
Simple web project where you can shorten urls. 
Based on [Spring boot](https://spring.io/projects/spring-boot) and [EHTML](https://github.com/Guseyn/EHTML).

## Demo

<a href="http://www.youtube.com/watch?feature=player_embedded&v=waudpmhg8wA" target="_blank">
  <img src="http://img.youtube.com/vi/waudpmhg8wA/0.jpg" alt="IMAGE ALT TEXT HERE" width="350" height="263" border="10">
</a>

## How to run

```bash
git clone git@github.com:Guseyn/URL-Shortener.git
cd URL-Shortener
./mvnw clean install
java -jar target/urlshortener-0.0.1-SNAPSHOT.jar
```
Open [http://127.0.0.1:8080/html/index.html](http://127.0.0.1:8080/html/index.html)

## Stack of technologies

- [Spring boot](https://spring.io/projects/spring-boot) as a backend framework 
- [EHTML](https://github.com/Guseyn/EHTML) as a frontend framework
- [H2](https://www.h2database.com/html/main.html) as a database.

## Why this example is cool

1. It's based on **EHTML**, so entire logic on front-end is being written just with HTML.
2. Algorithm that shorten urls works without hash functions. It allows avoiding collisions for long urls.
3. Another good tool on **Spring boot** in combination with **H2** embedded database.
