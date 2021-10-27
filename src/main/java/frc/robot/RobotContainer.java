// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//importing stuff
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.SetBreakMode;
import frc.robot.commands.SetCoastMode;
import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

// this is the Robotcontainer method, it describes drivetrain, joystick, and arcadedrive variables. 
public class RobotContainer {

  public static final class Config {
    public static final int breakButton = 4;
    public static final int joyStickPort = 1;
    public static final int CoastButton = 6;
  }

  
  private final DriveTrain m_driveTrain = new DriveTrain();

  private final Joystick m_joystick = new Joystick(Config.joyStickPort);

  private final JoystickButton m_BreakButton = new JoystickButton(m_joystick, Config.breakButton);
  
  private final JoystickButton m_CoastButton = new JoystickButton(m_joystick, Config.CoastButton);

  private final ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_driveTrain, m_joystick);
  // The robot's subsystems and commands are defined here...//
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  //constructor method//
  public RobotContainer() {
    // Configure the button bindings//
    configureButtonBindings();
  }

  // teleop method that gives us our ArcadeDrive command//
  public Command getTeleopCommand () {
    m_driveTrain.setDefaultCommand(m_arcadeDrive);
    return m_arcadeDrive;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_BreakButton.whenPressed( new SetBreakMode(m_driveTrain));
    m_CoastButton.whenPressed( new SetCoastMode(m_driveTrain));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
