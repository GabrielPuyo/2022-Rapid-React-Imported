// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drive extends PIDSubsystem {
  public CANSparkMax frontLeft, frontRight, backRight, backLeft;
  MotorControllerGroup left, right;
  public DifferentialDrive drive;
  //public DoubleSolenoid shifter;
  /** Creates a new Drive. */
  public Drive() {
    

    super(new PIDController(0, 0, 0));

    frontLeft = new CANSparkMax(Constants.TOP_LEFT_DRIVE, MotorType.kBrushless);
    frontRight = new CANSparkMax(Constants.TOP_RIGHT_DRIVE, MotorType.kBrushless);
    backLeft = new CANSparkMax(Constants.BOTTOM_LEFT_DRIVE, MotorType.kBrushless);
    backRight = new CANSparkMax(Constants.BOTTOM_RIGHT_DRIVE, MotorType.kBrushless);

    backLeft.setInverted(true);
    frontLeft.setInverted(true);

    left = new MotorControllerGroup(frontLeft, backLeft);
    right = new MotorControllerGroup(frontRight, backRight);
    drive = new DifferentialDrive(left, right);
  }

  public static enum PID_TYPES {
    LIMELIGHT_ROTATION(0.015, 0, 0), NONE(0,0,0);

    private double kP, kI, kD;
    // private 
    private PID_TYPES(double kP, double kI, double kD){
      this.kP = kP;
      this.kI = kI;
      this.kD = kD;
    }
  }


  PID_TYPES currentType = PID_TYPES.LIMELIGHT_ROTATION;

  public void stop() {
    drive.arcadeDrive(0, 0);
  }
  public void setDriveSpeed(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    super.periodic();
  }

  public void setCurrentType(PID_TYPES currentType) {
    this.currentType = currentType;
    getController().setPID(currentType.kP, currentType.kI, currentType.kD);
    switch(currentType) {
      case LIMELIGHT_ROTATION:
        getController().setTolerance(2, 2);
        break;
    }
  }

  

  @Override
  public void useOutput(double output, double setpoint) {
    switch(currentType) {
      case LIMELIGHT_ROTATION:
        left.set(output);
        right.set(output);
        break;
    }
  }

  @Override
  public double getMeasurement() {
    return RobotContainer.limelightX();
  }
}
