#!/usr/bin/env bash

function getAllItems {

    echo ""
    echo "Get information about all available ovens"
    curl -X GET http://localhost:8080/appliances/ovens
}


###################################################
getAllItems

###################################################
echo ""
echo "Add new oven with id = 1000"

curl -H "Content-Type: application/json" -X POST -d '{"deviceId":1000,"type":"TEST OVEN"}'  http://localhost:8080/appliances/ovens

###################################################
getAllItems

###################################################
echo ""
echo "Change status the oven"

curl -H "Content-Type: application/json" -X PUT -d '{"deviceId":1000, "type":"TEST OVEN", "status": "TESTED"}'  http://localhost:8080/appliances/ovens/1000

###################################################
getAllItems

###################################################
echo ""
echo ""