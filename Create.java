package quiz;
import java.io.File;  
import java.io.IOException;  

public class Create
{
  public static void create_file(String name)
  {
      String nm;
      nm=name+".txt";
      File myObj = new File(nm);
    try
      {
        if (myObj.createNewFile())
        {
          //System.out.println("File created: " + myObj.getName());
        } 
        else 
        {
          System.out.println("File already exists.");
        }
      }
      catch (IOException e) 
      {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      
  }
}