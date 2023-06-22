package Java.Day2.MultiThreading;

public class MultiThreadingIntro {
  /*
   *  splitting different task onto multiple thread to be done concurrently
   * by default we have the single Main Thread that gets run
   * 
   * Trade-off: performance speed vs power/resource usage;
   * 
   * 
   * Thread States
   *    1. New - created but it is not yet started (new thread)
   *    2. Runnable - thread has started (thread.start)
   *    3. Blocked - THread is waiting on some lock before continuing 
   *    4. Waiting - thread waiting indefinitly (thread.join or thread.wait())
   *    5. Timed Waiting - We are now wating but fir a soecfied amount of time (thread.joind(3000))
   *    6. Terminated - Thread is finished
   */
  public static void main(String[] args) {

    //creating instances of the runnable class
    RunnableTask task1 = new RunnableTask("Task 1");
    RunnableTask task2 = new RunnableTask("Task 2");
    RunnableTask task3 = new RunnableTask("Task 3");

    //using THread class to make our threads
    //these threads are in the new state
    Thread thread1 = new Thread(task1);
    Thread thread2 = new Thread(task2);
    Thread thread3 = new Thread(task3);

    //using .start() to make the threads run
    // this puts them into that runnable state
    thread1.start();
    thread2.start();
    thread3.start();

    // .join() telling the Main thread to wait for thread1 before it finishes
    // this puts the Main Thread into a waiing state until thread 1 enters terminated state
    try {
      thread1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

  /*
   * Runnable Interface
   * a functional Interface for defining how threads will run
   *    a functional interface is hust a inteface with one method
   */

   class RunnableTask implements Runnable{
     private String taskName;

     public RunnableTask(String taskName){
      this.taskName = taskName;
     }

     @Override
     public void run(){
      System.out.println("Task " + taskName + " running in the Thread " + Thread.currentThread().getName());

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(taskName + " Has Finished");
     }
   }

