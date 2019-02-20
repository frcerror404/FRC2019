/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MecanumDriveCommand extends Command {
  public MecanumDriveCommand() {
    requires(Robot.drivebaseMecanum);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.drivebaseMecanum.setDrive(Robot.oi.Player1.getNormalizedLeftX(), -Robot.oi.Player1.getNormalizedLeftY(),
                                    Robot.oi.Player1.getNormalizedRightX());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    end();
  }
}
