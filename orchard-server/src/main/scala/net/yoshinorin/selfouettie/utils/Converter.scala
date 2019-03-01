package net.yoshinorin.orchard.utils

import java.time.{Instant, ZoneId, ZoneOffset, ZonedDateTime}
import net.yoshinorin.orchard.types.EventType

object Converter {

  implicit class eventTypeConverter(s: String) {

    def toEventType: EventType = {
      s match {
        case "CreateEvent" => EventType.CreateEvent
        case "DeleteEvent" => EventType.DeleteEvent
        case "ForkEvent" => EventType.ForkEvent
        case "IssueCommentEvent" => EventType.IssueCommentEvent
        case "IssuesEvent" => EventType.IssuesEvent
        case "PullRequestEvent" => EventType.PullRequestEvent
        case "PullRequestReviewEvent" => EventType.PullRequestReviewEvent
        case "PullRequestReviewCommentEvent" => EventType.PullRequestReviewCommentEvent
        case "PushEvent" => EventType.PushEvent
        case "ReleaseEvent" => EventType.ReleaseEvent
        case "WatchEvent" => EventType.WatchEvent
        case _ => EventType.Undefined //TODO: throw Exception is better?
      }
    }

  }

  implicit class zonedDateTimeConverter(l: Long) {
    def toZonedDateTime: ZonedDateTime = {
      ZonedDateTime.ofInstant(Instant.ofEpochSecond(l), ZoneOffset.UTC)
    }
  }

}