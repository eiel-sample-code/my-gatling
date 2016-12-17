enablePlugins(JavaAppPackaging)

name         := "akka-http-hello"
organization := "info.eiel"
version      := "1.0"
scalaVersion := "2.12.0"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV       = "2.4.14"
  val akkaHttpV = "10.0.0"
  Seq(
    "com.typesafe.akka" %% "akka-actor"                           % akkaV,
    "com.typesafe.akka" %% "akka-http-core"          % akkaHttpV
  )
}
