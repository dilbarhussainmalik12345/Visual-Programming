package lab_tasks;

public class DeleteNode <AnyType> 
{
    
    Node head;
    Node tail;
    
   public DeleteNode()
    {
        this.head = null;
        this.tail = null;
        
    }
    
    public void addFirst(AnyType data)
    {
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
    
    public void PrintAll()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
            
            
        }
        
        
    }
    
    public void addLast(AnyType data)
    {
        if(head == null)
        {
            addFirst(data);
        }
        else
        {
            tail.next = new Node(data, null);
            tail = tail.next;
        }
    }
    
    public void deleteNodes(AnyType data)
    {
        Node temp = head;
        
        if(temp.data == data)
        {
            temp = temp.next;
            head = temp;
            
            System.out.println("Success......we deleted Node" + data);
            
        }
        else
        {
            while(temp.next != null)
            {
                if(temp.next.data == data)
                {
                    temp.next = temp.next.next;
                    System.out.println("Success.. we have deletd Node" + data);
                    
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
    
   
    private class Node<AnyType>
    {
        AnyType data;
        Node next;

         Node (AnyType data, Node next)
         {

             this.data = data;
             this.next = next;

        }

    }
    
     public static void main(String args[])
    {
        
        DeleteNode<Integer> scan = new DeleteNode <Integer>();
        
        for(int i = 0; i <= 10; i++)
        {
            scan.addLast(i);
            
        }
        scan.PrintAll();
        scan.deleteNodes(5);
        
        System.out.println("\nLinked List after Deletion at position: " );
        
     
        scan.PrintAll();
        
        
    }
    
    
    }
    
    
    
    
   
   

