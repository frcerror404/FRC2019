/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ElevatorMotorSpeed;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem implements PIDOutput{
  /**
   * Elevator motors
   */
  public VictorSPX mElevator = new VictorSPX(1);
  public VictorSPX mElevatorFollower = new VictorSPX(2);

  /**
   * PID Variables
   */

  public Elevator() {
    mElevatorFollower.follow(mElevator);
    mElevator.getSelectedSensorPosition(0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorMotorSpeed(0));
  }

  public void ElevatorMotorSpeed(double speed) {
    this.mElevator.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void pidWrite(double output) {
    this.mElevator.set(ControlMode.PercentOutput, output);
  }

}
