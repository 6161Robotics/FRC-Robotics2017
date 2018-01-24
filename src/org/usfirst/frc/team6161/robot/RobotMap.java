package org.usfirst.frc.team6161.robot;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static SpeedController driveBaseRightFront;
    public static SpeedController driveBaseRightRear;
    public static SpeedController driveBaseLeftFront;
    public static SpeedController driveBaseLeftRear;
    public static RobotDrive driveBaseThe4Motors;
    public static SpeedController dumpBaseDumpMotor;
    public static SpeedController climberBaseclimbMotor;
    public static SpeedController roombaBaseRoombaMotor;
    
    public static void init() {
    	 driveBaseRightFront = new Spark(2);
         LiveWindow.addActuator("DriveBase", "RightFront", (Spark) driveBaseRightFront);
         
         driveBaseRightRear = new Spark(3);
         LiveWindow.addActuator("DriveBase", "RightRear", (Spark) driveBaseRightRear);
         
         driveBaseLeftFront = new Spark(0);
         LiveWindow.addActuator("DriveBase", "LeftFront", (Spark) driveBaseLeftFront);
         
         driveBaseLeftRear = new Spark(1);
         LiveWindow.addActuator("DriveBase", "LeftRear", (Spark) driveBaseLeftRear);
         
         driveBaseThe4Motors = new RobotDrive(driveBaseLeftFront, driveBaseLeftRear,
               driveBaseRightFront, driveBaseRightRear);
         
         driveBaseThe4Motors.setSafetyEnabled(false);
         driveBaseThe4Motors.setExpiration(0.1);//0.1 default
         driveBaseThe4Motors.setSensitivity(0.5);
         driveBaseThe4Motors.setMaxOutput(1.0);
         
         driveBaseThe4Motors.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
         driveBaseThe4Motors.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
         driveBaseThe4Motors.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
         driveBaseThe4Motors.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
         
         dumpBaseDumpMotor = new Victor(5);
         LiveWindow.addActuator("DumpBase", "DumpMotor", (Victor) dumpBaseDumpMotor);
         
         climberBaseclimbMotor = new VictorSP(4);
         LiveWindow.addActuator("LiftBase", "LiftMotor", (VictorSP) climberBaseclimbMotor);
         
         roombaBaseRoombaMotor = new Victor(6);
         LiveWindow.addActuator("RoombaBase", "RoombaMotor", (Victor) roombaBaseRoombaMotor);
    }
}
