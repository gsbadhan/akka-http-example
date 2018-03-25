package com.services

import com.core.DefaultJsonFormats
import akka.http.scaladsl.server.{ Directives, Route, RejectionHandler }
import org.slf4j.LoggerFactory
import scala.collection.Map
import akka.actor.ActorRef
import com.config.Configurations
import akka.pattern.ask
import scala.concurrent.Future
import akka.util.Timeout
import java.util.concurrent.TimeUnit
import scala.util.Success
import scala.util.Failure
import com.core.Response
import akka.http.scaladsl.model.StatusCodes
import javax.ws.rs.Path
import javax.ws.rs.GET
import akka.routing.ConsistentHashingRouter.ConsistentHashableEnvelope

class UserProfileService(userProfileActr: ActorRef) extends Directives with DefaultJsonFormats {
  private val log = LoggerFactory.getLogger("UserProfileService");
  implicit val timeout: Timeout = new Timeout(Configurations.HTTP_TIMEOUT, TimeUnit.SECONDS);

  val route: Route = {
    getUserProfile
  }

  def getUserProfile: Route =
    path("api" / "v1" / "user" / "profile" / "id" / Segment) { userId =>
      get {
        parameterMap { parameters =>
          log.info("New request from {}", userId)
          val futureHandler: Future[Any] = userProfileActr.ask(ConsistentHashableEnvelope.apply(message = Message.UserProfileById(userId), userId));
          onComplete(futureHandler) {
            case Success(data: Any) => {
              log.info("processing completed {}", userId)
              complete(StatusCodes.OK, Response.toJsonString(data))
            }
            case Failure(ex) =>
              log.error("Request failed {}", ex.getMessage)
              complete(StatusCodes.InternalServerError, Response.toJsonString("Not able to process request!!"))
          }
        }
      }
    }

}