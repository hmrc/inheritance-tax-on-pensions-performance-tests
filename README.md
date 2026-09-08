
# inheritance-tax-on-pensions-performance-tests


Template of a performance test repository

### Address lookup setup

Run the IHTP frontend with its test-only router enabled:

```sh
sbt -Dplay.http.router=testOnlyDoNotUseInAppConf.Routes run
```

The performance environment's frontend service profile must also include `-Dplay.http.router=testOnlyDoNotUseInAppConf.Routes`. This router must never be enabled in production.

The scenarios enter PR names in normal mode and check the address redirect without following it. They then GET `/inheritance-tax-on-pensions/test-only/S2400000001/seed-pr-address`, using the current session, and require a `204` response before continuing to the payment-notice question. This populates a test address through IHTP without contacting Address Lookup Frontend. The same URL can be opened in a browser after signing in and entering the PR details; a successful `204` response has no page content.

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

### . WARNING
Do **NOT** run a full performance test against staging from your local machine

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html").
