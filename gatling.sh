#!/bin/sh

cd $(dirname $0)

export TARGET_ADDRESS=10.146.0.4
export GATLING_GRAPHITE_HOST=10.146.0.5

sbt gatling:test \
  -Dgatling.application.baseUrl=http://${TARGET_ADDRESS} \
  -Dgatling.application.pasueTime=1ms \
  -Dgatling.application.rampUsers=50000 \
  -Dgatling.application.duration=5m \
  > /dev/null
