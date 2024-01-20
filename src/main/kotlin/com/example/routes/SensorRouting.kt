package com.example.routes

import com.example.models.Sensor
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.server.response.*

fun Routing.sensorRouting(sensors: MutableList<Sensor>) {
    route("/sensor"){
        get {
            call.respond(com.example.models.sensors)
        }
        get("{model}") {
            val id = call.parameters["model"]
            call.respond(sensors.first { it.modelSensor == id.toString() })
        }
        post{
            val sensor = call.receive<Sensor>()
            sensors.add(sensor)
            call.respond(sensor)
        }
        put{
            val sensor = call.receive<Sensor>()
            val replaceIndex = sensors.indexOfFirst {
                it.modelSensor == sensor.modelSensor
            }
            sensors[replaceIndex] = sensor
            call.respond(sensors)
        }

        delete ("{model}") {
            val model = call.parameters["model"]
            call.respondText(
                sensors.removeIf{
                    it.modelSensor == model
                }.toString()
            )

        }
    }
}