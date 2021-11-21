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
public class Queue_in_Array 
{
    int limit;
    int queueArr[];
    int first;
    int last;
    int size = 0;
    
    public Queue_in_Array(int queueSize)
    {
        this.limit = queueSize;
        first = 0;
        last = -1;
        queueArr = new int[this.limit];
        
    }
    
    public void enQueue(int data)
    {
        if(isFull())
        {
            System.out.println("\t\t\tQueue is Full! Can't add more ");
        }
        else
        {
            last++;
            if(last == limit-1)
            {
                last = 0;
            }
            queueArr [last] = data;
            size++;
            System.out.println("\t\t\tAdded to the Queue " + data);
        }
        
    }
    
    public void deQueue()
    {
        if(isEmpty())
        {
            System.out.println("\t\t\tQueue is Empty! Can't dequeu ");
            
        }
        else
        {
            first++;
            if(first == limit-1)
            {
                System.out.println("\t\t\tRemoved From the Queue " + queueArr[first-1]);
                first = 0;
            }
            else
            {
                System.out.println("\t\t\tRemoved From the Queue " + queueArr[first-1]);
            }
            size--;
        }
    }
    
   
    public boolean isFull()
    {
        if(size == limit)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
    
    public static void main(String args[])
    {
      Queue_in_Array queue = new Queue_in_Array(5);
      
      queue.enQueue(1);
      queue.enQueue(2);
      queue.enQueue(3);
      queue.enQueue(4);
      queue.enQueue(5);
      
      System.out.println();
      System.out.println("\t\t\tFollowing data is Dequeued from the Give data\n");
      
      queue.deQueue();
      queue.deQueue();
      queue.deQueue();
       
        
        
    }
    
}
