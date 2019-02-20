/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.MecanumDriveCommand;



public class DrivebaseMecanum extends Subsystem {

  CANSparkMax mFrontLeft = new CANSparkMax(8, MotorType.kBrushless);
  CANSparkMax mFrontRight = new CANSparkMax(0, MotorType.kBrushless);
  CANSparkMax mBackLeft = new CANSparkMax(10, MotorType.kBrushless);
  CANSparkMax mBackRight = new CANSparkMax(12, MotorType.kBrushless);
  edu.wpi.first.wpilibj.drive.MecanumDrive drive = new edu.wpi.first.wpilibj.drive.MecanumDrive(mFrontLeft, mBackLeft, mFrontRight, mBackRight);


  public DrivebaseMecanum() {
  }

  public void setDrive(double x, double y, double z) {
    drive.driveCartesian(-x, y, z);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MecanumDriveCommand());
  }
}
