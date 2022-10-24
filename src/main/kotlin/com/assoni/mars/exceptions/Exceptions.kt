package com.assoni.mars.exceptions

class InvalidLocation(var lat: Long, var long: Long) : RuntimeException() {

}

class InvalidCommand(var command: String) : RuntimeException() {

}
