/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.MecanumDriveCommand;



public class DrivebaseMecanum extends Subsystem {

  Spark mFrontLeft = new Spark(1);
  Spark mFrontRight = new Spark(0);
  Spark mBackLeft = new Spark(3);
  Spark mBackRight = new Spark(2);
  edu.wpi.first.wpilibj.drive.MecanumDrive drive = new edu.wpi.first.wpilibj.drive.MecanumDrive(mFrontLeft, mBackLeft, mFrontRight, mBackRight);


  public DrivebaseMecanum() {
    drive.setRightSideInverted(drive.isRightSideInverted());
  }

  public void setDrive(double x, double y, double z) {
    drive.driveCartesian(x, y, z);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MecanumDriveCommand());
  }
}
