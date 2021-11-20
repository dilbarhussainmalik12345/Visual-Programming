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
public class Stack <AnyType> 
{
    Node head;
    Node tail;
    
    public Stack()
    {
        this.head = null;
        this.tail = null;
    }
    
    public void Push(AnyType data)
    {
       Node newNode = new Node(data,head);
       head = newNode;
       
       
    }
    
    public AnyType Pop()
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
    
    
    public int Length()
    {
        int count = 0;
        Node current = head;
        
        while(current != null)
        {
            count++;
            current = current.next;
        }
        return count;
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
    
    
    public boolean isEmpty()
    {
        if(head == null)
        {
            return false;
        }
        return true;
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
        Stack<Integer> scan = new Stack<Integer>();
        
        scan.Push(1);
        scan.Push(2);
        scan.Push(3);
        scan.Push(4);
        scan.Push(5);
        
        scan.PrintAll();
        
        System.out.println(" Remove:- " + scan.Pop());
        System.out.println(" Remove:- " + scan.Pop());
        System.out.println(" Remove:- " +scan.Pop());
       
       //scan.PrintAll();
       
        System.out.println(scan.isEmpty());
        
        System.out.println("Total Nodes are:---> " + scan.Length());
        
    }
    
}
