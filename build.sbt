name := "gatling-sample"

scalaVersion := "2.11.8"

enablePlugins(GatlingPlugin)

val gatlingVersion = "2.2.3"
libraryDependencies ++= Seq(
		"io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % "test",
		"io.gatling"            % "gatling-test-framework"    % gatlingVersion % "test"
)
