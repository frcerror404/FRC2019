/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.ElevatorPosition;
import frc.robot.commands.WristPosition;
import frc.robot.models.Poses;

public class Pose extends CommandGroup {

  /**
   * Add your docs here.
   */
  public Pose(Poses pose) {
    requires(Robot.wrist);
    requires(Robot.elevator);

    int elevatorPosition = 0;
    int wristPosition = 0;

    switch(pose) {
      case GROUND:
        elevatorPosition = 1001;
        wristPosition = -3000;
        break;
      case LEVEL2:
        elevatorPosition = 25000;
        wristPosition = -2500;
        break;
      case LEVEL3:
        elevatorPosition = 58000;
        wristPosition = -2500;
        break;
      case PACKAGE:
        elevatorPosition = 0;
        wristPosition = 0;
        break;
    }

  
    addParallel(new ElevatorPosition(elevatorPosition));
    addParallel(new WristPosition(wristPosition));
  }
}
