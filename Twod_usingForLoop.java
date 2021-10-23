public class Twod_usingForLoop 
{
    
    public static void main(String args[])
    {
        int[][] a = {{2,4,6,8,10},{12,14,16,18,20}};
        
        System.out.println("Two Dimensional Array Elements Through ForLoop");
        
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                System.out.println(a[i][j]);
            }
        }
    }
    
}
