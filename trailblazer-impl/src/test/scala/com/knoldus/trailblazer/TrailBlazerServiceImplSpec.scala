package com.knoldus.trailblazer

import com.lightbend.lagom.scaladsl.server.LocalServiceLocator
import com.lightbend.lagom.scaladsl.testkit.ServiceTest
import org.scalatest.{AsyncWordSpec, BeforeAndAfterAll, Matchers}

class TrailBlazerServiceImplSpec extends AsyncWordSpec with Matchers with BeforeAndAfterAll {

  private val server = ServiceTest.startServer(ServiceTest.defaultSetup
    .withCassandra(true)) { ctx =>
    new TrailBlazerApplication(ctx) with LocalServiceLocator
  }

  val client = server.serviceClient.implement[TrailBlazerService]

  override protected def afterAll() = server.stop()

  "Trailblazer service" should {

    "should retrieve health of the service" in {
      client.health().invoke().map { response =>
        response should ===("Health is up!")

      }
    }
  }

  "Trailblazer service" should {

    "should retrieve version of the service" in {
      client.version().invoke().map { response =>
        response should ===("Version is 1.0.0-SNAPSHOT")

      }
    }
  }
}
