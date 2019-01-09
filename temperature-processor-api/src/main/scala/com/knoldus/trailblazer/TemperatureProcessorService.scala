package com.knoldus.trailblazer

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

/**
  * The TrailBlazerService trait.
  */
trait TemperatureProcessorService extends Service {

  def health(): ServiceCall[NotUsed, String]

  def version(): ServiceCall[NotUsed, String]

  override final def descriptor = {
    import Service._
    // @formatter:off
    named("trailblazer")
      .withCalls(
        restCall(Method.GET, "/api/temperature-processor/health", health _),
        restCall(Method.GET, "/api/temperature-processor/version", version _),
      )
      .withAutoAcl(true)
    // @formatter:on
  }

}
