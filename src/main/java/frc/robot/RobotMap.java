/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public enum RobotMap {
    //PWM Motor Mappings
    RIGHT_MOTOR(0),
    RIGHT_MOTOR_FOLLOWER(1),
    LEFT_MOTOR(2),
    LEFT_MOTOR_FOLLOWER(3),
    /*
    LEFT_MOTOR(0), 
    RIGHT_MOTOR(1),
    LEFT_FOLLOW_MOTOR(2),
    RIGHT_FOLLOW_MOTOR(3),
    */
    //Control Mappings
    LEFT_JOYSTICK(0),
    RIGHT_JOYSTICK(1);

    public final int value;

    RobotMap(int value)
    {
      this.value = value;
    }
}
