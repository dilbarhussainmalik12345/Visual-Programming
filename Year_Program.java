package DataStrucTure;
import static java.lang.System.out;
import java.util.Scanner;
public class Year_Program 
{
    private String month;
    private int day;
    private int year;
  
/*    public void monthString()
    {
        if(dateOk(monthString))
        {
            this.month = month;
            this.day = day;
            this.year = year;
        }
    }
    public void setDate(int monthInt , int day , int year)
    {
        if(dateOK(monthInt , day , year))
        {
            this.month = monthString (monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            out.println("Fatal Error");
            System.exit(0);
        }
        */
        public void setDate(String monthString ,int day , int year)
        {
            if(dateOK(monthString,day,year))
            {
                this.month = monthString;
                this.day = day;
                this.year = year;
            }
            else
            {
                out.println("Fatal Errrrrrror");
                System.exit(0);
            }
        }
        public void setDate(int year)
        {
            setDate("one",1,year);
        }
        
        private boolean dateOK(int monthInt,int dayInt,int yearInt)
        {
            return ((monthInt >= 1) && (monthInt <= 12) 
                    && (dayInt >= 1) && (dayInt <= 31) 
                    && (yearInt >= 1000) && (yearInt <= 9999));
        }
        private boolean dateOK(String monthString ,int dayInt,int yearInt)
        {
            return (monthOK(monthString ) && (dayInt >= 1) && (dayInt <= 31)
                    && (yearInt >= 1000) && (yearInt <= 9999));
        }
        private boolean monthOK(String month)
        {
            return (month.equals("Janurary") || month.equals("Feburary")||
                    month.equals("March") || month.equals("april") ||
                    month.equals("May") || month.equals("June") ||
                    month.equals("July") || month.equals("August") ||
                    month.equals("September") || month.equals("Octomber") ||
                    month.equals("November") || month.equals("December"));
        }
        public void readInput()
        {
            boolean tryagain = true;
            Scanner keyboard = new Scanner(System.in);
            
            while(tryagain)
            {
                out.println("Enter Month , Day , Year");
                out.println("Don't use Comma");
                
                String monthInput = keyboard.next();
                int dayInput = keyboard.nextInt();
                int yearInput = keyboard.nextInt();
                
                if(dateOK(monthInput,dayInput,yearInput))
                {
                    setDate(monthInput , dayInput, yearInput);
                    tryagain = false;
                }
                else
                {
                    out.println("Illegal date, day and year");
                }
            }
        }
         public static void main(String[] args)
        {
            Year_Program input = new Year_Program();
            input.readInput();
            input.dateOK("March", 2, 2);
            input.dateOK(2, 01, 02020);
            input.monthOK("January");
            
                    
            



        
        }
    }
    
    
   
    

