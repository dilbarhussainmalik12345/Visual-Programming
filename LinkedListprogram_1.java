package lab_tasks;

import DataStructure.LinkedPractice;

public class LinkedListprogram_1 <AnyValue> 
{
    Node head;
    Node tail;
    
    public LinkedListprogram_1()
    {
        head = null;
        tail = null;
    }
    
    public void addLast(AnyValue data)
    {
        if(head == null)
        {
            head = new Node(data, null);
            tail = head;
        }
        else
        {
            tail.next = new Node(data , null);
            tail = tail.next;
        }
        
       
    }
    
   public void printAll(){

 Node temp = head;


 while (temp!=null) {
 System.out.println(temp.data);
 temp = temp.next;
 }
 // System.out.println("I'm at Out");

 }
     private class Node <AnyValue>
    {
        AnyValue data;
        Node next;
        
        Node(AnyValue data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    
    public static void main(String args[])
    {
        LinkedListprogram_1 <String> scan = new LinkedListprogram_1 <String>();
        
        scan.addLast("Ali");
        scan.addLast("Khan");
         scan.addLast("Ali");
        scan.addLast("Khan");
        scan.printAll();
       
    }
    
    
    
    
}
