package org.usfirst.frc.team6161.robot.subsystems;

import org.usfirst.frc.team6161.robot.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class roombaBase extends Subsystem {
	
	public static final double roombaSpeed = 1;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController roombaMotor; // = RobotMap.roombaBaseRoombaMotor;

	public void init() {
		roombaMotor = RobotMap.roombaBaseRoombaMotor;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void RoombaIn(){
    	roombaMotor.set(roombaSpeed);
    }   
    public void RoombaOut(){
    	roombaMotor.set(-roombaSpeed);
    }
    public void RoombaStop(){
    	roombaMotor.set(0);
    }
}

