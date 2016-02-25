
package org.usfirst.frc.team5587.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team5587.robot.commands.Angler2;
import org.usfirst.frc.team5587.robot.commands.GivenMove;
import org.usfirst.frc.team5587.robot.commands.Move;
import org.usfirst.frc.team5587.robot.subsystems.EncodedMotor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final EncodedMotor motor = new EncodedMotor( RobotMap.MOTOR_CHANNEL,
																		  RobotMap.ENCODER_A,
																		  RobotMap.ENCODER_B);
	public static OI oi;

	CameraServer server;
    Command teleOp;
    Command auto;
    SendableChooser chooser;
    NetworkTable table;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		teleOp = new Move( RobotMap.DRIVER );
		auto = new GivenMove( 360 );
		
		server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        
        table = NetworkTable.getTable("GRIP");
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	motor.reset();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
    	auto.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        auto.cancel();
    	teleOp.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Angler2 a = new Angler2( table );
        SmartDashboard.putString( "DB/String 0", "" + motor.getRaw() );
        SmartDashboard.putString( "DB/String 1", "" + motor.get() );
        SmartDashboard.putString( "DB/String 2", "" + motor.getAngle() );
        SmartDashboard.putString( "DB/String 3", "" + a.index );
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
