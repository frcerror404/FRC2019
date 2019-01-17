/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

public class Drivebase extends Subsystem {

  private Spark LeftMotor;
  private Spark RightMotor;

  public Drivebase() {
    LeftMotor = new Spark(RobotMap.LEFT_SIDE.value);
    RightMotor = new Spark(RobotMap.RIGHT_SIDE.value);
  }
  
  public void setRaw(double leftvalue, double rightvalue){
    LeftMotor.set(leftvalue);
    RightMotor.set(rightvalue);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }
}
