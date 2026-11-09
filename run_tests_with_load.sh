#!/bin/bash

sbt -Dperftest.runSmokeTest=false -DrunLocal=true -Dperftest.loadPercentage=5 -Dperftest.labels=journeyFlows gatling:test

