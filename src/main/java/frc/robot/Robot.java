/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.DrivebaseMecanum;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Hook;
import frc.robot.subsystems.Winch;


public class Robot extends TimedRobot {

  public static OI oi;
  public static Drivebase drivebase;
  public static DrivebaseMecanum drivebaseMecanum = new DrivebaseMecanum();
  public static Winch winch = new Winch();
  public static Hook hook = new Hook();
  public static Arm arm = new Arm();
  public static Elevator elevator = new Elevator();

  @Override
  public void robotInit() {
    oi = new OI();
    drivebase = new Drivebase();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }

}
