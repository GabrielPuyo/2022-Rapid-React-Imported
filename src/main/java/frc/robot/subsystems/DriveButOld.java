// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveButOld extends SubsystemBase {
  /** Creates a new Drive. */
  public CANSparkMax frontLeft, frontRight, backRight, backLeft;
  MotorControllerGroup left, right;
  public DifferentialDrive drive;
  //public DoubleSolenoid shifter;

  public DriveButOld() {
    frontLeft = new CANSparkMax(Constants.TOP_LEFT_DRIVE, MotorType.kBrushless);
    frontRight = new CANSparkMax(Constants.TOP_RIGHT_DRIVE, MotorType.kBrushless);
    backLeft = new CANSparkMax(Constants.BOTTOM_LEFT_DRIVE, MotorType.kBrushless);
    backRight = new CANSparkMax(Constants.BOTTOM_RIGHT_DRIVE, MotorType.kBrushless);

    backLeft.setInverted(true);
    frontLeft.setInverted(true);

    left = new MotorControllerGroup(frontLeft, backLeft);
    right = new MotorControllerGroup(frontRight, backRight);
    drive = new DifferentialDrive(left, right);

    //shifter = new DoubleSolenoid(Constants.SHIFTER_FORWARD, Constants.SHIFER_REVERSE);
  }

  public void stop() {
    drive.arcadeDrive(0, 0);
  }

  public void setDriveSpeed(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
