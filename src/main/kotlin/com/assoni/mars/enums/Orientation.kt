package com.assoni.mars.enums

enum class Orientation(val key: String) {
    NORTH("N") {
        override fun turn(direction: Direction): Orientation {
            return if(Direction.RIGHT == direction) EAST else WEST
        }
    }, SOUTH("S") {
        override fun turn(direction: Direction): Orientation {
            return if(Direction.RIGHT == direction) WEST else EAST
        }
    }, WEST("W") {
        override fun turn(direction: Direction): Orientation {
            return if(Direction.RIGHT == direction) NORTH else SOUTH
        }
    }, EAST("E") {
        override fun turn(direction: Direction): Orientation {
            return if(Direction.RIGHT == direction) SOUTH else NORTH
        }
    };

    abstract fun turn(direction: Direction): Orientation;
}
