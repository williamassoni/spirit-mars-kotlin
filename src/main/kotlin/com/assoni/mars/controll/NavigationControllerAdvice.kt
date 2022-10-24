package com.assoni.mars.controll

import com.assoni.mars.exceptions.InvalidCommand
import com.assoni.mars.exceptions.InvalidLocation
import com.assoni.mars.objects.location.Wold
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class NavigationControllerAdvice {

    @ExceptionHandler
    fun handleInvalidCommandException(ex: InvalidCommand) : ResponseEntity<String> {
        return ResponseEntity("The following command ${ex.command} is either empty is not valid {R - L - M}", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleInvalidLocationException(ex: InvalidLocation) : ResponseEntity<String> {
        return ResponseEntity("The robot has been thrown out of the world range lat(${ex.lat}) long(${ex.long}) wold limits: lat(${Wold.WoldLimit.MAX_LATITUDE}) long(${Wold.WoldLimit.MAX_LONGITUDE})", HttpStatus.BAD_REQUEST)
    }
}
