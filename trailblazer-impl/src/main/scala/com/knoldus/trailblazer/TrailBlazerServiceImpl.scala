package com.knoldus.trailblazer

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.typesafe.config.{Config, ConfigFactory}
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.Future

/**
  * The TrailBlazerServiceImpl class
  */
class TrailBlazerServiceImpl extends TrailBlazerService {

  private final val log: Logger = LoggerFactory.getLogger(classOf[TrailBlazerServiceImpl])

  /**
    * Health of the service.
    *
    * @return
    */
  override def health(): ServiceCall[NotUsed, String] = ServiceCall { _ =>
    log.info(s"Retrieving health of the service.")
    Future.successful("Health is up!")
  }

  /**
    * Current version of the application.
    *
    * @return
    */
  override def version(): ServiceCall[NotUsed, String] = ServiceCall { _ =>
    log.info(s"Retrieving version of the service.")
    val config: Config = ConfigFactory.load()
    val version: String = config.getString("service.version")
    Future.successful(s"Version is $version")
  }
}
