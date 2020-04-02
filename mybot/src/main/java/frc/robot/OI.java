package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;


public class OI {

    private static XboxController driveController = new XboxController(0);
    private static double speed;

    public OI() {}


    public static double getSpeed() {
        speed = 0;
        speed += driveController.getTriggerAxis(GenericHID.Hand.kRight);
        speed -= driveController.getTriggerAxis(GenericHID.Hand.kLeft);
        return speed;
    }

    public static double getYaw(){
        return driveController.getX(GenericHID.Hand.kRight);
    }










}