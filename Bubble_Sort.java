public class Bubble_Sort 
{
    public void Bubble_Sort(int a[])
    {
        int i, j, temp;
        int n = a.length;
        
        for(i = 0; i < n; i++)
        {
            for(j = i+1; j < n; j++)
            {
                if(a[j] < a[i])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                
            }
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
        int a[] = {100, 90,70,40,10,60,80,30,20};
        
        Bubble_Sort sort = new Bubble_Sort();
        
        System.out.println("Elemnets Before The Bubble Sorting:--> ");
        sort.PrintAll(a);
        
        sort.Bubble_Sort(a);
        
        System.out.println("Elements After The Bubble Sorting:--> ");
        sort.PrintAll(a);
    }
}
