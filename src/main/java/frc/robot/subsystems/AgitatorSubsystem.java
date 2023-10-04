package frc.robot.subsystems;



import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import frc.robot.TeamTalonFX;


public class AgitatorSubsystem extends SubsystemBase{

    public TeamTalonFX agitator;

    public AgitatorSubsystem() {

        agitator = new TeamTalonFX("Agitator", Constants.AGITATOR_MOTOR);

    }
    
    public void setMotorPowers(double power, String reason) {
        agitator.set(power * Constants.AGITATOR_SPEED, reason);
    }
}
