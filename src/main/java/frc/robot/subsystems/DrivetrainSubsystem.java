package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.ITeamTalon;
import frc.robot.TeamTalonFX;




public class DrivetrainSubsystem extends SubsystemBase {
    ITeamTalon rightForwardDriveMotor;
    ITeamTalon leftForwardDriveMotor;
    ITeamTalon rightBackDriveMotor;
    ITeamTalon leftBackDriveMotor;

    double speedMod = 0.5;

    public DrivetrainSubsystem() {

        rightForwardDriveMotor = new TeamTalonFX("Drivetrain Front Right", Constants.RIGHT_FORWARD_DRIVE_MOTOR);
        leftForwardDriveMotor = new TeamTalonFX("Drivetrain Front Left", Constants.LEFT_FORWARD_DRIVE_MOTOR);
        rightBackDriveMotor = new TeamTalonFX("Drivetrain Back Right", Constants.RIGHT_BACK_DRIVE_MOTOR);
        leftBackDriveMotor = new TeamTalonFX("Drivetrain Back Left", Constants.LEFT_BACK_DRIVE_MOTOR);

        rightBackDriveMotor.follow(rightForwardDriveMotor);
        leftBackDriveMotor.follow(leftForwardDriveMotor);

        leftForwardDriveMotor.setInverted(true);
        leftBackDriveMotor.setInverted(true);

        rightForwardDriveMotor.setNeutralMode(NeutralMode.Brake);
        leftForwardDriveMotor.setNeutralMode(NeutralMode.Brake);
        rightBackDriveMotor.setNeutralMode(NeutralMode.Brake);
        leftBackDriveMotor.setNeutralMode(NeutralMode.Brake);

        rightForwardDriveMotor.enableVoltageCompensation(true);
        leftForwardDriveMotor.enableVoltageCompensation(true);
        rightBackDriveMotor.enableVoltageCompensation(true);
        leftBackDriveMotor.enableVoltageCompensation(true);

        
    }

    public void setMotorPowers(double leftPower, double rightPower, String reason){

        leftPower *= speedMod;
        rightPower *= speedMod;

        double currentLeftPower = leftForwardDriveMotor.get();
        double currentRightPower = rightForwardDriveMotor.get();

        if (leftPower > currentLeftPower + 0.1){

            leftPower = currentLeftPower + 0.1;

        }
        else if (leftPower < currentLeftPower - 0.1){

            leftPower = currentLeftPower - 0.1;

        }

        if (rightPower > currentRightPower + 0.1){

            rightPower = currentRightPower + 0.1;

        }
        else if (rightPower < currentRightPower - 0.1){

            rightPower = currentRightPower - 0.1;

        }

        leftPower = Math.max(Math.min(1, leftPower),-1);
        
        rightPower = Math.max(Math.min(1, rightPower),-1);

        rightForwardDriveMotor.set(rightPower, reason);
        leftForwardDriveMotor.set(leftPower, reason);
    }




}
