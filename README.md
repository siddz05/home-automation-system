# Home Automation System
Home Automation System - A full fledged home automation system with all the necessary APIs just few clicks away from converting your old home to a SMART HOME.

### Tech Stack

- Spring Boot 2.0 - Sprig JPA / Data + MVC Layer In Place 
- Gradle
- H2 InMemory Database
- Swagger 2.0
- [Git Repository](https://github.com/siddz05/home-automation-system)

### Code Flow
- Server will be up and running, on port 8081
- Health Check API : http://localhost:8081/health-check
- The Flow Starts with add a new Home, to the data base.
- Now, we have our home ready, we can add new device to the home.
- Once we have the device ready, please make sure we added the respective value in the enum (SupportedDevice.java).
- We are using the <b>Command Design Pattern</b> the basic implementation can be found in the package *(com.signz.homeautomation.command)*.
- For every Device, we need a sub package same as we have for light and tv, with the required classes make sure all the XXCommand.java classes Implements MasterCommand Interface.
- Once, we have these setup ready, all we need to do is create a getComandXX method in Command Impl class.
- We have Sample Data Ingested, for Home 1 and Home 2 With Fan and TV Device in place, for both of them.
- Light Supports: 
  1. TurnON 
  2. TurnOff
   
- Tv Supports: 
  1. Turn ON
  2. Turn Off
  3. Change Channel
  4. Change Volume
 - Visit Swagger For More Details: [Swagger](http://localhost:8081/swagger-ui.html)

## Getting Started

### Reference Problem Statement

- Home Automation
- Build a Home Automation system to remotely control devices at home. Expose a set of RESTful APIs to control the smart devices remotely. 
- Build a web console through which one can control and manage the entire system.
- To talk to devices mimic one or more libraries that just logs the action it performed. 
Scenarios
- List all smart devices
- Add new smart device
- Perform an operation on a device 
- Remove an installed device

### API Specs

- [Home Related APIs](http://localhost:8081/swagger-ui.html#/home-controller)
- [Device Related APIs](http://localhost:8081/swagger-ui.html#/device-controller)

#### Important APIs:

- [List all smart devices](http://localhost:8081/swagger-ui.html#/device-controller/getAllDeviceUsingGET)
- [Add new smart device](http://localhost:8081/swagger-ui.html#/home-controller/addDeviceInHomeUsingPUT)
- [Perform an operation on a device](http://localhost:8081/swagger-ui.html#/device-controller/executeCommandForDeviceUsingGET)
- [Install an device in home](http://localhost:8081/swagger-ui.html#/home-controller/addDeviceInHomeUsingPUT) 
- [Remove an installed device](http://localhost:8081/swagger-ui.html#/home-controller/removeDeviceFromHomeUsingDELETE)
 

### Examples
- List All Smart Device
curl -XGET http://localhost:8081/device

- Add New Smart Device
curl -X PUT \
  http://localhost:8081/home/1/device \
  -H 'Content-Type: application/json' \
  -d '{
"deviceName":"tv"
}'

- Remove A Smart Device
curl -XDELETE  localhost:8081/home/1/device/19

- Execute Command On Device
curl -XGET  http://localhost:8081/device/3/command/6

# NOTE
* We have two inbuilt homes in place: Home 1 & Home 2
* Both these Homes having two Smart Devices Installed : Light and TV
* Light Supports:
    1. On http://localhost:8081/device/3/command/7
    2. Off http://localhost:8081/device/3/command/8
    
* TV Supports:
    1. On http://localhost:8081/device/4/command/9
    2. Off http://localhost:8081/device/4/command/10
    3. Change Channel http://localhost:8081/device/4/command/11
    4. Change Volume http://localhost:8081/device/4/command/12
    
    As, you can see, 3 and 4 are device ID.
    abd 7, 8, 9, 10, 11, 12 are commands.
    
    
###### For any support please, raise a git issue or email me 
siddmit@hotmail.com :) 
