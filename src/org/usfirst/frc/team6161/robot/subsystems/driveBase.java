package org.usfirst.frc.team6161.robot.subsystems;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6161.robot.RobotMap;
import org.usfirst.frc.team6161.robot.Robot;

public class driveBase extends Subsystem {
	public static final double autoSpeed = 1;
	public static final double counterTurn = 0.5;
	public double lastForward = 0;
	public double lastTurn = 0;
    public double curve = 0.09;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private RobotDrive the4Motors; 
	public void init(){
		the4Motors = RobotMap.driveBaseThe4Motors;
	}
    public void initDefaultCommand() {
    	//setDefaultCommand(new DriveWithJoystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public RobotDrive getRobotDrive(){
    	return the4Motors;
    }
    public void drivewithJoystick(){
    	if (Robot.oi.getTheJoystick().getRawButton(8)){
    		Robot.driveBase.getRobotDrive().arcadeDrive(Robot.oi.theJoystick.getY(), Robot.oi.theJoystick.getTwist());
    		return;
    	}
    	
    	if (Robot.oi.theJoystick.getY() > lastForward) {
    		lastForward += curve;
    		//lastForward = lastForward + 0.02; <--- same as above
    	}
    	else {
    		lastForward -= curve;
    	}
    	if (Robot.oi.theJoystick.getTwist() > lastTurn) {
    		lastTurn += curve;
    		//lastTurn = lastTurn + 0.02; <--- same as above
    	}
    	else {
    		lastTurn -= curve;
    	}
    	Robot.driveBase.getRobotDrive().arcadeDrive(lastForward, lastTurn);
    }
    public void Forward(){
    	the4Motors.arcadeDrive(-autoSpeed, 0);
    }
    public void AutoForward(){
    	the4Motors.arcadeDrive((-autoSpeed*0.75), 0);
    }
    public void SlowForward(){
    	the4Motors.arcadeDrive((-autoSpeed*0.68), 0);//mid gear
    }
    public void SlowBackward(){
    	the4Motors.arcadeDrive((autoSpeed/2), 0);
    }
    public void Stop(){
    	the4Motors.arcadeDrive(0,0);
    }
}

