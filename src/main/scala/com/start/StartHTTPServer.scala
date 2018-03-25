package com.start

import org.slf4j.LoggerFactory
import com.config.Configurations
import com.core.ServiceRouting
import akka.http.scaladsl.Http

object StartHTTPServer extends App with ServiceRouting  {
  private val log = LoggerFactory.getLogger("StartHTTPServer")

  Http().bindAndHandle(route, Configurations.HTTP_IP, Configurations.HTTP_PORT);

  log.info(s"starting AppServer on IP:${Configurations.HTTP_IP}, PORT:${Configurations.HTTP_PORT}")
}