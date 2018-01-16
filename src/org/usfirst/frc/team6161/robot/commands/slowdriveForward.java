package org.usfirst.frc.team6161.robot.commands;

import org.usfirst.frc.team6161.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class slowdriveForward extends Command {
	private int timeout;
    public slowdriveForward(int timeout) {
    	this.timeout = timeout;
    	requires(Robot.driveBase);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    	Robot.driveBase.SlowForward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
