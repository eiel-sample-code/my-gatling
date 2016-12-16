#!/bin/sh

cd $(dirname $0)

export TARGET_ADDRESS=10.146.0.4
export GATLING_GRAPHITE_HOST=10.146.0.5

# sbt が停止してしまうので対策
screen -dm -S gat bash -c "sbt gatling:test \
  -Dgatling.application.baseUrl=http://${TARGET_ADDRESS} \
  -Dgatling.application.pasueTime=1s \
  -Dgatling.application.rampUsers=2000 \
  -Dgatling.application.duration=2m &> /dev/null"
