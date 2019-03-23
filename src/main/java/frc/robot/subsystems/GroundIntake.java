/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class GroundIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  TalonSRX mRollers = new TalonSRX(3);
  CANSparkMax mArm = new CANSparkMax(1, MotorType.kBrushless);
  CANPIDController mPidController;

  public GroundIntake(){
    this.mPidController = mArm.getPIDController();
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setRollerSpeed(double speed) {
    mRollers.set(ControlMode.PercentOutput, speed);
  }

  public void setArmSpeed(double speed) {
    mArm.set(speed);
  }

  public double getPosition() {
    return mArm.getEncoder().getPosition();
  }
}
