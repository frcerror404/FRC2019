/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.MecanumDriveCommand;



public class DrivebaseMecanum extends Subsystem {

  CANSparkMax mFrontLeft, mFrontRight, mBackLeft, mBackRight;
  MecanumDrive drive;


  public DrivebaseMecanum() {
    this.mFrontLeft = new CANSparkMax(8, MotorType.kBrushless);
    this.mFrontRight = new CANSparkMax(15, MotorType.kBrushless);
    this.mBackLeft = new CANSparkMax(10, MotorType.kBrushless);
    this.mBackRight = new CANSparkMax(12, MotorType.kBrushless);
    drive = new MecanumDrive(this.mFrontLeft, this.mBackLeft, this.mFrontRight, this.mBackRight);
    //mFrontRight.setInverted(true);
  }

  public void setDrive(double x, double y, double z) {
    drive.driveCartesian(-x, y, z);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MecanumDriveCommand());
  }
}
