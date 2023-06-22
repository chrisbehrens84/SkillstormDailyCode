package Java.Day2.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPractice {
  
  /*
   * Every thread has its own stack
   *    so things like methods and instance variables, each thread willhave its own copy of
   *    volatile - synchronization across threads
   *         won't block othere threads from manipulating the variable
   * 
   *    static - means there is only 1 reference in memory
   */
  
  private static volatile int count = 0;

  /*
   *  ATOMIC VALUES
   *    basically means "all at once" and "All or none"
   *    
   *    AtomicInteger, AtomicDouble
   *      creates thread-safe versions of the primitive type
   * 
   *    All methods in java are atomic by default
   */

   private static AtomicInteger atomicCount = new AtomicInteger(0);

   public static void increment(){
     count ++;
     atomicCount.incrementAndGet();
   }
  public static void main(String[] args) {
    CustomThread t1 = new CustomThread(10000000);
    CustomThread t2 = new CustomThread(10000000);

    //expected results - count and atomic count should be 20000000
    t1.start();
    t2.start();
    System.out.println("current count is " + count);

    try {
      t1.join();
      t2.join();
    } catch (Exception e) {
     e.printStackTrace();
    }

    System.out.println("total count is " + count);
    System.out.println("Atomic count is " + atomicCount);

    /*
     * Concurrency Issues
     *    lost update - when a variable is updated, but is then chaged immediatly after something else
     * 
     */
  }
}



  class CustomThread extends Thread{
    private int loopAmount;

    public CustomThread(int loopAmount){
      this.loopAmount = loopAmount;
    }

    @Override
    public void run(){
      for(int i = 0; i < loopAmount; i++){
        ThreadPractice.increment();
      }
    }

  }

