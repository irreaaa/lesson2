package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Sensor(
    val typeSensor: String,
    val modelSensor: String,
    val measureSensor: String,
)
val sensors = mutableListOf<Sensor>(
    Sensor("123",
        "321,",
        "231"),
    Sensor("123",
        "321,",
        "231"),
    Sensor("123",
        "321,",
        "231"),
    Sensor("123",
        "321,",
        "231"),
)