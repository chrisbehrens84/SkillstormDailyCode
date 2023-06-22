package Java.Day2.DesignPatterns.Singleton;

/*
 * Singletons
 * 
 *   When you only want ONE instance of an object
 * 
 *  useful when working with threads  - every thread will be using the same object
 */



public class Singleton {

  /*
   * Eager VS Lazy loading
   * 
   *  eagerly loading - instantiate object as soon as possible
   *     Faster but could result in unessary memory allocation
   * 
   *  lazy loading - only instantiate the object when it is asked for
   *      slower but no memory is wasted
   */

  private static Singleton instance;  //this is the object
  // private static SIngleton ins = new Singleton(); this is eagerly loading


  private int count = 0;

  public Singleton(){

  }

  public void increment(){
    this.count++;
  }

   public void decrement(){
    this.count--;
  }

   public int getCount(){
    return this.count;
  }

  public static Singleton getInstance(){
    //return ins;   if eagerly loading, return the instance

    if(instance == null){
      instance = new Singleton();
    }

    return instance;
  }

}
