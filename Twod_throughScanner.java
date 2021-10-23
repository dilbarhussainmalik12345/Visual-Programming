
import java.util.Scanner;

public class Twod_throughScanner 
{
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter The Row Length Of An Array: ");
        int row = scan.nextInt();
        
        System.out.println("Enter The Column Lenght Of An Array: ");
        int column = scan.nextInt();
        
        int a[][] = new int[row][column];
        System.out.println("Enter " + row*column + " Elements to Store Array: ");
        
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < column; j++)
            {
                a[i][j] = scan.nextInt();
            }
        }
         System.out.println("Elements in Array Are: ");
         
         for(int i = 0; i < row; i++)
         {
             for(int j = 0; j < column; j++)
             {
                    System.out.println("Row [" + i + "] : Column[" + j + "] :" + a[i][j]);
             }
         }
        
    }
    
}
