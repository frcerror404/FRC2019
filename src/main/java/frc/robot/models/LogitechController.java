package frc.robot.models;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechController extends Joystick {

    public LogitechController(final int port) {
        super(port);
    }

    public final double getNormalizedLeftY() {
        double value = this.getRawAxis(5);
        return  value;
    }

    public final double getNormalizedRightY() {
        double value = -this.getRawAxis(1);
        return value;
    }
}