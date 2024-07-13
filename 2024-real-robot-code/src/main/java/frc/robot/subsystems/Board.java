// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Board extends SubsystemBase {
  CANSparkMax m_CANMotor = new CANSparkMax(7, MotorType.kBrushless);
  Spark m_PWMMotor = new Spark(9);

  /** Creates a new Board */
  public Board() {
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

  public Command setSpeedCAN(double speed) {
    return this.run(() -> m_CANMotor.set(speed));
  }

  public Command setSpeedPWM(double speed) {
    return this.run(() -> m_PWMMotor.set(speed));
  }

  public Command turnOffMotors() {
    return this.run(() -> {
      m_CANMotor.set(0);
      m_PWMMotor.set(0);
    });
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
