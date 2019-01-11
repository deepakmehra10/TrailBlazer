package com.knoldus.trailblazer

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Service, ServiceCall}

/**
  * TemperatureProcessorService is a trait extending {@link Service} defining service descriptor to serve the route calls
  * for TemperatureProcessing API.
  */
trait TemperatureProcessorService extends Service {

  /**
    * Gets the health of the service.
    *
    * @return ServiceCall to return the health of the service.
    */
  def health(): ServiceCall[NotUsed, String]

  /**
    * Get the current version of the service.
    *
    * @return ServiceCall to return the version of the service.
    */
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
