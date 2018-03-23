
### compile:
sbt clean update compile

### build jar:
sbt clean assembly

### skip test case while assembly:
sbt 'set test in assembly := {}' clean assembly

