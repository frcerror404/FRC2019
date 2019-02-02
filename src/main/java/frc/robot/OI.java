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
import frc.robot.commands.*;

public class OI {


  public static final double JOY_DEADZONE=0.05;
  public LogitechController Player1 = new LogitechController(0);
  public LogitechController Player2 = new LogitechController(1);
  Button intakeOut = new JoystickButton(Player2, 6),
         intakeIn = new JoystickButton(Player2, 5),
         winch = new JoystickButton(Player2, 4),
         hook = new JoystickButton(Player2, 3),
         armDown = new JoystickButton(Player2, 2),
         armUp = new JoystickButton(Player2, 1);

  public OI(){
    intakeIn.whenPressed(new SetIntakeSpeed(0.4));
    intakeIn.whenReleased(new SetIntakeSpeed(0.0));
    intakeOut.whenPressed(new SetOutputSpeed(-0.4));
    intakeOut.whenReleased(new SetOutputSpeed(0.0));
    winch.whenPressed(new SetWinchSpeed(.25));
    winch.whenReleased(new SetWinchSpeed(0.0));
    hook.whenPressed(new SetHookSpeed(0.2));
    hook.whenReleased(new SetHookSpeed(0.0));
    armUp.whenPressed(new ArmSpeed(0.4));
    armUp.whenReleased(new ArmSpeed(0.0));
    armDown.whenPressed(new ArmSpeed(-0.4));
    armDown.whenReleased(new ArmSpeed(0.0));
  }
}
  
