package com.core

import akka.http.scaladsl.server.RouteConcatenation
import akka.actor.ActorSystem
import com.config.Configurations
import akka.stream.ActorMaterializer
import com.services.UserProfileActor
import akka.actor.ActorRef
import akka.actor.Props
import akka.routing.FromConfig
import akka.http.scaladsl.server.Route
import com.services.UserProfileService

trait ServiceRouting extends RouteConcatenation {
  //initiate akka actor system
  implicit val akkaSystem: ActorSystem = ActorSystem(Configurations.APP_NAME, Configurations.config);
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = akkaSystem.dispatcher
  
  //initiate actor
  val userProfileActor: ActorRef = akkaSystem.actorOf(Props[UserProfileActor].withRouter(FromConfig()), "userProfile")

  //initiate route
  val route: Route = new UserProfileService(userProfileActor).route;
}