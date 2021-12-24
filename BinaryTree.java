public class BinaryTree <AnyType> 
{
    Node root, right, left;
    
    public BinaryTree()
    {
        this.root = null;
        this.right = null;
        this.left = null;
        
    }
    
    public void add_root(AnyType data)
    {
        root = new Node(data, null,null);
        
    }
    
    public void add_Right(AnyType data)
    {
        if(root == null)
        {
            root = new Node(data, null, null);
            System.out.println("Success We have Added Node to The Right Side:--> " + data);
        }
        else
        {
            Node temp = new Node(data, root, null);
            root.left= temp;
            root = temp;
            System.out.println("Success We have Added Node tp The Right Side:-->" + data);
        }
    }
    
    public void add_Left(AnyType data)
    {
        if(root == null)
        {
            root = new Node(data, null, null);
            System.out.println("Success Node Added to the Left Side:-->" + data);
        }
        else
        {
            root.left = new Node(data, null, left);
            left = root.left;
            System.out.println("Success Node Added to The Left Side:-->" + data);
        }
    }
    
    private class Node<AnyTYpe>
    {
        AnyType data;
        Node right,left;
        
        Node(AnyType data, Node right, Node left)
        {
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }
    
    public static void main(String[] args)
    {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        
        tree.add_Right(1);
        tree.add_Left(3);
        tree.add_Right(2);
        tree.add_Left(4);
        tree.add_Right(5);
    }
    
}
