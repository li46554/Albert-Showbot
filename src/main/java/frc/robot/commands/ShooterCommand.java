package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {

    private ShooterSubsystem shooter;

    public ShooterCommand(ShooterSubsystem shootaball){

        shooter = shootaball;
        addRequirements(shooter);
    }
    public void execute() {
        shooter.setMotorPowers(1, "Joystick said to go");
        

    }

    

    
}
