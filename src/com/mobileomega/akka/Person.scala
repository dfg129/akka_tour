package com.mobileomega.akka


import akka.actor.{ActorLogging, Actor}

class Person extends Actor with ActorLogging {
    def receive = {
    case FullPint(number) => log.info(s"Thanks for pint $number")
    Thread.sleep(1000)
    log.info(s"ready for another after $number")
    sender ! EmptyPint    
  }
}