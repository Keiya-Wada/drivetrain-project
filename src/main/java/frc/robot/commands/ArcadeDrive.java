package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
    /* this is the config class*/
    public static final class Config{
        public static final int leftStickX = 0;
        public static final int rightStickX = 0;
        public static final double speedMult = 0.8;
        public static final double turnMult = 0.7;
        //placeholder variables
    }
    //makes the DriveTrain and Joytick variables
    private final DriveTrain m_drivetrain;
    private final Joystick m_joystick;

    //constructor method
    public ArcadeDrive(DriveTrain driveTrain, Joystick joystick) {
        
        //initializes the drivetrain and joystick variables//
        m_drivetrain = driveTrain;
        m_joystick = joystick;
        addRequirements(driveTrain);
    }
    
    @Override
    public void initialize() {


    }
    
    //executes code//
    @Override 
    public void execute () {

        double speed = m_joystick.getRawAxis(Config.leftStickX) * Config.speedMult;
        double turn = m_joystick.getRawAxis(Config.rightStickX) * Config.turnMult;
        
        m_drivetrain.DifferentialDrive().arcadeDrive(speed, turn);

    }
    
    //ends the code (or interrupts)//
    public void end (boolean interrupted) {
        m_drivetrain.DifferentialDrive().stopMotor();

    }

    //if the code is finished, then true turns to false, meaning the code is stopped
    public boolean isFinished () {
        return false;
    }

}




