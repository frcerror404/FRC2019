/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  VictorSPX m_Motor1 = new VictorSPX(6);
  VictorSPX m_Motor2 = new VictorSPX(7);

  public Claw() {
    this.m_Motor2.follow(this.m_Motor1, FollowerType.PercentOutput);
    this.m_Motor2.setInverted(InvertType.OpposeMaster);
  }

  @Override
  public void initDefaultCommand() {
    
  }

  public void setClawIntakeSpeed(double speed) {
    this.m_Motor1.set(ControlMode.PercentOutput, speed);
  }
}