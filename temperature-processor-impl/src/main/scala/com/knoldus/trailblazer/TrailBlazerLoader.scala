package com.knoldus.trailblazer

import com.lightbend.lagom.scaladsl.api.Descriptor
import com.lightbend.lagom.scaladsl.client.ConfigurationServiceLocatorComponents
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext, LagomApplicationLoader}
import com.softwaremill.macwire.wire
import play.api.libs.ws.ahc.AhcWSComponents

/**
  * The class TrailBlazerLoader uses LagomApplicationLoader to load the application and does the
  * the binding of modules at runtime.
  */
class TrailBlazerLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new TrailBlazerApplication(context) with ConfigurationServiceLocatorComponents {

    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new TrailBlazerApplication(context) with LagomDevModeComponents

  override def describeService: Option[Descriptor] = Some(readDescriptor[TemperatureProcessorService])

}

abstract class TrailBlazerApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer = serverFor[TemperatureProcessorService](wire[TemperatureProcessorServiceImpl])

}
