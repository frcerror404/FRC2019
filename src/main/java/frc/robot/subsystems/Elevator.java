/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem{
  /**
   * Elevator motors
   */
  public TalonSRX mElevator = new TalonSRX(4);
  public TalonSRX mElevatorFollower = new TalonSRX(5);

  /**
   * PID Variables
   */

  public Elevator() {
    mElevatorFollower.follow(mElevator);
  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new ElevatorMotorSpeed(0));
    mElevator.config_kP(0, 0.040700);   // (slotID, value)
    mElevator.config_kI(0, 0.000012);
    mElevator.config_kD(0, 0.0);
    mElevator.config_kF(0, 0.0);
    mElevator.configClosedLoopPeriod(0, 1);
    mElevator.configClosedloopRamp(0.15);
  }

  public void ElevatorMotorSpeed(double speed) {
    this.mElevator.set(ControlMode.PercentOutput, speed);
  }

}
