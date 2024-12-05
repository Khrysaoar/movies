# Movie Director API

This project is a simple API that allows you to query movie directors that directed movies more than threshold. 
It uses Spring Boot and includes Swagger for API documentation and JUnit for testing.

## Features
- Get a list of directors with directed movies more than the threshold.
- The API supports pagination.
- Unit tests using JUnit 5.
- Swagger UI to interact with the API.

## Project Structure

- **Model**: Contains `Movie` and `MovieResponse` objects.
- **Service**: Contains the business logic for filtering directors that directed movies more than the given threshold.
- **Controller**: Exposes the API endpoints for getting directors.

## Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/movies-api.git
    cd movies-api
    ```

2. Install dependencies:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

4. Access Swagger UI:
   Open your browser and go to `http://localhost:8080/swagger-ui/index.html` to explore and interact with the API.

## API Endpoints

### `GET /api/directors`

Fetch list of the names of the directors with most movies directed. Specifically, the list of names 
of directors with movie count strictly greater than the given threshold. 

#### Parameters:
- `threshold` (query parameter): integer denoting the threshold value for the number movies a person has directed.

#### Example:
```bash
GET http://localhost:8080/api/directors?threshold=4

#### NOTE:
![image](https://github.com/user-attachments/assets/8d9d5ad1-ecab-4c71-bf64-60b62f421e1b)

- for `Martin Scorsese`, I checked the API, and there are only 4 movies that he directed. So he will not be included in the result if we use 4 as a threshold because we fetch the ones who directed movies more that the threshold. In this case, 4.
