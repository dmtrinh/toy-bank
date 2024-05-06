# Toy Bank

## Dependencies
This service is dependent on Mongo.  The [local-stack](https://github.com/dmtrinh/local-stack) repo has Mongo and other dependencies pre-wired for local development.

## Getting Started

### Building

Run `gradlew` to build and run unit tests locally; two default tasks will be executed: `assemble` and `test` 
```shell
./gradlew
```

Run the `buildImage` Gradle task to create a local Docker image:
```shell
./gradlew buildImage
```

### Running

To use the standard Spring Boot-Gradle tasks (e.g. `bootRun`, `bootTestRun`), the following environment variables will need to be set:
   *  `MONGODB_URI`
   *  `CACHING_SERVICE_ENDPOINT`

Optionally, for capturing trace information, set:
   *  `ZIPKIN_ENDPOINT`

**For a quicker setup**, use [local-stack](https://github.com/dmtrinh/local-stack) and then one of these two options:

#### Option #1: Docker Compose
```shell
docker compose up
```

This will instantiate the previously built container for this microservice and join it to the same `local-stack-network`.

#### Option #2: application-local.yaml config for Spring Boot
The [application-local.yaml](application-local.yaml) has been pre-wired to work with [local-stack](https://github.com/dmtrinh/local-stack):

```shell
./gradlew bootRun --args='--spring.config.location=application-local.yaml'
```

Alternatively, you can also use the custom `bootRunLocal` task:
```shell
./gradlew bootRunLocal
```

## API 
### POST /payments

Sample request:
```
{
  "originator": {
    "name1": "FinTech Client",
    "line1": "123 Main Street",
    "city": "New York",
    "state": "NY",
    "postalCode": "10001",
    "country": "US",
    "phone": "406-999-9999",
    "entityType": "INDIVIDUAL",
    "email": "john.doe@client.com"
  },
  "originatingAccount": {
    "bank": {
      "address": {
        "line1": "255 2nd Ave South",
        "city": "MINNEAPOLIS",
        "state": "MN",
        "postalCode": "55479",
        "country": "US"
      },
      "routingNumber": "121000248"
    },
    "accountNumber": "123456789066"
  },
  "counterparty": {
    "name1": "Sesame Street Enterprises",
    "line1": "123 Sesame Street",
    "city": "Manhattan",
    "state": "NY",
    "postalCode": "10001",
    "country": "US",
    "entityType": "ORGANIZATION",
    "email": "contactus@sesamestreet.org"    
  },
  "counterpartyAccount": {
    "bank": {
      "address": {
        "line1": "270 PARK AVENUE",
        "city": "NEW YORK",
        "state": "NY",
        "postalCode": "10017",
        "country": "US"
      },
      "routingNumber": "021000021",
      "name": "JPMORGAN CHASE BANK NA"
    },
    "accountNumber": "06461990462"
  },
  "amount": 664266.00
}
```