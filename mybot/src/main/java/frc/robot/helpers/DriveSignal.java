package frc.robot.helpers;



public class DriveSignal{

    private double leftSpeed;
    private double rightSpeed;

    public DriveSignal(double leftSpeed, double rightSpeed){
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }



    public void setL(double leftSpeed){
        this.leftSpeed = leftSpeed;
    }

    public void setR(double rightSpeed){
        this.rightSpeed = rightSpeed;
    }

    public double getL(){
        return leftSpeed;
    }

    public double getR(){
        return rightSpeed;
    }

}