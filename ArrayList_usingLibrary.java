import java.util.ArrayList;
public class ArrayList_usingLibrary 
{
    public static void main(String[] args)
    {
        int n = 10;
        
      ArrayList<Integer> arrylist = new ArrayList<Integer>(n);
      
      for(int i = 0; i < n; i++)
        arrylist.add(i);
      
      System.out.println("Printing Elements:-->" + arrylist);
      System.out.println("Remove Element At Index 5:-->" + arrylist.remove(5));
      System.out.println("Display The ArrayList:--> " + arrylist);
      
      for(int i = 0; i < arrylist.size(); i++)
      {
          System.out.println("Print Elemnts One by One:--> " + arrylist.get(i));
      }
        
    }
    
}
