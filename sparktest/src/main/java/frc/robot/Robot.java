/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  XboxController controller1 = new XboxController(0);
     
  private CANEncoder m_encoder;
  private CANSparkMax m_motor;



  @Override
  public void robotInit() {

    m_motor = new CANSparkMax(10, MotorType.kBrushless);
    m_motor.restoreFactoryDefaults();
    m_encoder = m_motor.getEncoder();




  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
  
    double setvalue = controller1.getRawAxis(1);
    SmartDashboard.putNumber("axis", setvalue);
    m_motor.set(setvalue);
  //  m_motor.set(.5);

SmartDashboard.putNumber("Encoder Position", m_encoder.getPosition());
SmartDashboard.putNumber("Encoder Velocity", m_encoder.getVelocity());
  
  }



  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
