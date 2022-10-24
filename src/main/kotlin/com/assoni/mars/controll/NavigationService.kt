package com.assoni.mars.controll

import com.assoni.mars.objects.Instruction
import com.assoni.mars.objects.Robot
import com.assoni.mars.objects.location.Location
import com.assoni.mars.objects.location.Wold
import org.springframework.stereotype.Service

@Service
class NavigationService {

    fun navigate(command: String) : String {
        var location = Location(Wold(), 0L, 0L)
        var robot = Robot(location)

        Instruction(command).execute(robot)
        return robot.currentPosition();
    }
}
