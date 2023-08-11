package quiz;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Teacher extends Create
{
  private String login;
  private String password;
  int flag;
  int index;
  static ArrayList<String> login_details=new ArrayList<String>();
  static ArrayList<String>password_details=new ArrayList<String>();
  public Teacher()
  {
    
  }
  public Teacher(String login,String password)
  {
    this.login=login;
    this.password=password;
    login_details.add(login);
    password_details.add(password);
  }
  public void setlogin(String login)
  {
    this.login=login;
    login_details.add(login);
    
  }
  public void setpassword(String password)
  {
    this.password=password;
    password_details.add(password);
  }
  public int check_cred(String login,String password)
  {
    flag=0;
    for(String check:login_details)
    {
        if(check.equals(login))
        {
          index=login_details.indexOf(login);
          if(password_details.get(index).equals(password))
          {
            flag=1;
            this.login=login;
            this.password=password;
            break;
          }
        }
    }
    return flag;
  }
  
  public void set_que(int n)
  {
    try
    {
        Scanner obj=new Scanner(System.in);
        System.out.print("ENTER THE NAME OF THE QUIZ:");
        String topic=obj.nextLine();
        Create.create_file(topic);
        //Addtopic.add_topic(topic);
        Create.create_file(topic+"_ans");
        Create.create_file(topic+"_leaderboard");
        String filename=topic+".txt";
        String ansfile=topic+"_ans.txt";
        int j=0;
        String ques;
        String option;
        String ans;
        FileWriter myWriter = new FileWriter(filename);
        FileWriter myWriter1 = new FileWriter(ansfile);
        FileWriter myWriter2=new FileWriter("topic_details.txt",true);
        BufferedWriter bufferedwriter=new BufferedWriter(myWriter2);
        bufferedwriter.write(topic+"\n");
        //myWriter2.write(topic);
        for(int i=0;i!=n;i++)
        {
            System.out.print("ENTER QUESTION "+(i+1)+":");
            ques=obj.nextLine();
            myWriter.write(ques);
            while(j!=4)
            {
              if(j==0)
              {
                System.out.print("ENTER THE OPTION a:");
                option=obj.nextLine();
                myWriter.write("\na."+option);
                j++;
              }
              else if(j==1)
              {
                System.out.print("ENTER THE OPTION b:");
                option=obj.nextLine();
                myWriter.write("\nb."+option);
                j++;
              }
              else if(j==2)
              {
                System.out.print("ENTER THE OPTION c:");
                option=obj.nextLine();
                myWriter.write("\nc."+option);
                j++;
              }
              else
              {
                System.out.print("ENTER THE OPTION d:");
                option=obj.nextLine();
                myWriter.write("\nd."+option);
                j++;
              } 
            }
            j=0;
            myWriter.write("\n\n");
            System.out.print("ENTER THE CORRECT OPTION:");
            ans=obj.nextLine();
            myWriter1.write(ans+"\n");
            System.out.println("\n");
        }
        myWriter.close();
        myWriter1.close();
        bufferedwriter.close();
        myWriter2.close();
    }
    catch (IOException e) 
    {
        System.out.println("An error occurred.");
        e.printStackTrace();
    } 
  }
}