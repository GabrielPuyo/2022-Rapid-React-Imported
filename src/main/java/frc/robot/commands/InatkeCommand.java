// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// colin says: Why is this no worky? someone explain vvvvvvv
import com.ctre.phoenix.motorcontrol.ControlMode;
// talking about this ^^^^


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class InatkeCommand extends CommandBase {
  /** Creates a new InatkeCommand. */
  public InatkeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.intakeSubsys);
  }
  // colin says: where is the intake object? 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.intakeSubsys.IntakeMotor.set(0.2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.intakeSubsys.IntakeMotor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
