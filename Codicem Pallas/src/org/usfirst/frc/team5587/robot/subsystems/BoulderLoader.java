package org.usfirst.frc.team5587.robot.subsystems;

import org.usfirst.frc.team5587.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BoulderLoader extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private Servo loader;
	public BoulderLoader()
	{
		loader = new Servo( RobotMap.LOADING_SERVO );
	}
	
	public void setAngle( double angle )
	{
		loader.setAngle( angle );
	}
	
	public double getAngle()
	{
		return loader.getAngle();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
