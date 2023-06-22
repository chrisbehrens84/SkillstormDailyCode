package Java.Day1.FourPillars;

public class Car {
  String engine;
  String make;
  String model;

  public Car() {
  }

  public Car(String engine, String make, String model) {
    this.engine = engine;
    this.make = make;
    this.model = model;
  }

  public String getEngine() {
    return engine;
  }

  public void setEngine(String engine) {
    this.engine = engine;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  @Override
  public String toString() {
    return "Car [engine=" + engine + ", make=" + make + ", model=" + model + "]";
  }

  
  
}
