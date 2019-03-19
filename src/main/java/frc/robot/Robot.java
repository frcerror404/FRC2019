/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DrivebaseMecanum;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.GroundIntake;
import frc.robot.commands.ElevatorPosition;
import frc.robot.commands.ElevatorSpeed;
import frc.robot.commands.WristPosition;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Wrist;


public class Robot extends TimedRobot {

  public static OI oi;
  //public static Drivebase drivebase;
  public static DrivebaseMecanum drivebaseMecanum;
  public static Claw claw = new Claw();
  public static Elevator elevator = new Elevator();
  public static Wrist wrist = new Wrist();
  public static GroundIntake intake = new GroundIntake();

  boolean _manualElevator = false;

  @Override
  public void robotInit() {
    oi = new OI();
    wrist.zeroWrist();
    elevator.zeroElevator();
    drivebaseMecanum = new DrivebaseMecanum();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
    drivebaseMecanum.setDrive(0, 0, 0);
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
    
    if(oi.Player2.getPOV() == 0) {
      Scheduler.getInstance().add(new WristPosition(0)); // Forward
    } else if (oi.Player2.getPOV() == 90) {
      Scheduler.getInstance().add(new WristPosition(-2000)); // Upwards
    } else if (oi.Player2.getPOV() == 270) {
      Scheduler.getInstance().add(new WristPosition(2000)); // Reverse
    } else if (oi.Player2.getPOV() == 135) {
      Scheduler.getInstance().add(new WristPosition(3500));
    } else if (oi.Player2.getPOV() == 225) {
      Scheduler.getInstance().add(new WristPosition(-3500));
    }


    // Right trigger sends Elevator up
    if(oi.Player2.getRawAxis(3) > .1) {
      this._manualElevator = true;
      Scheduler.getInstance().add(new ElevatorSpeed(oi.Player2.getRawAxis(3)));
    } else {
      if(this._manualElevator) {
        Scheduler.getInstance().add(new ElevatorPosition());
        this._manualElevator = false;
      }
    }

    //Left Trigger sends Elevator down
    if(oi.Player2.getRawAxis(2) > .1) {
      this._manualElevator = true;
      Scheduler.getInstance().add(new ElevatorSpeed(-oi.Player2.getRawAxis(2)));
    } else {
      if(this._manualElevator) {
        Scheduler.getInstance().add(new ElevatorPosition());
        this._manualElevator = false;
      }
    }
    
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }

}
