package com.config

import org.slf4j.LoggerFactory
import com.typesafe.config.ConfigFactory
import java.io.File

object Configurations {
  private val log = LoggerFactory.getLogger("Configurations");

  val applicationConfig = ConfigFactory.load();
  log.info(s"application configs ${applicationConfig}");
  val resourcePath = applicationConfig.getString("application.resource.path");
  log.info(s"loading resource files from ${resourcePath}");
  val actorConf = ConfigFactory.parseFile(new File(resourcePath + "/actors.conf"));
  log.info(s"actors configs ${actorConf}");
  val combineAllConfig = actorConf.withFallback(applicationConfig);
  val config = ConfigFactory.load(combineAllConfig);

  val HTTP_IP: String = config.getString("application.httpserver.ip")
  val HTTP_PORT: Int = config.getInt("application.httpserver.port")
  val HTTP_TIMEOUT:Long = config.getLong("application.httpserver.timeout")
}