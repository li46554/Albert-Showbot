package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.TeamSparkMAX;

public class ShooterSubsystem extends SubsystemBase{

    public TeamSparkMAX leftMotor;
    public TeamSparkMAX rightMotor;

    public ShooterSubsystem() {

        leftMotor = new TeamSparkMAX("left motor shooter", Constants.LEFT_MOTOR_SHOOTER);
        rightMotor = new TeamSparkMAX("right motor shooter", Constants.RIGHT_MOTOR_SHOOTER);
        
        rightMotor.setInverted(true);
        rightMotor.follow(leftMotor);
        leftMotor.enableVoltageCompensation(12);
        rightMotor.enableVoltageCompensation(12);


    }
    
    public void setMotorPowers(float power, String reason){

        leftMotor.set(power, reason);

    }
}
