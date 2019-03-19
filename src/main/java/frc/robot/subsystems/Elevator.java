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
  private TalonSRX mElevator = new TalonSRX(4);
  private TalonSRX mElevatorFollower = new TalonSRX(5);

  /**
   * PID Variables
   */

  public Elevator() {
    mElevatorFollower.follow(mElevator);
    this.mElevator.config_kP(0, 0.076300);   // (slotID, value)
    this.mElevator.config_kI(0, 0.000010);
    this.mElevator.config_kD(0, 0.0);
    this.mElevator.config_kF(0, 0.0);
    this.mElevator.configClosedLoopPeriod(0, 1);
    this.mElevator.configClosedloopRamp(0.15);

    this.mElevator.configForwardSoftLimitEnable(true);
    this.mElevator.configReverseSoftLimitEnable(true);
    this.mElevator.configReverseSoftLimitThreshold(1000);
    this.mElevator.configForwardSoftLimitThreshold(78750);
  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new ElevatorMotorSpeed(0));
  }

  public void setElevatorMotorSpeed(double speed) {
    this.mElevator.set(ControlMode.PercentOutput, speed);
  }

  public void setElevatorPosition(int position) {
    this.mElevator.set(ControlMode.Position, position);
  }

  public int getPIDError() {
    return this.mElevator.getClosedLoopError();
  }

  public int getPosition() {
    return this.mElevator.getSelectedSensorPosition();
  }

  public void zeroElevator() {
    this.mElevator.setSelectedSensorPosition(0);
  }
}
