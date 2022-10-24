package com.assoni.mars.spiritmarskotlin.unit

import com.assoni.mars.enums.Orientation
import com.assoni.mars.objects.location.Location
import com.assoni.mars.objects.location.Wold
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import java.util.function.Consumer

internal class LocationUnitTest {

    private val wold = mock(Wold::class.java)

    @Test
    fun should_move_to_north() {
        val locationRequirements = Consumer{ local: Location ->
            assertThat(local.latitude).isEqualTo(2L)
            assertThat(local.longitude).isEqualTo(3L)
        }

        assertThat(Location(wold, 2L, 2L).move(Orientation.NORTH)).satisfies(locationRequirements)
    }

    @Test
    fun should_move_to_south() {
        val locationRequirements = Consumer{ local: Location ->
            assertThat(local.latitude).isEqualTo(2L)
            assertThat(local.longitude).isEqualTo(1L)
        }

        assertThat(Location(wold, 2L, 2L).move(Orientation.SOUTH)).satisfies(locationRequirements)
    }

    @Test
    fun should_move_to_east() {
        val locationRequirements = Consumer{ local: Location ->
            assertThat(local.latitude).isEqualTo(3L)
            assertThat(local.longitude).isEqualTo(2L)
        }

        assertThat(Location(wold, 2L, 2L).move(Orientation.EAST)).satisfies(locationRequirements)
    }

    @Test
    fun should_move_to_west() {
        val locationRequirements = Consumer{ local: Location ->
            assertThat(local.latitude).isEqualTo(1L)
            assertThat(local.longitude).isEqualTo(2L)
        }

        assertThat(Location(wold, 2L, 2L).move(Orientation.WEST)).satisfies(locationRequirements)
    }
}
