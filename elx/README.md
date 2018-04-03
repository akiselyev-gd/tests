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
  
  Endpoints:
  
      - /appliances
             GET - get a list of all available devices;
             PUT - add new device;
             
      - /ovens/id
             GET - get status of an oven with particular id;
             PUT - change status of the oven;
             
      - /washmachines/id
             GET - get status of a wash machine with particular id;
             PUT - change status of the wash machine;

- The persistent storage is MongoDB.
  It is going to create a separate repo for each type of device.

- Functionality of the REST-controllers has to be covered by unit-tests.
  The repos methods have to be covered by unit-tests too.
  
- Bash scripts with `curl` as integration tests.
  It will be located into exl/tools directory.


### Requirements

- Java 1.8
- MongoDB


## How to build

`cd elx`

`./gradle/gradle-4.6/bin/gradle clean build`

## How to run

`./gradle/gradle-4.6/bin/gradle run`
