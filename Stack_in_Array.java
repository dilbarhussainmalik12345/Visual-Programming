/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_tasks;

import java.util.Scanner;

/**
 *
 * @author Agha Dilbar Husssain
 */
public class Stack_in_Array 
{
    int value;
    int limit = 10;
   int[] array = new int[limit];
   int index;
   
  
   
   
    public boolean push(Scanner scan1)
    {
        if(value == limit-1)
        {
            System.out.println("OverFlow");
            return false;
            
        }
        else
        {
            System.out.println("Enter value");
           int val = scan1.nextInt();
            
            if(index == 0)
            {
                array[index] = val;
                index++;
            }
            else
                {
                        index++;
                        array[index] = val;
                }
            System.out.println("Item Pushed");
            return true;
        }
        
    }
    
    public int pop()
    {
        if(index == -1)
        {
            System.out.println("UnderFlow");
            return -1;
        }
        else
        {
            int temp = array[index];
            index--;
            System.out.println("Item Popped");
            return temp;
            
        }
    }

    
    public static void main(String args[])
    {
       Scanner scan1 = new Scanner(System.in);
       Stack_in_Array stack = new Stack_in_Array();
       
      stack.push(scan1);
      stack.push(scan1);
      stack.push(scan1);
      stack.push(scan1);
       
       //stack.dispaly();
       
     
      
      System.out.println( stack.pop());
        
    }
    
}
