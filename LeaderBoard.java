package quiz;
import java.util.*;
import java.lang.*;
import java.io.*;
public class LeaderBoard implements Comparable<LeaderBoard>
  {
    private int mark;
    private String roll;
    LeaderBoard(int mark,String roll)
    {
      this.mark=mark;
      this.roll=roll;
    }
    public String toString()
    {
      return roll+" "+mark;
    }
    public int compareTo(LeaderBoard m)
    {
      if(mark>m.mark)
        return 1;
      else
        return -1;
    }
  
  }
