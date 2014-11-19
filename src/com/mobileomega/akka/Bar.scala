package com.mobileomega.akka

object Bar {
val onEvent = (topic: String, payload: Any) => Some(topic) collect {
  case "topic B" => 
    println("Bar received: topic = " + topic + "payload = " + payload)
    com.mobileomega.akka.EventStream.publish("topic C", "payload C")
  }
}