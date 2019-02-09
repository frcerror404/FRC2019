/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TankDrive extends Command {
  public TankDrive() {
    requires(Robot.drivebase);
  }

  protected void initialize() {
  }

  protected void execute() {

    Robot.drivebase.setRaw(Robot.oi.Player1.getNormalizedX(), Robot.oi.Player1.getNormalizedY(), Robot.oi.Player1.getNormalizedZ());
  }

  protected boolean isFinished() {
    return false;
  }

  protected void interrupted() {
    end();
  }
}
