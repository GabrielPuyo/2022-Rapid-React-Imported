// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.IntakeOnCommand;
// import com.ctre.CANTalon;





// 

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  public  TalonSRX IntakeMotor;
  // public CANTalon intakeMotor;
  


  public Intake() {
    // this.IntakeChannel = channel;
    IntakeMotor = new TalonSRX(Constants.INTAKE_MOTOR);
    // this.setDefaultCommand(new InatkeCommand());
  }
  public void runIntake(float negOnetoPosOne){
    IntakeMotor.set(ControlMode.PercentOutput, negOnetoPosOne);

  }
  public void stopIntake(){
    IntakeMotor.set(ControlMode.PercentOutput,0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
