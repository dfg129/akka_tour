package com.mobileomega.akka

import akka.actor.{ActorSystem, ActorLogging, Actor, Props}

case class Ticket(quantity: Int)
case class EmptyPint(number: Int)
case class FullPint(number: Int)


object AkkaLook1 extends App {
  val system = ActorSystem("actor-look-1")
  
  val zed = system.actorOf(Props(new BarTender), "zed")
  
  val alice = system.actorOf(Props(new Person), "alice")
  val bob = system.actorOf(Props(new Person), "bob")
  val charlie = system.actorOf(Props(new Person), "charlie")
  
  zed.tell(Ticket(2), alice)
  zed.tell(Ticket(3), bob)
  zed.tell(Ticket(1), charlie)
  
  system.awaitTermination()
}