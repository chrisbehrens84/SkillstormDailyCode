package Java.Day2.FileiO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
  public static void main(String[] args) {
    String inputFile = "/Users/chrisbehrens/Desktop/SkillStorm/Java/Day2/FileiO/fileInput.txt";
    String outputFile = "Java/Day2/FileiO/fileOuptut.txt";

    try {
      
      InputStream inputStream = new FileInputStream(inputFile);
      OutputStream outputStream = new FileOutputStream(outputFile);

      int byteData;
      while((byteData = inputStream.read()) != -1){
        System.out.println(byteData);
        outputStream.write(byteData);
      }

      inputStream.close();
      outputStream.close();

    } catch (IOException ioException) {
      System.out.println("Error with opeing or closing files");
      ioException.printStackTrace();
    } catch (Exception e) {
      System.out.println("Something else went wrong");
      e.printStackTrace();
    }

    /*class loader and resource stream
    *
    * works similarly to FileInputStream
    *   the difference:
         getResoursesStream() grabs a static resouice from your classpath... is within your project
  
         very useful for apps not running on your local machine
    */

    String resoucePath = "Java/Day2/FileiO/fileInput.txt";

    try {
      InputStream inputStream = FileIO.class.getClassLoader().getResourceAsStream(resoucePath);

      if(inputStream != null){
        int byteData;
        while((byteData = inputStream.read()) != -1){
        System.out.println((char) byteData);
       
        }
      }
      inputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    /* Try with Resources
     *  still a try catch block
     * we pass in something that needs to be open(like a file stream)
     * and it will automatically close it for us
     * must implement the AutoCloseable Interface
     * 
     */

     try (FileInputStream fileInput = new FileInputStream(inputFile)) {
       int byteData;
        while((byteData = fileInput.read()) != -1){
        System.out.println((char) byteData);
       
        }

        //no longer any need to close the input stream
     } catch (Exception e) {
      e.printStackTrace();
     }
  }


}
