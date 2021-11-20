package lab_tasks.Fst_Mid_Preparation;
import java.util.Scanner;

public class Oned_Array_Scanner 
{
    public static void main(String args[])
    {
        int num;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter The Number Of Arrays: ");
        num = scan.nextInt();
        int a[] = new int[num];
        
        System.out.print("Enter" + num + "Elements to Array: \n" );
        
        for(int i = 0; i < num; i ++)
        {
            a[i] = scan.nextInt();
        }
        System.out.print("Elements in Array Are:\n");
        for(int i = 0; i < num; i++)
        {
            System.out.println(a[i] + " ");
            
        }
    }
    
}
