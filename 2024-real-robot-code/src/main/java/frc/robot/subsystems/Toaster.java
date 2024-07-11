// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Toaster extends SubsystemBase {
  /** Creates a new Drivebase. */
  private CANSparkMax m_wheelMotor = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax m_2wheelMotor = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax m_rollerMotor = new CANSparkMax(3, MotorType.kBrushless);
  
  public Toaster() {
    m_2wheelMotor.follow(m_wheelMotor, true);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public void runMotors(double speed) {
    m_wheelMotor.set(speed);
    m_rollerMotor.set(speed);
  }


  public Command inTake(double speed) {
    return this.run(() -> runMotors(speed));
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

}
