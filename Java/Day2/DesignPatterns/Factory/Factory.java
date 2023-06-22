package Java.Day2.DesignPatterns.Factory;

/*
 * FACTORY
 *    you don't instantiate objects - the factory does
 * 
 *    you have one general class or interface with a bunch of child objects
 *      rather that your main class depending on All the childobjects, it only has to depend in the factory
 * 
 * 
 *    COUPLING VS COHESION
 *        cohesion refers to relationships within your class
 *          low cohesion means that a class performs many differnt things
 *          high cohesion means that your class is focused on a specfic set of tasks
 *        coupling refers to realtionships betweendifferent classes
 *          low coupling means you're dependent on few classes
 *           high coupling means you're very dependent on many classes
 * 
 *      in code: we want HIGH COHESION and LOW COUPLING
 * 
 * 
 *    The point of the factory is to DECOUPLE your code - lower your coupling
 */


public class Factory {
  public static void main(String[] args) {
   Superhero captin = SuperheroFactory.createSuperhero("Captian America");
   Superhero AP = SuperheroFactory.createSuperhero("AustinPowers");
   captin.activateSuperPower();
   captin.sayName();
   AP.activateSuperPower();
   AP.sayName();
  }
}

class SuperheroFactory {
  public static Superhero createSuperhero(String type){
    if(type.equals("Captian America")) {
      return new CaptianAmerica();
    }
    else if(type.equals("Austin")){
      return new Austin();
    }
    else if(type.equals("AustinPowers")){
      return new AustinPowers();
  }else {
    throw new IllegalArgumentException("invalid Superhero " + type);
  }
}

}


