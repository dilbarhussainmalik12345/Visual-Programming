public class Merge_Sort 
{
    //Function to Merge the subarrays of a[]
    public void merge(int a[], int beg, int mid, int end)
    {
        int i, j, k;
        int n1 = mid-beg + 1;
        int n2 = end-mid;
        
        //Temporary Arrays
        int LeftArray[] = new int[n1];
        int RightArray[] = new int[n2];
        
        // Copy data to temp Arrays
        for(i = 0; i < n1; i++)
            LeftArray[i] = a[beg + i]; 
        
        for(j = 0; j < n2; j++)
            RightArray[j] = a[mid + 1 + j];
        
        i = 0;
        j = 0;
        k = beg; // Merge array intial index 
        
        while(i < n1 && j < n2)
        {
            if(LeftArray[i] <= RightArray[j])
            {
                a[k] = LeftArray[i];
                i++;
            }
            else
            {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            a[k] = LeftArray[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }
    
    public void merge_Sort(int a[], int beg, int end)
    {
        if(beg < end)
        {
            int mid = (beg + end)/2;
            merge_Sort(a, beg,mid);
            merge_Sort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }
    
    public void print(int a[], int n)
    {
        int i;
        for(i = 0; i < n; i++)
           System.out.println(a[i] + " ");
        
    }
    
    
    public static void main(String args[])
    {
        int a[] = {11, 3, 10, 6, 2, 7, 9, 4, 1, 8, 5};
        int n = a.length;
        
        Merge_Sort merge = new Merge_Sort();
        
        System.out.println("Elements Before the Sorting:---> ");
        merge.print(a, n);
        merge.merge_Sort(a, 0, n-1);
        System.out.println("Elements After the Sorting:---> ");
        merge.print(a, n);
        
    }
    
}

   