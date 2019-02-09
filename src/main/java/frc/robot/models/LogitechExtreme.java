package frc.robot.models;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechExtreme extends Joystick {

    public LogitechExtreme(final int port) {
        super(port);
    }

    public final double getNormalizedX() {
        double value = this.getRawAxis(0);
        return  value;
    }

    public final double getNormalizedY() {
        double value = this.getRawAxis(1);
        return value;
    }

    public final double getNormalizedZ() {
        double value = this.getRawAxis(2);
        return value;
    }

}