/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.sun.jdi.InvalidStackFrameException;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.models.LogitechController;
import frc.robot.commands.*;
import frc.robot.models.Poses;

public class OI {


  public static final double JOY_DEADZONE=0.05;
  public LogitechController Player1 = new LogitechController(0);
  public LogitechController Player2 = new LogitechController(1);
  Button GroundPose = new JoystickButton(Player2, 1), // A
         Level2Pose = new JoystickButton(Player2, 2), // B
         Level3Pose = new JoystickButton(Player2, 4), // Y
         ClawIn = new JoystickButton(Player2, 5),     // Right bumper
         ClawOut = new JoystickButton(Player2, 6);    // Left bumper
         // Add Wrist  

  Button IntakeUp = new JoystickButton(Player1, 1),
         IntakeDown = new JoystickButton(Player1, 4),
         IntakeInwards = new JoystickButton(Player1, 5),
         IntakeOutwards = new JoystickButton(Player1, 6);

  public OI() {
    this.GroundPose.whenPressed(new Pose(Poses.GROUND));
    this.Level2Pose.whenPressed(new Pose(Poses.LEVEL2));
    this.Level3Pose.whenPressed(new Pose(Poses.LEVEL3));
    this.ClawIn.whenPressed(new ClawIntakeSpeed(0.75));
    this.ClawIn.whenReleased(new ClawIntakeSpeed(0.0));
    this.ClawOut.whenPressed(new ClawIntakeSpeed(-1.0));
    this.ClawOut.whenReleased(new ClawIntakeSpeed(0.0));

    /*this.IntakeUp.whenPressed(new ArmSpeed(.75));
    this.IntakeUp.whenReleased(new ArmSpeed(0.0));
    this.IntakeDown.whenPressed(new ArmSpeed(-.75));
    this.IntakeDown.whenReleased(new ArmSpeed(0.0));*/

    this.IntakeInwards.whenPressed(new RollerSpeed(1.0));
    this.IntakeInwards.whenReleased(new RollerSpeed(0.0));
    this.IntakeOutwards.whenPressed(new RollerSpeed(-1.0));
    this.IntakeOutwards.whenReleased(new RollerSpeed(0.0));
  }
}
  
