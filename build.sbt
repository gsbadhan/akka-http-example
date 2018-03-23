name := "akka-http-example"
/*lazy val app = (project in file("app")).
  settings(
  	organization := "com.http",
  	test in assembly := {},
    mainClass in assembly := Some("com.http.start.App")    
  )
*/
assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case PathList("reference.conf") => MergeStrategy.concat
 case x => MergeStrategy.first
}

version := "1.0"

scalaVersion := "2.12.4"
val akkaVersion = "2.5.8"
val scalaLoggingVersion = "3.7.1"
val akkaHttpVersion = "10.1.0-RC1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor" % akkaVersion,
	"com.typesafe.akka" %% "akka-remote" % akkaVersion,
	"com.typesafe.akka" %% "akka-cluster" % akkaVersion,
	"com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
    "com.github.romix.akka" %% "akka-kryo-serialization" % "0.5.1",
	"io.swagger" % "swagger-jaxrs" % "1.5.16",
    "com.github.swagger-akka-http" %% "swagger-akka-http" % "0.11.0",
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.google.code.gson" % "gson" % "2.3.1",	
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion ,
	"com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
	"ch.megard" %% "akka-http-cors" % "0.2.2",
	"org.slf4j" % "slf4j-api" % "1.7.25",
	"ch.qos.logback" % "logback-classic" % "1.2.3",
	"com.typesafe.akka" %% "akka-slf4j" % akkaVersion
		
)


libraryDependencies ++= Seq(
	"org.scalatest" %% "scalatest" % "3.0.4" % "test",
	"junit" % "junit" % "4.12" % Test,   
	"com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "test" ,	
	"com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test"
)
