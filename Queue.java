/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_tasks;

/**
 *
 * @author Agha Dilbar Husssain
 */
public class Queue <AnyType>
{
    Node head;
    Node tail;
    
    public Queue()
    {
        this.head = null;
        this.tail = tail;
    }
    
    public void enQueue(AnyType data)
    {
        
       if(head == null)
        {
            head = new Node(data, null);
           tail = head;
            
        }
        else
        {
            Node temp = new Node(data, null);
            tail.next = temp;
            tail = temp;
            
        }
    }
    
    public AnyType deQueue()
    {
        AnyType data = null;
       if(head == null)
       {
           System.out.println("Stack is NUll");
           return null;
       }
       else
       {
         data = (AnyType)head.data;
         
        head = head.next;
       }
       
       return data;
    }
    
    public void PrintAll()
    {
        if(head != null)
        {
            Node temp = head;
            while(temp != null)
            {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
        else
        {
            System.out.println("List is Empty");
        }
    }
    
    
    
    private class Node <AnyType>
    {
        AnyType data;
        Node next;
        
        Node(AnyType data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    
    public static void main(String args[])
    {
        Queue<Integer> scan = new Queue<Integer>();
        scan.enQueue(1);
        scan.enQueue(2);
        scan.enQueue(3);
        scan.enQueue(4);
        scan.enQueue(5);
        scan.enQueue(6);
        
        scan.PrintAll();
        
        System.out.println("Remove: " + scan.deQueue());
        System.out.println("Remove: " + scan.deQueue());
        System.out.println("Remove: " + scan.deQueue());
        
        scan.PrintAll();
        
    }
}
