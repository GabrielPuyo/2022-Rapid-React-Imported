// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutoCenter;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.intake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Drive drive = new Drive();

  public ArcadeDrive arcadeDriveCommand = new ArcadeDrive();
  private static NetworkTableInstance tableInstance;
  private static NetworkTable limelight;
  public static Joystick stick;
  public static intake intakeSubsys;
  // public static intake Intakemotor = new intake();
  // public static intake;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    stick = new Joystick(Constants.STICK);

    configureButtonBindings();
    tableInstance = NetworkTableInstance.getDefault();
    limelight = tableInstance.getTable("limelight");
    drive.setDefaultCommand(new ArcadeDrive());
  }

  public static double limelightX() {
    return -limelight.getEntry("tx").getDouble(0);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton Aline = new JoystickButton(stick, 2);
    Aline.whenHeld(new AutoCenter());
    

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
