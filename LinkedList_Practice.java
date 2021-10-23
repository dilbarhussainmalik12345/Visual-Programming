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
public class LinkedList_Practice <AnyType> 
{
    Node head;
    Node tail;
    
    public LinkedList_Practice()
    {
        this.head = null;
        this.tail = null;
        
        
    }
    
    public void addFIRST(AnyType data)
    {
        // This function will add Node at the Fisrt
        
        if(head == null)
        {
            head = new Node(data, null);
            tail = head;
        }
        else
        {
            Node temp = new Node(data, head);
            head = temp;
        }
        
    }
    
    public void AddLAST(AnyType data)
    {
        //This Node adds Node At the Last of Linked List
        
        if(head == null)
        {
            addFIRST(data);
        }
        else
        {
            tail.next = new Node(data, null);
            tail = tail.next;
            
        }
        
    }
    
    public void DeleteNode(AnyType data)
    {
        //This Function will delete Node From the List
        
        Node temp = head;
        if(temp.data == data)
        {
            temp = temp.next;
            head = temp;
            System.out.println("Success We Have Delted Node " + data);
        }
        else
        {
            while(temp.next != null)
            {
                if(temp.next.data == data)
                {
                    temp.next = temp.next.next;
                    System.out.println("Success We Have Delted Node " + data);
                    break;
                }
                else
                {
                    temp = temp.next;
                    if(temp.next == null)
                    {
                        System.out.println("Node Not Found");
                    }
                }
            }
        }
        
    }
    
    public int CountNodes()
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
    
    public int SearchNode(AnyType data)
    {
        if(head == null)
            return -1;
        
        Node temp = head;
        
        int count = -1;
        while(temp != null)
        {
            if(temp.data == data)
            {
                count++;
                return count;
                
            }
            else
            {
                count++;
                temp = temp.next;
            }
            
        }
        
        return -1;
        
    }
    
    public void AddAt(int position,AnyType data)
    {
        if(position <= CountNodes()+1)
        {
            Node temp = head;
            int count = 1;
            if(count == position)
            {
                Node newNode = new Node(data, temp);
                head = newNode;
                
            }
            else
            {
                while(temp != null)
                {
                    System.out.print("Count " + count);
                    if(count+1 == position)
                    {
                        Node newNode = new Node(data, temp.next);
                        temp.next = newNode;
                        System.out.println("This is Working");
                        break;
                    }
                    count++;
                    temp = temp.next;
                    
                }
                System.out.println("Can't be Added: " + position + " Because Length of list nit Campatible");
            }
        }
        
        else
        {
            System.out.println("Can't be Added: " + position + " Because Length of list nit Campatible");
        }
    }
    
    public void MergeLists(LinkedList_Practice list)
    {
        if(list.head != null)
        {
            tail.next = list.head;
            System.out.println("Merged Successfully");
        }
        else
        {
            System.out.println("Lists Does't contain any Node");
        }
    }
    
    
    public void Circular()
    {
        if(head != null)
        {
            tail.next =head;
            System.out.println("Found");
        }
        else
        {
            
                
                System.out.println("There is No Circular List");
            
        }
    }
    
   
    
    public void PrintAllNode()
    {
        //this Function will print alll node
        
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
        
    }
    
    
    private class Node <Anytype>
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
        LinkedList_Practice<String> scan = new LinkedList_Practice<String>();
        LinkedList_Practice<String> scan2 = new LinkedList_Practice<String>();
        
//       for(int i = 1; i <= 10; i++)
//       {
//           scan.AddLAST(i);
//       }
        


//scan.addFIRST(1);
//scan.addFIRST(2);
//scan.addFIRST(3);
//scan.addFIRST(4);
//scan.addFIRST(5);
//scan.addFIRST(6);
       
        scan.PrintAllNode();
        //scan.addFIRST(1);
      //  scan.AddLAST(11);
//        scan.CountNodes();
        scan.AddLAST("Syed Baba");
        scan.AddLAST("Dilbar");
        scan.AddLAST("Amjad");
        scan.AddLAST("Suhail");
        scan.AddLAST("Sartaj");
        scan.AddLAST("Soraj");
        
//        scan2.AddLAST("Sain Muzamil Shah");
//        scan2.AddLAST("Dilbar Hussain");
//        scan2.AddLAST("Amjad Saeed");
//        scan2.AddLAST("Suhail malik");
//        scan2.AddLAST("Sartaj Khan");
//        scan2.AddLAST("Soraj Kumar");
        
//        System.out.println();
//       //scan.DeleteNode("Soraj");
//        scan.PrintAllNode();
//        
//        System.out.println();
//        //scan.AddAt(3, "Yow Wrking");
//        //scan.AddAt(3, 5);
//        //System.out.println("Count of nodes present in the list: " + scan.CountNodes()); 
//        scan.PrintAllNode();
//        scan2.PrintAllNode();
//        
//        scan.MergeLists(scan2);
//        scan.PrintAllNode();
       
scan.Circular();
        
       // scan.SearchNode(4);
       //scan.PrintAllNode();
        
    }
}
