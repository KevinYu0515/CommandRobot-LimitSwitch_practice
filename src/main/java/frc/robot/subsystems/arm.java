/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class arm extends SubsystemBase {

  DigitalInput limitSwitch = new DigitalInput(9);
  VictorSPX armMotor = new VictorSPX(2);
  Counter counter = new Counter(limitSwitch);

  public boolean isSwitchSet() {
    SmartDashboard.putNumber("count", counter.get());
    return counter.get() > 0;
  }
  public void initializeCounter() {
    counter.reset();
  }
  
  public void armUp() {
    armMotor.set(ControlMode.PercentOutput,0.1);
  }
  
  public void armDown() {
    armMotor.set(ControlMode.PercentOutput,-0.1);
  }
  
  public void armStop() {
    armMotor.set(ControlMode.PercentOutput,0);
  }
  protected void initDefaultCommand() {
  }
}
