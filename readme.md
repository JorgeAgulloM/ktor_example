![Descripción de la imagen](https://ktor.io/docs/images/ktor_logo_dark.svg)

## Simple test of creating a backend with ktor

#### Configured for testing on Localhost

```html
    http://127.0.0.1:8080
```
## REST access:
```java
    @Get
```
<br>

## Base url
##### Return OK:

```java
    "200"
```
```html
    Hello World!
```

<br>

## /user
##### Response

```java
    "200"
```
```json
    {
        "id": 0,
        "name": "Jorge Agulló",
        "age": 40,
        "email": "agullojorge@mail.com"
    },
    {
        "id": 1,
        "name": "SoftYorch",
        "age": 1,
        "email": "softyorch@mail.com"
    }
```

<br>

## /user/1
##### Response
```java
    "200"
```
```json
    {
        "id": 1,
        "name": "SoftYorch",
        "age": 1,
        "email": "softyorch@mail.com"
    }
```

<br>

### REST access:
```java
    @Post
```
## /user
##### body requies
```json
    {
        "id": 2,
        "name": "prueba",
        "age": 56,
        "email": "prueba@mail.com"
    }
```
##### Response
```java
    "200"
```
```html
    User successfully created
```
<br>

### REST access:
```java
    @Delete
```

## /user/2
##### Response
```java
    "200"
```
```html
    User successfully deleted
```

