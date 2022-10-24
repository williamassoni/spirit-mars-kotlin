package com.assoni.mars.spiritmarskotlin.unit

import com.assoni.mars.enums.Orientation
import com.assoni.mars.exceptions.InvalidCommand
import com.assoni.mars.objects.Instruction
import com.assoni.mars.objects.Robot
import com.assoni.mars.objects.location.Location
import com.assoni.mars.objects.location.Wold
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.function.Consumer

internal class InstructionUnitTest {

    @Test
    fun should_throw_exception_when_empty_command() {
        Assertions.assertThatThrownBy { Instruction("") }.isExactlyInstanceOf(InvalidCommand::class.java)
    }

    @Test
    fun should_split_command_in_order() {
        var commands = Instruction("MMRMMRMM")
        assertThat(commands.commands).asList().containsExactly("M","M","R","M","M","R","M","M")
    }

    @Test
    fun should_throw_exception_when_unknow_command() {
        var location = Location(Wold(), 0L, 0L)
        var robot = Instruction("R").execute(Robot(location))

        Assertions.assertThatThrownBy { Instruction("T").execute(robot) }.isExactlyInstanceOf(InvalidCommand::class.java)
    }

    @Test
    fun should_change_direction_for_right() {
        val robotRequirements = Consumer<Robot> { robot: Robot ->
            assertThat(robot.currentPosition()).contains(Orientation.EAST.key)
        }

        var location = Location(Wold(), 0L, 0L)
        var robot = Instruction("R").execute(Robot(location))

        assertThat(robot).satisfies(robotRequirements)
    }

    @Test
    fun should_change_direction_for_left() {
        var robotRequirements = Consumer<Robot> {robot: Robot ->
            assertThat(robot.currentPosition()).contains(Orientation.WEST.key)
        }

        var location = Location(Wold(), 0L, 0L)
        var robot = Instruction("L").execute(Robot(location))

        assertThat(robot).satisfies(robotRequirements)
    }
}
