package org.firstinspires.ftc.teamcode;
//importing the hard ware map
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//This indicates whether you want to run teleop or autonomous mode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "TeleOp Test", group = "Tests")
//@Disabled
// Linear OpMode is what gives you access to run OpMode, you only run the code once and all of your code is inside of it
//It gives you one method.
//iterative OpMode gives you two methods. One is init, and it is called once, after you initialize your robot
// the second method is loop which is repeatedly called after hitting start until you hit stop
public class TeleOpTest extends LinearOpMode
{
    //Declarations of Motors
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private Servo clampServo;
    // this eliminates any magic numbers, or numbers without any meaning within our code. Defining numbers is useful
    //when we want to know what the number represents in reality
    //the names should reflect the purpose or literal meaning of that value in the real world
    private static final double ARM_RETRACTED_POSITION = 0.2;
    private static final double ARM_EXTENDED_COMPLETELY_POSITION = 0.8;

    @Override
    public void runOpMode() throws InterruptedException
    {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        //Initializations of Motors via Hardware Map*- *Includes everything on USB bus of the robot controller phone
        //We also need to match the motor objects to the physical motors config name
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        //This is the reversal of one motor, which would send the robot moving in a circle
        //Depending on hardware config, we may need to reverse more than one wheel (mecanum, etc.)
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        // in this while loop goes the code to control the drive motors

        waitForStart();

        while(opModeIsActive())
        {// The motors have a method() which is called setPower which can take a number ranging from -1 to 1
         // 1 is full forward and zero stops the motor, -1 is full reverse
         //The joysticks return a value from -1 to 1 as well, therefore we can set the left motor power to the left joy sticks
         // y axis value (vertical push up completely for full speed forward)
         //The same thing can be done for the right joystick
            motorLeft.setPower(gamepad1.left_stick_y);
            motorRight.setPower(gamepad1.right_stick_y);
            //This says that if a has been pressed on the gamepad then the servo is set at a position of 0.8.
            //In reality, servos have a range of 0 to 180 degrees, meaning that 0.8 is really a 144 degree rotation
            //0= 0 degrees and 1= 180 degrees
            if(gamepad2.a)
            {
                clampServo.setPosition(0.8);
            }
            if(gamepad2.b)

                clampServo.setPosition(0.2);

            idle();
        }
    }
}
