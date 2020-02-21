/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.arm;

/**
 * An example command that uses an example subsystem.
 */
public class Commandarm extends CommandBase {
  private arm _arm;

  public Commandarm(arm subsystem) {
    _arm = subsystem;
    addRequirements(_arm);
  }

  @Override
  public void initialize() {
    _arm.initializeCounter();
    _arm.armUp();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    _arm.armStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return _arm.isSwitchSet();
  }
}
