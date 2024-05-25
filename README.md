# Firebase Auth With Spring WebFlux

This project demonstrates how to integrate Firebase Authentication with a Spring WebFlux application. It shows how to decode Firebase tokens, extract user information, and use it within a reactive Spring Boot application.

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Troubleshooting](#troubleshooting)
- [License](#license)

## Overview

This project integrates Firebase Authentication with a Spring WebFlux backend. It allows for secure authentication and authorization of users through Firebase, utilizing Spring Security and WebFlux for reactive programming.

## Prerequisites

- JDK 17 or higher
- Maven 3.6.3 or higher
- A Firebase project with Firebase Authentication enabled

## Setup

1. Clone the repository:
```sh
    git clone https://github.com/nosetr/firebase-auth-webflux.git
    cd firebase-auth-webflux
```

2. Add your Firebase Admin SDK private key JSON file to the `src/main/resources` directory and rename it to `firebase-service-account.json`.

3. Set the necessary environment variables:

```sh
    export FIREBASE_KEY=[Web-API-Key from your project]
```

5. Set the necessary environment variables for the tests:

```sh
    export FIREBASE_USER_ID=[ID from test user]
    export FIREBASE_EMAIL=[email from test user]
    export FIREBASE_PASSWORD=[password from test user]
```

### Setting Environment Variables in Eclipse

To set environment variables in Eclipse:

1. Right-click on your project and select `Run As` -> `Run Configurations...`.
2. In the left pane, select `Java Application` and choose your application's run configuration.
3. Go to the `Environment` tab.
4. Click `New...` and add each environment variable (`FIREBASE_KEY`, `FIREBASE_USER_ID`, `FIREBASE_EMAIL`, `FIREBASE_PASSWORD`) with their corresponding values.
5. Click `Apply` and then `Run`.

### Setting Environment Variables in IntelliJ IDEA

To set environment variables in IntelliJ IDEA:

1. Open `Run` -> `Edit Configurations...`.
2. Select your run configuration (or create a new one if necessary).
3. In the `Configuration` tab, find the `Environment variables` field.
4. Click the `...` button and add each environment variable (`FIREBASE_KEY`, `FIREBASE_USER_ID`, `FIREBASE_EMAIL`, `FIREBASE_PASSWORD`) with their corresponding values.
5. Click `OK` and then `Apply`.

## Running the Application

To run the application, use the following command:

```sh
	mvn spring-boot:run
```

## Usage

You can interact with the application by sending HTTP requests to the defined endpoints. Use a tool like Postman or cURL to test the endpoints.

## Endpoints

A cURL request to the Firebase Authentication endpoint to sign in with email and password:

```bash
curl -X POST \
  'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=[YOUR_FIREBASE_KEY]' \
  -H 'Content-Type: application/json' \
  -d '{
    "email": "[YOUR_FIREBASE_EMAIL]",
    "password": "[YOUR_FIREBASE_PASSWORD]",
    "returnSecureToken": true
  }'
```

POST /api/auth/user: Verifies the Firebase token and retrieves user information.

Request:

```json
{
		"token": "your_firebase_token_here"
}
```

Response:

```json
{
		"uid": "user_id",
		"name": "user_name"
}
```

## Testing

The application includes tests to ensure the Firebase authentication flow works as expected.

## Troubleshooting

If you encounter issues, consider the following steps:

- Ensure your Firebase Admin SDK JSON file is correctly placed and named.
- Verify your Firebase project configuration in the application.yml file.
- Check the logs for any error messages and stack traces.
- Make sure your dependencies are up to date by running mvn clean install.

## License

This project is licensed under the MIT [License](LICENSE). See the LICENSE file for details.
