# Backend developer test


## Goal

To implement a backend service to control an appliance implementing REST API and using a persistent storage for device status saving.


## Implementation

### Main idea

To create a microservice implementing REST API for each type of devices and additional REST-controller to get status information about all available devices.

- The microservice is going to use Spring Boot as application container.
  Each device is going to use its own REST-controller with GET and PUT request handlers.
  GET is for getting status unformation about particular device.
  PUT is used to change current status of the device (like a command).

- The persistent storage is MongoDB.
  It is going to create a separate repo for each type of device.

- Functionality of the REST-controllers has to be covered by unit-tests.
  The repos methods have to be covered by unit-tests too.


### Requirements

- Java 1.8
- MongoDB

	
