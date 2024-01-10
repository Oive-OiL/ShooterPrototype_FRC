// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Falcon extends SubsystemBase {
  private final WPI_TalonFX m_motor1 = new WPI_TalonFX(1); // deviceNumber is the CAN id of that motor.
  private final WPI_TalonFX m_motor2 = new WPI_TalonFX(2); // Make sure to change falcon motors to these numbers.
  private final WPI_TalonFX m_motor3 = new WPI_TalonFX(3);
  private final WPI_TalonFX m_motor4 = new WPI_TalonFX(4);

  private double commandedRawInput1;
  private double commandedRawInput2;
  private double commandedRawInput3;
  private double commandedRawInput4;
  
  /** Creates a new Shooter. */
  public Falcon() {}

  private double convertToPercentage(double inputValue) {
    double percent;
    percent = inputValue * 0.01;
    return percent;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.getNumber("Motor_1_Percent_Output", commandedRawInput1); // Input is converted to percent
    SmartDashboard.getNumber("Motor_2_Percent_Output", commandedRawInput2); // Example:
    SmartDashboard.getNumber("Motor_3_Percent_Output", commandedRawInput3); // Input = 10
    SmartDashboard.getNumber("Motor_4_Percent_Output", commandedRawInput4); // 10 converted to a 0.1 output
    m_motor1.set(convertToPercentage(commandedRawInput1));
    m_motor2.set(convertToPercentage(commandedRawInput2));
    m_motor3.set(convertToPercentage(commandedRawInput3));
    m_motor4.set(convertToPercentage(commandedRawInput4)); // Sets motor to desired output in percent.
  }
}
