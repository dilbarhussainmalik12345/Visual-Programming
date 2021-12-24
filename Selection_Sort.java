public class Selection_Sort 
{
    public void Selection_Sort(int a[])
    {
        int i, j, temp, small;
        int n = a.length;
        
        for(i = 0; i < n-1; i++)
        {
            small = i; // minimum elemnet is sorted
            for(j = i+1; j < n; j++)
            if(a[j] < a[small])
                
                    small = j;
                    // swipe the minimuum element
                    temp = a[small];
                    a[small] = a[i];
                    a[i] = temp;
                
            
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
        int a[] = {140, 80, 70, 30, 10, 50, 20, 90, 100};
        
        Selection_Sort sort = new Selection_Sort();
        System.out.println("Before the Selection Sort");
        sort.PrintAll(a);
        sort.Selection_Sort(a);
        
        System.out.println("After Selection Sort");
        sort.PrintAll(a);
        
    }
}
