package lab_tasks;

public class LinkedList_position <AnyType> 
{
    Node head;
    Node tail;
 public LinkedList_position(){

 this.head = null;
 this.tail = null;
 }


 public void addFirst(AnyType data){

 if(head==null){
 head = new Node(data, null);
 tail = head;}
 else {

 Node temp = new Node(data, head);
 head = temp;


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
 public void addLast(AnyType data){

 if (head==null){
 addFirst(data);



 }
 else{

 tail.next = new Node(data, null);
 tail = tail.next;



 }


 }


 public void deleteNode(AnyType data){

 Node temp = head;

 if (temp.data == data){
  
 temp = temp.next;
 head =temp;
 System.out.println("Success ... we Delected Node "+data);
 }

 else {
 temp = head;
  
 
 while(temp.next !=null){

 if(temp.next.data == data){

 temp.next = temp.next.next;
 System.out.println("Success ... we Delected Node"+data);

 break;

 }

 else
 { temp = temp.next;
 if (temp.next == null){
 System.out.println("Node Not Found :");
 }
 }

 }


 

 }


 }
 
 public void search(AnyType data)
 
 {
     int count = -1;
     Node current = head;
     if(current.data == data)
     {
         current = current.next;
         head = current;
         System.out.print("Find Data" + data);
     }
     
     else
     {
         current = head;
         while(current.next != null)
         {
             if(current.next.data == data)
             {
                 current.next = current.next.next;
                 System.out.println("Success Node:-----> " + data);
                 break;
             }
             else
             {
                 current = current.next;
                 if(current.next == null)
                 {
                     System.out.println("Not Found Data:-----> "+ count);
                 }
             }
         }
     }
     
 }
 
 

 private class Node <AnyType>{

 AnyType data;
 Node next;

 Node (AnyType data, Node next){

 this.data = data;
 this.next = next;

 }

}


 public static void main(String args[]){


 LinkedList_position ls = new LinkedList_position();

// ls.addLast("Hello world!!!");

// 

ls.addFirst(1);
ls.addFirst(2);
ls.addFirst(3);
ls.addFirst(4);
ls.addFirst(5);



 //ls.printAll();
 
ls.search(2);
 
 
//ls.deleteNode(2);
//
////ls.Counter_Position(2);
//
//
// ls.printAll();

 }

    
}
