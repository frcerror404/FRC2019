/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public enum RobotMap {
    //PWM Motor Mappings
    RIGHT_SIDE(0),
    LEFT_SIDE(1),

    //Control Mappings
    RIGHT_JOYSTICK(0),
    LEFT_JOYSTICK(5);

    public final int value;

    RobotMap(int value)
    {
      this.value = value;
    }
}
