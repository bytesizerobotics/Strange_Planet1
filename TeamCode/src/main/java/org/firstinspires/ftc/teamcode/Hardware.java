package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware {
    //null is nothing, because we are not running the motor yet
    //public just makes sure that your programs have access to the class
    //Dc Motors are direct current motors, referring to the battery and how it operates

    public DcMotor leftMotor = null;
    public DcMotor rightMotor = null;

    private DcMotor.RunMode initialMode = null;
    //Hardware Map is a map of all of your robots components
    HardwareMap map = null;

    public Hardware

    public void init (HardwareMap aMap)
    {
        map = aMap;

        leftMotor = map.dcMotor.get("left_Motor");
        rightMotor = map.dcMotor.get("right_Motor");

        //ENCODERS
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }


}
