package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DrivetrainCommand extends CommandBase{

    DrivetrainSubsystem drivetrain;
    DoubleSupplier leftStick;
    DoubleSupplier rightStick;

    public DrivetrainCommand(DrivetrainSubsystem drivetrain, DoubleSupplier leftStick, DoubleSupplier rightStick){

        this.drivetrain = drivetrain;
        this.leftStick = leftStick;
        this.rightStick = rightStick;

        addRequirements(drivetrain);


    }
    
    double cubePower(double input){
        return Math.pow(input, 3);
    }

    double deadZone (double input) {
      if (Math.abs(input) <= Constants.DEADZONE_AMOUNT) return 0;
      return input;
    }
    
    public void execute() {
        drivetrain.setMotorPowers(cubePower(deadZone(leftStick.getAsDouble())), cubePower(deadZone(rightStick.getAsDouble())), "Joysticks said so");
    }

}
