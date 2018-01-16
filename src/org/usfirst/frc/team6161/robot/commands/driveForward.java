package org.usfirst.frc.team6161.robot.commands;

import org.usfirst.frc.team6161.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class driveForward extends Command {
	private int timeout;
	 public driveForward(int timeout) {
		 this.timeout = timeout;
	        // Use requires() here to declare subsystem dependencies
	        // eg. requires(chassis);
	    	requires(Robot.driveBase);
	    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    	Robot.driveBase.Forward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveBase.Forward();
    }

    // Make this return true when this Command no longer needs to run execute()
    //isFinished()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
