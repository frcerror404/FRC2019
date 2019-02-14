/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.GroundIntakeSpeed;

/**
 * Add your docs here.
 */
public class GroundIntakeBack extends Subsystem {
  VictorSPX mGroundIntake = new VictorSPX(2);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new GroundIntakeSpeed(0));
  }

  public void GroundIntakeSpeed(double speed) {
    this.mGroundIntake.set(ControlMode.PercentOutput, speed);
  }
  
}
