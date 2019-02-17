/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.DrivebaseMecanum;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FrontIntakeLift;
import frc.robot.subsystems.GroundIntakeFront;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Wrist;


public class Robot extends TimedRobot {

  public static OI oi;
  //public static Drivebase drivebase;
  public static DrivebaseMecanum drivebaseMecanum;
  public static Claw claw = new Claw();
  //public static Elevator elevator = new Elevator();
  //public static Wrist wrist = new Wrist();
  public static GroundIntakeFront groundintakefront = new GroundIntakeFront();
  public static FrontIntakeLift frontintakelift = new FrontIntakeLift();

  @Override
  public void robotInit() {
    oi = new OI();
    drivebaseMecanum = new DrivebaseMecanum();
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
