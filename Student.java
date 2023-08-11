package quiz;
import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Student extends Create
{
  private String login;
  private String password;
  private int roll_num;
  int flag;
  int index;
  static ArrayList<String> login_details=new ArrayList<String>();
  static ArrayList<String>password_details=new ArrayList<String>();
  static ArrayList<String> topic=new ArrayList<String>();
  static Set<String> name_topic=new LinkedHashSet<String>();
  
ArrayList<LeaderBoard> al=new ArrayList<LeaderBoard>();
  Scanner obj=new Scanner(System.in);
  //File myObj = new File("answers.txt");
  public Student()
  {
    
  }
  public Student(String login,String password)
  {
    this.login=login;
    this.password=password;
    login_details.add(login);
    password_details.add(password);
  }
  public Student(String login,String password,int roll_num)
  {
    this.login=login;
    this.password=password;
    this.roll_num=roll_num;
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
  
  
  public void attend_quiz()
  {
    int count=0;
    int score;
    try
    {
        BufferedReader br= new BufferedReader(new FileReader("topic_details.txt"));
        String content;
        String choosen;
        String ans;
        System.out.println("THE AVAILABLE QUIZ TOPICS ARE\n");
        while ((content = br.readLine()) != null)
        {
            name_topic.add(content);
        }
        br.close();
        Iterator newData = name_topic.iterator(); 
        while (newData.hasNext()) 
        {   
            System.out.println(newData.next());   
        }  
        System.out.print("ENTER THE TOPIC OF THE QUIZ WHICH YOU HAVE TO ATTEND:");
        choosen=obj.nextLine();
        FileWriter mywriter=new FileWriter("answers.txt");
        BufferedReader br1=new BufferedReader(new FileReader(choosen+".txt"));
        while((content=br1.readLine())!=null)
        {
          if(count!=5)
          {
            System.out.println(content);
            count++;
          }
          else
          {
            System.out.print("ENTER THE ANSWER:");
            ans=obj.nextLine();
            mywriter.write(ans+"\n");
            count=0;
          }
            
        }
        br1.close();
        mywriter.close();
        System.out.println("SCORE:"+Compare.score_calculation(choosen));
      score=Compare.score_calculation(choosen);
      String scor=Integer.toString(score);
     PrintWriter mywriter1 = new PrintWriter(new BufferedWriter(new FileWriter(choosen+"_leaderboard.txt", true)));
      mywriter1.write(login+" "+scor+"\n");
      mywriter1.close();
      BufferedReader br2=new BufferedReader(new FileReader(choosen+"_leaderboard.txt"));
      System.out.println("\n\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
      System.out.println("LEADER BOARD OF THE QUIZ:"+choosen+"\n\n\n");
      System.out.println("\n\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
      System.out.println("ROLL      SCORE");
      System.out.println("NUMBER");
      System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
      while((content=br2.readLine())!=null)
            {
                String[] con=content.split(" ");
                al.add(new LeaderBoard(Integer.parseInt(con[1]),con[0]));
            }
          Collections.sort(al,Collections.reverseOrder());
          for(LeaderBoard l:al)
          {
            System.out.println(l);
          }
      br2.close();
      PrintWriter mywriter2 = new PrintWriter(new BufferedWriter(new FileWriter(choosen+"_leaderboard.txt")));
      for(LeaderBoard e:al)
            {
                mywriter2.write(e.toString()+"\n");
            }
      mywriter2.close();    
        
    }
    catch (IOException e) 
    {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    
  }
}