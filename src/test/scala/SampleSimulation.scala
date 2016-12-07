import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._

trait ApplicationConfig {
  val conf: Config = ConfigFactory.load("application.conf").getConfig("gatling.application")

  def getDuration(path: String): FiniteDuration = {
    conf.getDuration(path).toMillis millisecond
  }


  val baseUrl: String = conf.getString("baseUrl")
  val users: Int = conf.getInt("rampUsers")
  val duration: FiniteDuration = getDuration("duration")
  val pause: FiniteDuration = getDuration("pauseTime")
}

class SampleSimulation extends Simulation {
  val conf = new ApplicationConfig {}

  val httpConf: HttpProtocolBuilder = http
    .baseURL(conf.baseUrl)

  val scn: ScenarioBuilder = scenario("Simple Test")
      .forever {
        exec(http("root request").get(""))
      }

  setUp(
    scn.inject(rampUsers(conf.users) over conf.duration)
  ).protocols(httpConf).maxDuration(conf.duration)
}
