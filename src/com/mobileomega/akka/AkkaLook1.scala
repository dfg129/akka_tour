package com.mobileomega.akka

import akka.actor.{ActorSystem, ActorLogging, Actor, Props}

case object Pint

class Person extends Actor with ActorLogging {
    def receive = {
    case Pint => log.info("Thanks for the pint")
    case _ => log.info("received unknown message")
  }
}

object AkkaLook1 extends App {
  val system = ActorSystem("actor-look-1")
  
  val alice = system.actorOf(Props(new Person), "alice")
  
  alice ! Pint

  
  system.shutdown()
}