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
  private Spark LeftMotorFollower;
  private Spark RightMotor;
  private Spark RightMotorFollower;

  /*
  private TalonSRX LeftMotor;
  private TalonSRX LeftMotorFollower;
  private TalonSRX RightMotorFollower;
  private TalonSRX RightMotor;
  */

  public Drivebase() {
    LeftMotor = new Spark(RobotMap.LEFT_MOTOR.value);
    LeftMotorFollower = new Spark (RobotMap.LEFT_MOTOR.value);
    RightMotor = new Spark(RobotMap.RIGHT_MOTOR.value);
    RightMotorFollower = new Spark(RobotMap.RIGHT_MOTOR.value);
    
    /*
    LeftMotor = new TalonSRX(RobotMap.LEFT_MOTOR.value);
    RightMotor = new TalonSRX(RobotMap.RIGHT_MOTOR.value);
    LeftMotorFollower= new TalonSRX(RobotMap.LEFT_MOTOR.value);
    RightMotorFollower= new TalonSRX(RobotMap.RIGHT_MOTOR.value);

    Robot.initTalon(LeftMotor);
    Robot.initTalon(RightMotor);
    Robot.initTalon(LeftMotorFollower);
    Robot.initTalon(RightMotorFollower);
    LeftMotorFollower.follow(LeftMotor);
    RightMotorFollower.follow(RightMotor);
    */
  }
  
  public void setRaw(double leftvalue, double rightvalue){
    LeftMotor.set(leftvalue);
    LeftMotorFollower.set(leftvalue);
    RightMotor.set(rightvalue);
    RightMotorFollower.set(rightvalue);
    /*
  public void set(ControlMode mode,double leftvalue, double rightvalue) {
    LeftMotor.set(mode, leftvalue);
    RightMotor.set(mode, rightvalue);
    */
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }
}
