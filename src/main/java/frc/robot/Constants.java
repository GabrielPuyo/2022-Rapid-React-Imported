// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int
    TOP_LEFT_DRIVE = 4,
    BOTTOM_LEFT_DRIVE = 1,
    TOP_RIGHT_DRIVE = 3,
    BOTTOM_RIGHT_DRIVE = 2,
    INTAKE_MOTOR = 51,
    INTAKE_BUTTON = 3;
    
    
    // this int is a placholder for now cuz colin doesn't know which
    // controller to use or whatever 

    public static final int
    SHIFTER_FORWARD = 1,
    SHIFER_REVERSE = 2;

    public static final int STICK = 0;
    public static final float INTAKE_MOTOR_SPEED = 0.1f;
}
