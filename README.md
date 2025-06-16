# NextBusApp - Target Case Study

NextBusApp is a Spring Boot project that helps users find real-time bus departure info from Metro Transit using their public NextTrip API. It includes a simple web form and multiple API endpoints to get details based on route, direction, and stop.


## Project Structure

```
.
├── src
│   ├── main
│   │   ├── java/com/target/nextbus
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── model/
│   │   └── resources/templates/index.html
├── pom.xml
└── README.md
```

---

## How to Run

### Requirements

- Java 17 or 18
- Maven
- Internet connection (to call the Metro Transit API)

### Running the app

1. Go to the project root:
```bash
cd NextBusApp
```

2. Start the application:
```bash
./mvnw spring-boot:run
```

The server will run at `http://localhost:8080/`

---

## How to Test

Run unit tests with:

```bash
./mvnw test
```

Services are tested using mocks so no external API calls are made during testing.

---

## Web UI (Thymeleaf)

Go to:
http://localhost:8080/

You'll see a form where you can enter:

- Route name (like `METRO Blue Line`)
- Direction (like `north`)
- Stop name (like `Target Field Station Platform 1`)

It will return the route, direction, stop name, and next departure message.

---

## API Endpoints

All routes are under `/route`

| Method | Endpoint        | Description                        |
|--------|------------------|------------------------------------|
| GET    | `/route?name=`   | Get route info by name             |
| GET    | `/route/stop`    | Get stop code from input values    |
| GET    | `/route/next`    | Get next bus message    |
| GET    | `/route/nextbus` | Get next bus info in JSON format   |

### Example request:
```
GET /route/nextbus?route=METRO Blue Line&direction=north&stop=Target Field Station Platform 1
```

---

## Notes

- Uses WebClient to hit the Metro Transit API
- Returns clear error messages if route/direction/stop are incorrect
- Simple JavaScript + HTML frontend with Thymeleaf

---

## Author

Mustafa Ibrahim  
Target Case Study 2025
