# Country Weather Service

Microservizio Spring Boot che integra dati da REST Countries API e Open-Meteo API per fornire informazioni meteorologiche aggiornate sulla capitale di un paese.

## Funzionalità

- Recupera informazioni paese (capitale, popolazione, valuta, bandiera)
- Ottiene dati meteorologici aggiornati per la capitale
- Persistenza dei dati in database H2
- Aggiornamento di metadati aggiuntivi (visited, notes, rating)
- Documentazione API automatica con OpenAPI/Swagger

## Tecnologie

- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database
- OpenFeign
- Springdoc OpenAPI
- Maven
- Docker

## Come eseguire

### Prerequisiti
- Java 21
- Maven 3.6+
- Docker (opzionale)

### Con Maven

mvn clean package
java -jar target/country-weather-app-0.0.1-SNAPSHOT.jar

Con Docker
bash
docker build -t country-weather-app .
docker run -p 8080:8080 country-weather-app
Endpoint API
Recupera informazioni meteo paese
text
GET /country-weather/{countryName}
Esempio: GET /country-weather/Italy

Response:

json
{
  "countryName": "Italy",
  "capital": "Rome",
  "population": 59554023,
  "currency": "EUR",
  "flagPng": "https://flagcdn.com/w320/it.png",
  "weather": {
    "temperature": 24.5,
    "weatherCode": 1,
    "retrievedAt": "2025-06-30T12:34:56.789"
  },
  "visited": true,
  "notes": "Bellissimo paese",
  "rating": 5
}
Aggiorna metadati paese
text
PUT /country-weather/{countryName}
Esempio: PUT /country-weather/Italy

json
{
  "visited": true,
  "notes": "Da visitare in primavera",
  "rating": 5
}
