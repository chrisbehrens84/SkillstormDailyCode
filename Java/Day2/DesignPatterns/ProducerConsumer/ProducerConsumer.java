package Java.Day2.DesignPatterns.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 *  one entity (usually a thread) produces data (generate/recieve/ read in)
 *  another entity (usually a thread) consumes that dat (process/manage/manipulate)
 * 
 * use multithreading in java to do this
 * 
 * 
 */

public class ProducerConsumer {

  public static void main(String[] args) {
    /*
     * Concurrent Collections
     *    java.util.concurrent
     *    thread safe collections
     *      they will handle synchronization for us
     */

     final Queue<Integer> buffer = new ConcurrentLinkedQueue<>(); //size of the collection will never change
     final int CAPACITY = 5; // final means the value cannot be changed - capacity will always be 5

     Thread producerThread = new Thread(new Runnable(){
        /*
         * Annonums Inner class
         *    a class that isn't declared but it is defined
         *    only created with functional interfaces
         */
     

      @Override
      public void run(){
        //simulating grabbing these value from somewhere and putting them on the queue
        int value = 0;
        while(true){
          if(buffer.size() < CAPACITY){
            System.out.println("Producer Produces: " + value);
            buffer.add(value++);
          }
        }
      }
    });

    /*
     * Lamda Function
     *    Shorthand way to implement methods of a functional interface
     * 
     */

    Thread consumerThread = new Thread((/*Any Parameters for the method */) -> {

      //This is the run method from the runnable class
      while(true){
        if(!buffer.isEmpty()){
          int value = buffer.poll(); //poll - retreiving the data at the front of the queue
          System.out.println("Consumer consumes" + value);
        }
      }
    });
      producerThread.start();
      consumerThread.start();
  }
}
