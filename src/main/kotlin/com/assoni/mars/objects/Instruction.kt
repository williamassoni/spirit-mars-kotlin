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
        return commands.map{ moveToNewLocation(it, robot)}.reduce{ _, b -> b }
    }

    private inline fun moveToNewLocation(cmd: String, robot: Robot): Robot {
        if(cmd == "M") {
            return robot.walk()
        }

        var direction= Direction.extract(cmd) ?: throw InvalidCommand(cmd)
        return robot.turn(direction)
    }
}
