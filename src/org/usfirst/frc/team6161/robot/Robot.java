
package org.usfirst.frc.team6161.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6161.robot.commands.AutoMidGear;
//import java.util.Calendar;
/*
import org.usfirst.frc.team6161.robot.commands.AutoBallDump;
import org.usfirst.frc.team6161.robot.commands.AutoLeftGear;
import org.usfirst.frc.team6161.robot.commands.AutoRightGear;
*/
import org.usfirst.frc.team6161.robot.commands.AutoStraight;

import org.usfirst.frc.team6161.robot.subsystems.driveBase;
import org.usfirst.frc.team6161.robot.subsystems.climberBase;
import org.usfirst.frc.team6161.robot.subsystems.dumpBase;
import org.usfirst.frc.team6161.robot.subsystems.roombaBase;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final driveBase driveBase = new driveBase();
	public static final climberBase climberBase = new climberBase();
	public static final dumpBase dumpBase = new dumpBase();
	public static final roombaBase roombaBase = new roombaBase();
	public static OI oi;
	
	PowerDistributionPanel pdp; 
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		CameraServer.getInstance().startAutomaticCapture();
		RobotMap.init();
		oi = new OI();
		pdp = new PowerDistributionPanel();
		/*
		chooser.addDefault("Default Auto", new AutoStraight());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		
		chooser.addObject("MidGearDeposit", new AutoMidGear());
		SmartDashboard.putData("Auto MidGear mode", chooser);
		*/
		driveBase.init();
		climberBase.init();
		dumpBase.init();
		roombaBase.init();
		// call other subsystem inits here
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = new AutoStraight();
		//autonomousCommand = new AutoMidGear();
		/*autonomousCommand = chooser.getSelected();

		 String autoSelected = SmartDashboard.getString("Auto?","Default"); 
		 switch(autoSelected) { 
		 case "MidGear":autonomousCommand = new AutoMidGear(); 
		 break;
		 case "Straight": default:autonomousCommand = new AutoStraight(); 
		 break; 
		 case "RightGear":autonomousCommand = new AutoRightGear();
		 break;
		 case "LeftGear":autonomousCommand = new AutoLeftGear();
		 break;
		 case "BallDump":autonomousCommand = new AutoBallDump();
		 break;
		 }
		*/

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		
		
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		Robot.driveBase.drivewithJoystick();
		//System.out.println(Calendar.getInstance().getTimeInMillis());
		
		//Brownout Protection
		if (pdp.getCurrent(0) > 60.0 ||
	    		pdp.getCurrent(1) > 60.0 ||
	    		pdp.getCurrent(2) > 60.0 ||
	    		pdp.getCurrent(3) > 60.0) {
	    		
			//---> modifies joystick inputs
	    	}
	    		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
