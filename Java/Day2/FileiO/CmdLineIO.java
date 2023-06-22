package Java.Day2.FileiO;

import java.io.PrintWriter;
import java.util.Scanner;

public class CmdLineIO {
  public static void main(String[] args) {
    System.out.println("Hello world");


    Scanner scanIn = new Scanner(System.in);
    String textInput = scanIn.nextLine();
    System.out.println("You Entered: " + textInput);

    System.out.println("Enter a number: ");
    double intInput =scanIn.nextDouble();
    System.out.println("You want this many tacos: " + intInput);

    scanIn.close();

    // Print Writer
    //allows for better formatting of print statments
    // also allows you to queue up several prints and flush them out at once

    String name = "Brendon";
    int age = 22;
    double height = 173.5;

    System.out.println(name + " is " + age + " years old and is " + height + "cm tall");

    PrintWriter consoleOut = new PrintWriter(System.out);
    consoleOut.printf("%s is %d years old and is %.2f cm tall\n", name, age, height);
    consoleOut.print("Yolo\n");
    consoleOut.flush();
  }
}
