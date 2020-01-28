#!/bin/bash

echo Customer Info: BUILDING
cd customer-info
mvn clean install -U
cd ..
clear

echo Customer Info: BUILD DONE
echo Customer Address: BUILDING
cd customer-address
mvn clean install -U
cd ..
clear

echo Customer Info: BUILD DONE
echo Customer Address: BUILD DONE
echo ---
echo Starting Application...
sudo docker-compose up --build
