package com.assoni.mars.objects.location

import com.assoni.mars.enums.Orientation

class Location(private val wold: Wold, var latitude: Long, var longitude: Long) {

    fun move(orientation: Orientation) : Location {
        when(orientation) {
            Orientation.NORTH -> longitude++
            Orientation.SOUTH -> longitude--
            Orientation.EAST -> latitude++
            Orientation.WEST -> latitude--
        }

        return this
    }

    fun isValidLocation(): Boolean {
        return this.wold.isValidLatitude(this.latitude) && this.wold.isValidLongitude(this.longitude)
    }
}
