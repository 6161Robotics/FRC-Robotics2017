package org.usfirst.frc.team6161.robot.commands;


import org.usfirst.frc.team6161.robot.commands.slowdriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMidGear extends CommandGroup {

    public AutoMidGear() {
    	addSequential(new slowdriveForward(2));
    	addSequential(new AutoMidGearLoad());
    	addSequential(new AutoMidGearUnLoad());
    }
}
