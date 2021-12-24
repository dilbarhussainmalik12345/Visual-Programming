public class Insertion_Sort 
{
    
    public void Insertion_Sort(int a[])
    {
        int i, j, temp;
        int n = a.length;
        
        for(i = 0; i < n; i++)
        {
            temp = a[i];
            j = i-1;
            
            while(j >= 0 && temp <= a[j])
            {
                a[j+1] = a[j];
                j = j-1;
                
            }
                 a[j+1] = temp;
            }
    }
    
    public void PrintAll(int a[])
    {
        int i;
        int n = a.length;
        
        for(i = 0; i < n; i++)
        {
            System.out.println(":--> " + a[i]);
        }
    }
    
    public static void main(String[] args)
    {
        int a[] = {12, 1, 3, 78, 35, 45, 10, 2};
        
        Insertion_Sort sort = new Insertion_Sort();
        
        System.out.println("Elements Before Insertion Sort:--> ");
        sort.PrintAll(a);
        
        sort.Insertion_Sort(a);
        
        System.out.println("Elements After The Insertion Sort");
        sort.PrintAll(a);
        
        
    }
    
}
