package com.services

import spray.json.JsObject

object Message {
  case class UserProfileById(userId: String)
  case class UpdateUserProfile(userId: String, data: JsObject)
  case class UpdateUserName(userId: String, name: String)
}