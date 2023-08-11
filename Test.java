import quiz.Student;
import quiz.Teacher;
import java.util.*;
import java.lang.*;
public class Test
{
   public static void main(String[] args)
  {
    Scanner obj=new Scanner(System.in);
    Student s1=new Student("211001","Stu_001",0001);
    Student s2=new Student("211002","Stu_002",0002);
    Student s3=new Student("211003","Stu_003",0003);
    Student s4=new Student("211004","Stu_004",0004);
    Student s5=new Student("211005","Stu_005",0005);
    Student s6=new Student("211006","Stu_006",0006);
    Student s7=new Student("211007","Stu_007",0007);
    Teacher t1=new Teacher("111001","Tec_001");
    Teacher t2=new Teacher("111002","Tec_002");
    Teacher t3=new Teacher("111003","Tec_003");
    Teacher t4=new Teacher("111004","Tec_004");
    Teacher t5=new Teacher("111005","Tec_005");
    Teacher t6=new Teacher("111006","Tec_006");
    Teacher t7=new Teacher("111007","Tec_007");
    Teacher t8=new Teacher("111008","Tec_008");
    Teacher t9=new Teacher("111009","Tec_009");
    
    String who;
    String operation;
    String entry;
    String reset;
    int n;
    int index=0;
    System.out.print("ENTER YOU WANTED TO LOGIN AS TEACHER OR STUDENT:");
    who=obj.nextLine();
    if(who.equalsIgnoreCase("teacher"))
    {
      Teacher control=new Teacher();
      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t\t\t\t\t\t\tTEACHER USER INTERFACE");
      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      String login;
      System.out.print("\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\tENTER THE LOGIN:");
      login=obj.nextLine();
      String password;
      System.out.print("\t\t\t\t\t\t\t\t\t\tENTER THE PASSWORD:");
      password=obj.nextLine();
      System.out.print("\n\n\n");
      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
      if(control.check_cred(login,password)==1)
      {
        System.out.println("\t\t\t\t\t\t\t\t\t\tYOU HAVE LOGGED IN SUCCESSFULLY\n\n");
      System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
        
        System.out.print("DO YOU WANT TO UPLOAD THE QUIZ(YES/NO):");
        operation=obj.nextLine();
        if(operation.equalsIgnoreCase("yes"))
        {
           System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
          System.out.print("ENTER THE NUMBER OF QUESTIONS:");
          n=obj.nextInt();
          control.set_que(n);
        }
      }
      else
      {
        System.out.print("\t\t\t\t\t\t\t\t\t\tLOGIN ID OR PASSWORD INCORRECT");
        
        
      }
      System.out.println("\n\n\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    else
    {
      Student rep=new Student();
      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      System.out.println("\n\n\t\t\t\t\t\t\t\t\t\tSTUDENT USER INTERFACE");
      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      String login;
      System.out.print("\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\tENTER THE LOGIN:");
      login=obj.nextLine();
      String password;
      System.out.print("\t\t\t\t\t\t\t\t\t\tENTER THE PASSWORD:");
      password=obj.nextLine();
      System.out.print("\n\n\n");
      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
      if(rep.check_cred(login,password)==1)
      {
        
        System.out.print("\t\t\t\t\t\t\t\t\t\tYOU HAVE LOGINED SUCCESSFULLY");
        System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
        System.out.print("\n\nDO YOU WANT TO ATTEND THE QUIZ(YES/NO):");
        String op=obj.nextLine();
        System.out.println("\n\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
        if(op.equalsIgnoreCase("yes"))
        {
          rep.attend_quiz();
        }
      }
      else
      {
        System.out.print("\t\t\t\t\t\t\t\t\t\tLOGIN ID OR PASSWORD INCORRECT");
      }
      System.out.println("\n\n\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
  }
  
}