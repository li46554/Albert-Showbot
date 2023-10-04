// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AgitateCommand;
import frc.robot.commands.DrivetrainCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.AgitatorSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static ShooterSubsystem shooter;
  public static AgitatorSubsystem agitator;
  public static Joystick primaryJoystick;
  public static JoystickButton primaryTriggerRight;
  public static DrivetrainSubsystem driveTrain;
  public static ShuffleboardTab tab = Shuffleboard.getTab("Main");
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    

    shooter = new ShooterSubsystem();
    driveTrain = new DrivetrainSubsystem();
    agitator = new AgitatorSubsystem();

    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    primaryJoystick = new Joystick(0);
    primaryTriggerRight = new JoystickButton(primaryJoystick, LogitechControllerButtons.triggerRight);
    primaryTriggerRight.whileTrue(new ShooterCommand(shooter))
      .whileTrue(new AgitateCommand(agitator));

    driveTrain.setDefaultCommand(new DrivetrainCommand(driveTrain, (() -> primaryJoystick.getY()), () -> primaryJoystick.getThrottle()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
