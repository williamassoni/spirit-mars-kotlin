package com.assoni.mars.objects

import com.assoni.mars.enums.Direction
import com.assoni.mars.exceptions.InvalidCommand
import org.springframework.util.StringUtils

class Instruction (command: String) {
    var commands: List<String>

    init {
        if(!StringUtils.hasText(command)) {
            throw InvalidCommand(command)
        }

        this.commands = command.split("").filter { it.isNotBlank() }
    }

    fun execute(robot: Robot) : Robot {
        return commands
                .map{
                    if(it == "M") return@map robot.walk()

                    var direction = Direction.extract(it)?: throw InvalidCommand(it)
                    return return@map robot.turn(direction)
                }
                .reduce{ _, b -> b }
    }
}
