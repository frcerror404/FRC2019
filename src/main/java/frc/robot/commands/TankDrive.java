/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TankDrive extends Command {
  public TankDrive() {
    requires(Robot.drivebase);
  }

  protected void initialize() {
  }

  protected void execute() {
    double throttle=(1.0- Robot.oi.LEFT_JOY.getThrottle()) /-2.0;
    
    Robot.drivebase.setRaw(Robot.oi.getLeftJoyY()*throttle, Robot.oi.getRightJoyY()* throttle);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void interrupted() {
    end();
  }
}
