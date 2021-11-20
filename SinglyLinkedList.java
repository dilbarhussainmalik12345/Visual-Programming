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
public class SinglyLinkedList <AnyType> 
{
    
    AnyType data;
    Node head;
    Node tail;
    
    public SinglyLinkedList()
    {
        this.head = null;
        this.tail = null;
    }
    
    public void AddFirst(AnyType data)
    {
        if(head == null)
        {
            head = new Node(data,null);
            tail = head;
        }
        else
        {
            Node temp = new Node(data,head);
            head = temp;
        }
        
    }
    
    public void AddLast(AnyType data)
    {
        if(head == null)
        {
            AddFirst(data);
        }
        else
        {
            tail.next = new Node(data,null);
            tail = tail.next;
        }
    }
    
    public void DeleteNode(AnyType data)
    {
        Node temp = head;
        if(temp.data == data)
        {
            temp = temp.next;
            head = temp;
            System.out.println("Success We have deleted Node " + data);
        }
        else
        {
            while(temp.next != null)
            {
                if(temp.next.data == data)
                {
                    temp.next = temp.next.next;
                    System.out.println("Success We have delted Node " + data);
                    break;
                }
                else
                {
                    temp = temp.next;
                    if(temp.next == null)
                    {
                        System.out.println("there is nO any Node");
                    }
                }
            }
        }
    }
    
    public int CountNodes()
    {
        int count = 0;
        Node current = head;
        if(current != null)
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
    
    public void AddAt(int pos, AnyType data)
    {
        if(pos <= CountNodes()+1)
        {
            Node temp = head;
            int count = 1;
            
            if(count == pos)
            {
                Node newNode = new Node(data,temp);
                head = newNode;
            }
            else
            {
                while(temp != null)
                {
                    System.out.println("Count " + count);
                    if(count+1 == pos)
                    {
                        Node newNode = new Node(data,temp.next);
                        temp.next = newNode;
                        System.out.println("Working");
                        break;
                    }
                    count++;
                    temp = temp.next;
                }
                System.out.println("Can't be added " + pos + "Length is incompatible");
            }
            
        }
        else
        {
            System.out.println("Can't be added " + pos + "Length is incompatible");
        }
    }
    
    public void Merged_List(SinglyLinkedList list)
    {
        if(list.head == null)
        {
            tail.next = list.head;
            System.out.println("Merged Successfully");
        }
        else
        {
            System.out.println("List Doesn't Contain Node");
        }
    }
    
    public void circular()
    {
        if(head != null)
        {
            System.out.println("Found");
        }
        else
        {
            tail.next = head;
            System.out.println("There is no Any Circular list");
        }
        
    }
    
    public void iSCircular()
    {
        if(head != null)
        {
            System.out.println("List is circular");
        }
        else
        {
            while(head == null)
            {
                tail.next = head;
                System.out.println("List is not circular");
                break;
            }
        }
        
    }
    
    
    public void printAllNodes()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    
    
    
    
    private class Node<AnyType>
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
        SinglyLinkedList<String> scan = new SinglyLinkedList<String>();
        SinglyLinkedList<String> scan2 = new SinglyLinkedList<String>();
        
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
       
        scan.printAllNodes();
        //scan.addFIRST(1);
      //  scan.AddLAST(11);
//        scan.CountNodes();
        scan.AddLast("Syed Baba");
        scan.AddLast("Dilbar");
        scan.AddLast("Amjad");
        scan.AddLast("Suhail");
        scan.AddLast("Sartaj");
        scan.AddLast("Soraj");
        
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
       
        scan.circular();
        scan.printAllNodes();
        System.out.println();
        
        scan.iSCircular();
       // scan.SearchNode(4);
      scan.printAllNodes();
         
        
    }
    
}
