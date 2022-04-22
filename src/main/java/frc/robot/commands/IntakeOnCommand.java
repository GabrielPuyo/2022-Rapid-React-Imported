// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import com.ctre.phoenix.motorcontrol.ControlMode;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class IntakeOnCommand extends CommandBase {
  /** Creates a new InatkeCommand. */
  public IntakeOnCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.IntakeSubsys);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // RobotContainer.IntakeSubsys.disable();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.stick.getRawButton(Constants.INTAKE_BUTTON)){
      RobotContainer.IntakeSubsys.runIntake(Constants.INTAKE_MOTOR_SPEED);
      System.out.println("Intake command is running");
    }
    else{
      RobotContainer.IntakeSubsys.stopIntake();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.IntakeSubsys.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
