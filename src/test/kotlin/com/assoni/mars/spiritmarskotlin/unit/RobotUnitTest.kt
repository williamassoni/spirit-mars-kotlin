package com.assoni.mars.spiritmarskotlin.unit

import com.assoni.mars.enums.Direction
import com.assoni.mars.enums.Orientation
import com.assoni.mars.exceptions.InvalidLocation
import com.assoni.mars.objects.Robot
import com.assoni.mars.objects.location.Location
import com.assoni.mars.objects.location.Wold
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.function.Consumer

internal class RobotUnitTest {

    @Test
    fun should_begin_in_default_location() {
        var robotRequirements = Consumer {robot: Robot ->
            assertThat(robot.location.latitude).isEqualTo(0L)
            assertThat(robot.location.longitude).isEqualTo(0L)
            assertThat(robot.currentPosition()).contains(Orientation.NORTH.key)
        }

        var location = Location(Wold(), 0L, 0L)
        assertThat(Robot(location)).satisfies(robotRequirements)
    }

    @Test
    fun should_be_able_to_turn_directions() {
        var location = Location(Wold(), 0L, 0L)

        assertThat(Robot(location).turn(Direction.LEFT).currentPosition()).contains(Orientation.WEST.key)
        assertThat(Robot(location).turn(Direction.RIGHT).currentPosition()).contains(Orientation.EAST.key)
    }

    @Test
    fun should_walk() {
        val robotRequirements = Consumer { robot: Robot ->
            assertThat(robot.location.latitude).isEqualTo(0L)
            assertThat(robot.location.longitude).isEqualTo(1L)
            assertThat(robot.currentPosition()).contains(Orientation.NORTH.key)
        }

        var robot = Robot(Location(Wold(), 0L, 0L)).walk()
        assertThat(robot).satisfies(robotRequirements)
    }

    @Test
    fun should_throw_exception_when_try_walk_out_of_knew_location() {
        var wold = Mockito.mock(Wold::class.java)

        Mockito.`when`(wold.isValidLatitude(Mockito.anyLong())).thenReturn(false)

        var robot = Robot(Location(wold, 0 , 0))
        assertThatThrownBy {robot.walk()}.isExactlyInstanceOf(InvalidLocation::class.java)
    }
}
