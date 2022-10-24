package com.assoni.mars.enums

enum class Direction(val key: String) {
    RIGHT("R"),
    LEFT("L");

    companion object {
        fun extract(cmd: String): Direction? {
            return values().firstOrNull { it.key.uppercase() == cmd.uppercase()}
        }
    }
}
