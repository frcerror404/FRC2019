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
public class Wrist extends Subsystem {
  TalonSRX mWrist = new TalonSRX(13);

  @Override
  public void initDefaultCommand() {
    mWrist.config_kP(0, 1.3);
    mWrist.config_kI(0, 0.00025);
    mWrist.config_kD(0, 200.0);
    mWrist.config_kF(0, 0.0);
    mWrist.configMaxIntegralAccumulator(0, 100.00);
    mWrist.configClosedLoopPeriod(0, 1);
    mWrist.configClosedloopRamp(0.1);
  }

  public void WristSpeed(double speed) {
    mWrist.set(ControlMode.PercentOutput, speed);
  }

}
