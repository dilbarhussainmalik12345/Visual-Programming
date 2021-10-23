package lab_tasks;

public class NodesCounting 
{
    class Node
    {
        String data;
        Node next;
        
        Node(String data)
        {
            this.data = data;
            this.next = next;
        }
    }
    
    public Node head = null;
    public Node tail = null;
    
    public void addFirstt(String data)
    {
        Node node = new Node(data);
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            tail = node;
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
    
    public void display()
    {
        Node current = head;
        if(head == null)
        {
            System.out.println("List is empty");
            return;
        }
        
        System.out.println("Node of Linked List");
        while(current != null)
        {
            System.out.println(current.data + " ");
            current = current.next;
            
        }
        
        System.out.println();
    }
    
    public static void main(String args[])
    {
        NodesCounting nodes = new NodesCounting();
        nodes.addFirstt("Sir Muzamil Hussain");
        nodes.addFirstt("Sataj Ahmed");
        nodes.addFirstt("Amjad Ali");
        nodes.addFirstt("Suhail Ahmed");
        nodes.addFirstt("Dilbar Hussain");
        nodes.addFirstt("Ghulam Shah");
        nodes.addFirstt("Ali Khan");
        nodes.addFirstt("Sardar Ahmed");
        nodes.addFirstt("IBA University");
        nodes.addFirstt("Main Campus");
        nodes.addFirstt("Sukkur");
        nodes.addFirstt("IBA University");
        nodes.addFirstt("Main Campus");
        nodes.addFirstt("Sukkur");
        nodes.display();
        
        
        System.out.println("The Present Nodes in the Linked List are: " + nodes.CountNodes());
    }
    
    
}
