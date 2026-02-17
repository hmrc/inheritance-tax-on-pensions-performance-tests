
# inheritance-tax-on-pensions-performance-tests


Template of a performance test repository

### Smoke test

It might be useful to try the journey with one user to check that everything works fine before running the full performance test

### Run the performance test Locally: Smoke test
```
sbt -DrunLocal=true -Denvironment=local -Dperftest.runSmokeTest=true Gatling/test

```

### Run the performance test Locally: test
```
sbt -DrunLocal=true -Denvironment=local -Dperftest.runSmokeTest=false Gatling/test
```

### Run the performance test against Staging: Smoke test
```
sbt -DrunLocal=false -Dperftest.runSmokeTest=true Gatling/test
```

### Run the performance test against Staging: test
 ```
 sbt -DrunLocal=false -Dperftest.runSmokeTest=false Gatling/test
 ```

### Start Mongo Docker container as follows:
docker run --rm -d --name mongo -d -p 27017:27017 mongo:4.0

```

This is a placeholder README.md for a new repository

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").