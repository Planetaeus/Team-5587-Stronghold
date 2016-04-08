package org.usfirst.frc.team5587.robot.commands;

import org.usfirst.frc.team5587.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BlindThemAll extends Command {

    public BlindThemAll() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires( Robot.light );
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.light.blind();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.light.sleep();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
