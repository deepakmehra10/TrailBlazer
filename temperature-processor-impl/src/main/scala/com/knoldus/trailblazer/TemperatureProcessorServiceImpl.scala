package com.knoldus.trailblazer

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.typesafe.config.ConfigFactory
import org.slf4j.LoggerFactory

import scala.concurrent.Future

/**
  * TemperatureProcessorServiceImpl is service implementation of trait {@link TemperatureProcessorService}
  * for providing implementation of services Call methods related to the routes for TemperatureProcessor API.
  */
class TemperatureProcessorServiceImpl extends TemperatureProcessorService {

  private final val log = LoggerFactory.getLogger(classOf[TemperatureProcessorServiceImpl])

  override def health(): ServiceCall[NotUsed, String] = ServiceCall { _ =>
    log.info(s"Retrieving health of the service.")
    Future.successful("Health is up!")
  }

  override def version(): ServiceCall[NotUsed, String] = ServiceCall { _ =>
    log.info(s"Retrieving version of the service.")
    val config = ConfigFactory.load()
    val version = config.getString("service.version")
    Future.successful(s"Version is $version")
  }
}
