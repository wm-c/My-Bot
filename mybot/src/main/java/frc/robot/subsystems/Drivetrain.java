package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.helpers.DriveSignal;




public class Drivetrain extends SubsystemBase{

    private WPI_TalonSRX rightMaster = new WPI_TalonSRX(1);
    private WPI_TalonSRX rightSlave = new WPI_TalonSRX(2);

    private WPI_TalonSRX leftMaster = new WPI_TalonSRX(3);
    private WPI_TalonSRX leftSlave = new WPI_TalonSRX(4);

    DriveSignal currentDriveSignal = new DriveSignal(0, 0);

    public Drivetrain(){
        rightMaster.configFactoryDefault();
        rightSlave.configFactoryDefault();
        rightSlave.follow(rightMaster);

        leftMaster.configFactoryDefault();
        leftSlave.configFactoryDefault();
        leftSlave.follow(leftMaster);

    }


    @Override
    public void periodic(){
        SmartDashboard.putNumber("Speed", OI.getSpeed());
        currentDriveSignal = calcDrive();

        rightMaster.set(currentDriveSignal.getR());
        leftMaster.set(currentDriveSignal.getL());



    }

    public DriveSignal calcDrive(){
        double speed = OI.getSpeed();
        double rotation = OI.getYaw();

        return new DriveSignal(speed + rotation, speed - rotation);
    }

    public void stop(){
        rightMaster.set(0);
        leftMaster.set(0);
    }
}