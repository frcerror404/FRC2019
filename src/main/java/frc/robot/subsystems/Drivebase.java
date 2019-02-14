/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

public class Drivebase extends Subsystem {

  CANSparkMax LeftMotor;
  CANSparkMax RightMotor;

  public Drivebase() {
    LeftMotor = new CANSparkMax(RobotMap.LEFT_SIDE.value, MotorType.kBrushless);
    RightMotor = new CANSparkMax(RobotMap.RIGHT_SIDE.value, MotorType.kBrushless);
  }
  
  public void setRaw(double x, double y, double z){
    LeftMotor.set(y + z);
    RightMotor.set(-y + z);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }
}
