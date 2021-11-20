/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_tasks.Fst_Mid_Preparation;

/**
 *
 * @author Agha Dilbar Husssain
 */
public class DoublyLinkedList <AnyType> 
{
    AnyType data;
    Node head;
    Node tail;
    
    public DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
    }
    
     public void Add_First(AnyType data)
    {
        if(head == null)
        {
            head = new Node(data,null,null);
        }
        else
        {
            Node temp = new Node(data,head,null);
            head.prev = temp;
            head = temp;
        }
        
    }
    public void Add_Last(AnyType data)
    {
        if(head == null)
        {
            head = new Node(data,null,null);
            tail = head;
        }
        else
        {
            tail.next = new Node(data,null,tail);
            tail = tail.next;
        }
    }
    
    public void Search(AnyType data)
    {
        if(head == null)
        {
            System.out.println("There is No Any Node");
        }
        else
        {
            Node temp = head;
            while(temp != null)
            {
                int count = 1;
                if(temp.data == data)
                {
                    count++;
                    System.out.println("Success We Find data:---> "+ data);
                    break;
                }
                else
                {
                    temp = temp.next;
                    count++;
                }
                if(temp == null)
                {
                    count = -1;
                    System.out.println("No Node is here:---> " + count);
                }
            }
        }
    }
    
    public void DeleteNode(AnyType data)
    {
        Node temp = head;
        if(head != null)
        {
            if(temp.data == data)
            {
                temp = temp.next;
                head = temp;
                head.prev = null;
                System.out.println("SuccessFully We have deleted Node:---> " + data);
            }
            else
            {
                temp = head;
                while(temp != null)
                {
                    if(temp.data == data)
                    {
                        temp.prev.next = temp.next;
                        if(temp.next != null)
                        {
                            temp.next.prev = temp.prev;
                        }
                        System.out.println("Success Node Delted:---> " + data);
                        break;
                    }
                    else
                    {
                        temp = temp.next;
                        if(temp == null)
                        {
                            System.out.println("Node Not Found");
                        }
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
            System.out.println();
        }
        
        return count;
    }
    
    public void Merge_Last(DoublyLinkedList list)
    {
        if(head == null)
        {
            head = list.head;
        }
        else
        {
            tail.next = list.head;
            list.head.prev = tail;
            tail = list.tail;
            System.out.println("SuccessFully We have Merged the List in Last");
            
        }
    }
    
    public void Merge_first(DoublyLinkedList list)
    {
        if(head == null)
        {
            head = list.head;
            tail = list.tail;
        }
        else
        {
            head.prev = list.tail;
            list.tail.next = head;
            head = list.head;
            System.out.println("Success We have Merged list in First");
        }
    }
    
    public void AddAt(int pos, AnyType data)
    {
        if(pos <= CountNodes()+1)
        {
            Node temp = head;
            int count = 1;
            if(count == pos)
            {
                Node a = new Node(data,temp,null);
                head = a;
                System.out.println("Working\n");
            }
            else
            {
                while(temp != null)
                {
                    if(count+1 == pos)
                    {
                        Node a = new Node(data,temp.next,null);
                        temp.next = a;
                        System.out.println("Working\n");
                        break;
                    }
                    count++;
                    temp = temp.next;
                }
                
            }
        }
        else
        {
            System.out.println("Can Not Add " + pos + "length is incompatible");
        }
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
        Node prev;
        
        Node(AnyType data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
     
     public static void main(String args[])
     {
        DoublyLinkedList<Integer> scan = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> scan2 = new DoublyLinkedList<Integer>();
        
         scan.Add_First(1);
//        scan.Add_First(2);
//        scan.Add_First(3);
//        scan.Add_First(4);
//        scan.Add_First(5);
//        
//        scan.PrintAll();
        
        scan.Add_Last(1);
        scan.Add_Last(2);
        scan.Add_Last(3);
        scan.Add_Last(4);
        scan.Add_Last(5);
        
        scan2.Add_Last(6);
        scan2.Add_Last(7);
        scan2.Add_Last(8);
        scan2.Add_Last(9);
        scan2.Add_Last(10);
        
        scan.PrintAll();
        
        scan.Search(10);
        scan.PrintAll();
        
        scan.DeleteNode(6);
        scan.PrintAll();
        
        System.out.println("Nodes:---> " + scan.CountNodes());
        scan.PrintAll(); 
        
//        scan.Merge_Last(scan2);
//        scan.PrintAll();

//        scan.Merge_first(scan2);
//        scan.PrintAll();

       scan.AddAt(5, 6);
       scan.PrintAll();
         
     }
     
}
