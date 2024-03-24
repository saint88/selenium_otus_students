package exceptions;

import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverTypeNotSupported extends Exception {

  public DriverTypeNotSupported(DriverManagerType driverType) {
    super(String.format("Browser type %s doesn't support", driverType.name()));
  }

  public DriverTypeNotSupported(String driverType) {
    super(String.format("Browser type %s doesn't support", driverType));
  }
}