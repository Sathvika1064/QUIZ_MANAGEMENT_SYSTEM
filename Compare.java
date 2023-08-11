
package quiz;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Compare
{
    public static int score_calculation(String topic)
    {
        int score=0;
        try
        {
          String content;
          String key;
          BufferedReader br= new BufferedReader(new FileReader("answers.txt"));
          BufferedReader br1= new BufferedReader(new FileReader(topic+"_ans.txt"));
          while ((content = br.readLine()) != null)
          {
            key=br1.readLine();
            if(content.equals(key))
            {
              score++;
            }
          }
          br.close();
          br1.close();
          return score;
        }
        catch (IOException e) 
        {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      return score;
        
      
    }
      catch (IOException e) 
      {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
}