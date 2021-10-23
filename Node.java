package lab_tasks;

public class Node <Anydata> 
{
    Anydata data;
    Node next;
    
public void Node(Anydata data, Node next)
    {
        this.data = data;
        this.next = next;
    }
 public void printAll(){

 Node temp = next;


 while (temp!=null) {
 System.out.println(temp.data);
 temp = temp.next;
 }
 // System.out.println("I'm at Out");

 }
    
    public static void main(String args[])
    {
        Node scan = new Node();
        scan.printAll();
        
    }
}
