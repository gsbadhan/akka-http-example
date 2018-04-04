
## Akka HTTP Example with clustering

### compile:
sbt clean update compile

### build jar:
sbt clean assembly

### skip test case while assembly:
sbt 'set test in assembly := {}' clean assembly


## APIs:

#### 1. user profile by id : "http:127.0.0.1:2828/api/v1/user/profile/id/101"

#### 2. update user's profile : "http:127.0.0.1:2828/api/v1/user/id/101"
##### 2.a body: {"name":"john","location":"ca"}

#### 3. update user's name : "http:127.0.0.1:2828/api/v1/user/id/101/update/name/john"


