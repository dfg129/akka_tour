package com.mobileomega.akka

import akka.actor.{Actor, Props, ActorSystem}

sealed class Subscriber(f: (String Any) => Unit) extends Actor {
  override def receiver = { case (topic: String, payload: Any) => f(topic, payload) }
}

class EventStream {
  val system = ActorSystem("event_system")
  
  def subscribe(f: (String, Any) => Option[Unit], name: String) = {
    val props = Props(classOf[subscriber], f)
    val subscriber = system.actorOf(props, name = name)
    system.eventStream.subscribe(subscriber, classOf[String, Any)])
  }

}