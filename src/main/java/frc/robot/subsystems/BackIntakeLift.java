/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.LiftSpeed;

/**
 * Add your docs here.
 */

// NEEDS TO BE PID
public class BackIntakeLift extends Subsystem {
  CANSparkMax mBackIntakeLift = new CANSparkMax(2, MotorType.kBrushless);

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftSpeed(0));
  }

  public void LiftSpeed(double speed) {
    this.mBackIntakeLift.set(speed);
  }
}
