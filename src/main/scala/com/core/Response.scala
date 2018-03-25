package com.core

import com.google.gson.Gson
import com.google.gson.JsonParser
import scala.collection.mutable.Map
import scala.collection.JavaConverters._

object Response {

  def toJsonString(data: Any): String = {
    if (data.isInstanceOf[Map[String, String]]) {
      return toMapString(data.asInstanceOf[Map[String, String]]);
    } else if (data.isInstanceOf[String]) {
      return toJsonString(data.toString());
    }
    return "";
  }

  private def toMapString(data: Map[String, String]): String = {
    return new JsonParser().parse(new Gson().toJson(data.asJava)).getAsJsonObject.toString();
  }

  private def toString(data: String): String = {
    return new JsonParser().parse(new Gson().toJson(data)).getAsJsonObject.toString();
  }

}