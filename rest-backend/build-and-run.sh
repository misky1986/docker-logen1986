#!/usr/bin/env bash
mvn clean install

docker build -t misky1986/rest-backend .
#docker run -d -p 8080:8080 misky1986/rest-backend