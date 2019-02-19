/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.models.LogitechController;
import frc.robot.models.LogitechExtreme;
import frc.robot.commands.*;
import frc.robot.models.Poses;

public class OI {


  public static final double JOY_DEADZONE=0.05;
  public LogitechController Player1 = new LogitechController(0);
  public LogitechController Player2 = new LogitechController(1);
  Button GroundPose = new JoystickButton(Player2, 0),
         Level2Pose = new JoystickButton(Player2, 1),
         Level3Pose = new JoystickButton(Player2, 3);
         // Add Wrist

  public OI() {
    this.GroundPose.whenPressed(new Pose(Poses.GROUND));
    this.Level2Pose.whenPressed(new Pose(Poses.LEVEL2));
    this.Level3Pose.whenPressed(new Pose(Poses.LEVEL3));
  }
}
  
