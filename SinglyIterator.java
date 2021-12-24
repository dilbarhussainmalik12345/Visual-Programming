
public interface Iterate_Singly <AnyType>
{
    public boolean hasNext();
    public AnyType getData();
    
}

public class SinglyIterator<AnyType> 
{
    Node head;
    Node tail;
    
    public void SinglyIterator()
    {
        this.head = null;
        this.tail = null;
    }
    
    public void addFST(AnyType data)
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
    
     public void printAll()
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
    
    private class Iterate<AnyType> implements Iterate_Singly
    {
        Node temp = null;
        
        Iterate(Node head)
        {
            temp = head;
        }
        
        @Override
        public AnyType getData()
        {
            if(temp == null)
               {
                   return null;
               }
            
            AnyType data =(AnyType) temp.data;
        
            return data;
        
        }

        @Override
        public boolean hasNext() 
        {
             if(temp != null)
            {
                temp = temp.next;
                return true;
            }
            return false;
            
        }
    }
    
    public Iterate getiterator()
    {
        Iterate inter = new Iterate(this.head);
        return inter;
    }
    
    public static void main(String[] args)
    {
        SinglyIterator<Integer> iterate = new SinglyIterator<Integer>();
        
        iterate.addFST(100);
        iterate.addFST(22);
        iterate.addFST(35);
        iterate.addFST(2);
        iterate.addFST(22);
        iterate.addFST(72);
        iterate.addFST(62);
        iterate.addFST(93);
        iterate.addFST(11);
        iterate.addFST(40);
        
        Iterate_Singly singly = iterate.getiterator();
        int i = 0;
        
        while(singly.hasNext())
        {
            System.out.println("Data:--> " + singly.getData());
        }
        
        System.out.println("Before Iterator ");
        iterate.printAll();
    }
    
}
