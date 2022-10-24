package com.assoni.mars.controll

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/mars")
class NavigationController (private var spiritNavigationService: NavigationService){

    @PostMapping(value = ["/{command}"], produces = [MediaType.TEXT_PLAIN_VALUE])
    fun navigate(@PathVariable command: String) : String {
        return spiritNavigationService.navigate(command)
    }

}
