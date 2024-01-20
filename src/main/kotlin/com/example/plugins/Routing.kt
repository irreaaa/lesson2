package com.example.plugins

import com.example.models.sensors
import com.example.routes.sensorRouting
import io.ktor.server.application.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
            sensorRouting(sensors)
        }
    }

