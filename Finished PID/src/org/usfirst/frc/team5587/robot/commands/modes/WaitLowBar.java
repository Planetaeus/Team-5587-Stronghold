package org.usfirst.frc.team5587.robot.commands.modes;

import org.usfirst.frc.team5587.robot.Robot;
import org.usfirst.frc.team5587.robot.commands.WaitTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class WaitLowBar extends CommandGroup {
    
    public  WaitLowBar() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	requires( Robot.hooves );
    	addSequential( new WaitTime( 7 ) );
    	addSequential( new LowAuto() );
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
