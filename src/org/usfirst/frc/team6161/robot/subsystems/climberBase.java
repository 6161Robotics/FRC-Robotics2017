package org.usfirst.frc.team6161.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6161.robot.RobotMap;

/**
 *
 */
public class climberBase extends Subsystem {
	
	public static final double climbspeed = 1;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController climbMotor; 
	
	public void init(){
		climbMotor = RobotMap.climberBaseclimbMotor;
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void ClimbUp(){
    	climbMotor.set(climbspeed);
    }
    public void ClimbDown(){
    	climbMotor.set(-climbspeed);
    }
    public void ClimbStop(){
    	climbMotor.set(0);
    }
}

