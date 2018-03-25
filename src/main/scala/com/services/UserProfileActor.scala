package com.services

import akka.actor.Actor
import akka.actor.ActorLogging
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import akka.http.scaladsl.model.DateTime
import java.util.Date

class UserProfileActor extends Actor with ActorLogging {
  log.info("UserProfileActor instance created {}", this);

  def receive = {
    case msg: Message.UserProfileById => {
      sender().!(someRawData(msg))
    }
  }

  private def someRawData(msg: Message.UserProfileById): Map[String, String] = {
    var data: Map[String, String] = new HashMap();
    data.+=(("userId", msg.userId), ("timestamp", new Date().toString()))
    return data
  }

}