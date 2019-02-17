/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.commands.ElevatorMotorSpeed;

/**
 * Add your docs here.
 */
public class ElevatorPID extends PIDSubsystem {
  /**
   * Insert motors here.
   */
  VictorSPX mElevator = new VictorSPX(21);

  public ElevatorPID() {
    // Insert a subsystem name and PID values here
    super("ElevatorPID", 1.0, 1.0, 1.0);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    setSetpoint(0);
    setAbsoluteTolerance(0.05);
    getPIDController().setContinuous(false);
    setInputRange(0, 1000);
    this.mElevator.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorMotorSpeed(0));
  }

  /**
   * Input from sensor
   */
  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return 0.0;
  }

  /**
   * Output to motor
   */
  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    mElevator.set(ControlMode.PercentOutput, output);
  }
}
