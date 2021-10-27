package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{

    public static final class Config {
        public static final int LeftMasterMotorID = 2;
        public static final int RightMasterMotorID = 1;
        // public static final int LeftServantMotorID = 0;
        // public static final int RightServantMotorID = 0; 
    }
    
    private CANSparkMax RightMasterMotor = new CANSparkMax(Config.RightMasterMotorID,MotorType.kBrushless);
    private CANSparkMax LeftMasterMotor = new CANSparkMax(Config.LeftMasterMotorID,MotorType.kBrushless);
    // private CANSparkMax RightServantMotor = new CANSparkMax(Config.RightServantMotorID,MotorType.kBrushless);
    // private CANSparkMax LeftServantMotor = new CANSparkMax(Config.LeftServantMotorID,MotorType.kBrushless);
    
    public DifferentialDrive m_Drive = new DifferentialDrive(LeftMasterMotor, RightMasterMotor);

    public DriveTrain (){
        RightMasterMotor.setInverted(true);
        LeftMasterMotor.setInverted(true);
        //inverts master motors
        // RightServantMotor.follow(RightMasterMotor);
        // LeftServantMotor.follow(LeftMasterMotor);
        //servant following master 

    }
    
    public void BreakMode () {
        RightMasterMotor.setIdleMode(IdleMode.kBrake);
        LeftMasterMotor.setIdleMode(IdleMode.kBrake);
        // RightServantMotor.setIdleMode(IdleMode.kBrake);
        // LeftServantMotor.setIdleMode(IdleMode.kBrake);
    }

    public void CoastMode () {
        RightMasterMotor.setIdleMode(IdleMode.kCoast);
        LeftMasterMotor.setIdleMode(IdleMode.kCoast);
        // RightServantMotor.setIdleMode(IdleMode.kCoast);
        // LeftServantMotor.setIdleMode(IdleMode.kCoast);
    }

    public IdleMode getMode() {
        return RightMasterMotor.getIdleMode();
    }

    public IdleMode getMode2() {
        return RightMasterMotor.getIdleMode();
    }

    public DifferentialDrive DifferentialDrive()  {
        return m_Drive;
    }
}


