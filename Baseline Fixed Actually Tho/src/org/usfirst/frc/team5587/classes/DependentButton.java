package org.usfirst.frc.team5587.classes;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class DependentButton extends JoystickButton 
{
	
	public DependentButton(GenericHID stick, int buttonNumber ) 
	{
		super( stick, buttonNumber );
		// TODO Auto-generated constructor stub
	}
	
	public void whenPressed( final Command command, Button conditionButton )
	{
		if( conditionButton.get() )
		{
			this.whenPressed( command );
		}
	}
}
