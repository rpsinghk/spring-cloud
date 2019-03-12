#!/bin/bash
./springcloud-datacenter stop
docker ps -a | grep springcloud | awk '{ print $1 }' | xargs docker rm && docker ps -a
docker images | egrep '(springcloud|none)' | awk '{ print $3 }' | xargs docker rmi  && docker images

clean='clean'

mvn $clean package -P docker

docker images | grep springcloud
./springcloud-datacenter start && ./springcloud-datacenter logs 

