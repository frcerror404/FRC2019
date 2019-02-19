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
  private TalonSRX mWrist = new TalonSRX(13);

  public Wrist() {
    this.mWrist.config_kP(0, 1.3);
    this.mWrist.config_kI(0, 0.00025);
    this.mWrist.config_kD(0, 200.0);
    this.mWrist.config_kF(0, 0.0);
    this.mWrist.configMaxIntegralAccumulator(0, 100.00);
    this.mWrist.configClosedLoopPeriod(0, 1);
    this.mWrist.configClosedloopRamp(0.1);

    this.mWrist.configForwardSoftLimitEnable(true);
    this.mWrist.configReverseSoftLimitEnable(true);
    this.mWrist.configForwardSoftLimitThreshold(3700);
    this.mWrist.configReverseSoftLimitThreshold(-4000);
  }

  @Override
  public void initDefaultCommand() {
    
  }

  public void setWristSpeed(double speed) {
    this.mWrist.set(ControlMode.PercentOutput, speed);
  }

  public void setWristPosition(int position) {
    this.mWrist.set(ControlMode.Position, position);
  }

  public int getPIDError() {
    return this.mWrist.getClosedLoopError();
  }


}
