/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {
  VictorSPX mLeft = new VictorSPX(1);
  VictorSPX mRight = new VictorSPX(2);

  public Claw() {
    this.mLeft.follow(this.mRight);
    this.mLeft.setInverted(InvertType.OpposeMaster);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void SetIntakeSpeed(double intakeSpeed){
    this.mRight.set(ControlMode.PercentOutput, intakeSpeed);
  }

  public void SetOutputSpeed(double outputSpeed){
    this.mRight.set(ControlMode.PercentOutput, outputSpeed);
  }

}
