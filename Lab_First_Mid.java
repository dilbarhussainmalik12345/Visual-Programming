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
public class Lab_First_Mid <AnyType>
{  
  
    
    
  
    public int size;  
    
    Node head = null;  
    Node tail = null;  
  
    
    public void addNode(int data) {  
        
        Node newNode = new Node(data);  
  
        
        if(head == null) {  
           
            head = newNode;  
            tail = newNode;  
        }  
        else {  
            
            tail.next = newNode;  
            
            tail = newNode;  
        }  
        
        size++;  
    }  
  
      
    public void addInMid(int data){  
       
        Node newNode = new Node(data);  
  
        
        if(head == null) {  
           
            head = newNode;  
            tail = newNode;  
        }  
        else {  
            Node temp, current;  
           
            int count = (size % 2 == 0) ? (size/2) : ((size+1)/2);  
           
            temp = head;  
            current = null;  
  
           
            for(int i = 0; i < count; i++) {  
               
                current = temp;  
              
                temp = temp.next;  
            }  
  
           
            current.next = newNode;  
           
            newNode.next = temp;  
        }  
        size++;  
    }  
  
    
    public void display() {  
       
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
  
        while(current != null) {  
           
            System.out.println(current.data + " ");  
            current = current.next;  
        }  
        System.out.println();  
    }  
    
    
    class Node{  
        int data;  
        Node next;  
  
        public Node(int data) {  
            this.data = data;  
            this.next = null;  
        }  
    }  
  
    public static void main(String[] args) {  
  
        Lab_First_Mid<Integer> sList = new Lab_First_Mid<Integer>();  
  
        
        sList.addNode(2);  
        sList.addNode(4); 
        sList.addNode(6);
        sList.addNode(8);
        sList.addNode(10);
        sList.addNode(12);
  
        System.out.println("Original Singly Linked list:-->");  
        sList.display();  
  
        //Inserting node '3' in the middle  
        sList.addInMid(7);  
        System.out.println( "After Data Inserted at the middle og Linked List:-->");  
        sList.display();  
  
        
        sList.addInMid(77);  
        System.out.println("Again data Inserted in the middle of Linked List:-->");  
        sList.display(); 
        
        sList.addInMid(78);  
        System.out.println("Again data Inserted in the middle of Linked List:-->");  
        sList.display();  
    }  
}  
