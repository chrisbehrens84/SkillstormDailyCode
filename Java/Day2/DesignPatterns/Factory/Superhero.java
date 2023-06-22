package Java.Day2.DesignPatterns.Factory;

public interface Superhero {
  void activateSuperPower();
  void sayName();
  
}


class CaptianAmerica implements Superhero{

  @Override
  public void activateSuperPower() {
    // TODO Auto-generated method stub
    System.out.println("I can do this all day");;
  }

  @Override
  public void sayName() {
    System.out.println("I am Steve Rogers");;
  }
}
class Austin implements Superhero{

  @Override
  public void activateSuperPower() {
    // TODO Auto-generated method stub
    System.out.println("I can be a Java Guru");;
  }

  @Override
  public void sayName() {
    System.out.println("I am Autin");;
  }
}
  class AustinPowers implements Superhero{

    @Override
      public void activateSuperPower() {
      System.out.println("I am Smelting");;
  }

  @Override
  public void sayName() {
    System.out.println("Yah baby");;
  }

 }



