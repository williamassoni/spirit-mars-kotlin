package com.assoni.mars.objects

import com.assoni.mars.enums.Direction
import com.assoni.mars.enums.Orientation
import com.assoni.mars.exceptions.InvalidLocation
import com.assoni.mars.objects.location.Location

class Robot(val location: Location, var orientation: Orientation = Orientation.NORTH) {

    fun turn(direction: Direction): Robot {
        orientation = orientation.turn(direction)
        return this;
    }

    fun walk(): Robot {
        this.location.move(this.orientation)

        if(!this.location.isValidLocation()){
            throw InvalidLocation(lat=location.latitude, long=location.longitude)
        }

        return this;
    }

    fun currentPosition(): String {
        return "(${location.latitude}, ${location.longitude}, ${orientation.key})";
    }
}



