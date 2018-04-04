package com.services

import akka.actor.Actor
import akka.actor.ActorLogging
import scala.collection.mutable.Map
import scala.collection.mutable.HashMap
import akka.http.scaladsl.model.DateTime
import java.util.Date
import spray.json.JsObject

class UserProfileActor extends Actor with ActorLogging {
  log.info("UserProfileActor instance created {}", this);

  def receive = {
    case userProfile: Message.UserProfileById => { sender().!(getUserProfile(userProfile)) }

    case newProfile: Message.UpdateUserProfile => { sender().!(updateProfile(newProfile)) }

    case updateName: Message.UpdateUserName => { sender().!(updateUserName(updateName)) }
  }

  private def getUserProfile(msg: Message.UserProfileById): Map[String, String] = {
    var data: Map[String, String] = new HashMap();
    data.+=(("userId", msg.userId), ("timestamp", new Date().toString()), ("route", this.toString()))
    return data
  }

  private def updateUserName(msg: Message.UpdateUserName): Map[String, String] = {
    var data: Map[String, String] = new HashMap();
    data.+=(("userId", msg.userId), ("name", msg.name), ("timestamp", new Date().toString()), ("route", this.toString()))
    return data
  }

  private def updateProfile(msg: Message.UpdateUserProfile): JsObject = {
    return msg.data.asJsObject;
  }

}