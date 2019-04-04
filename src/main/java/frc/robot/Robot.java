/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DrivebaseMecanum;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.GroundIntake;
import frc.robot.commands.ArmSpeed;
import frc.robot.commands.ElevatorPosition;
import frc.robot.commands.ElevatorSpeed;
import frc.robot.commands.WristPosition;
import frc.robot.commands.WristSpeed;
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
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setFPS(12);
    camera.setResolution(240, 180);
    //CameraServer.getInstance().setQuality(30);
    //CameraServer CS = CameraServer.getInstance();
    
    //CameraServer.getInstance(
    //camera.set
    //CameraServer.getInstance().set
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Arm Position", intake.getPosition());
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
    teleopPeriodic();
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    /*
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
    }*/


    // Right trigger sends Elevator up
    /*if(oi.Player2.getRawAxis(3) > .1) {
      this._manualElevator = true;
      Scheduler.getInstance().add(new ElevatorSpeed(oi.Player2.getRawAxis(3)));
    } else {
      if(this._manualElevator) {
        Scheduler.getInstance().add(new ElevatorPosition());
        this._manualElevator = false;
      }
    }*/

    if(Math.abs(oi.Player1.getRawAxis(2)) > .5 ) {
      Scheduler.getInstance().add(new ArmSpeed(.75));
    } else if(Math.abs(oi.Player1.getRawAxis(3)) > .5 ) {
      Scheduler.getInstance().add(new ArmSpeed(-.75));
    } else {
      Scheduler.getInstance().add(new ArmSpeed(0.0));
    }

    //Left Trigger sends Elevator down
    /*if(oi.Player2.getRawAxis(2) > .1) {
      this._manualElevator = true;
      Scheduler.getInstance().add(new ElevatorSpeed(-oi.Player2.getRawAxis(2)));
    } else {
      if(this._manualElevator) {
        Scheduler.getInstance().add(new ElevatorPosition());
        this._manualElevator = false;
      }
    }*/

    if(Math.abs(oi.Player2.getRawAxis(0)) > .05) {
      Scheduler.getInstance().add(new WristSpeed(oi.Player2.getRawAxis(0)/2.0f));
    }
    
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }

}
