
import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.util.Scanner;
public class Project_123
{
    public static void main(String args[]) throws FileNotFoundException, IOException {
        System.out.println("Please select one of the below operations");
        System.out.println(" w for write mode ");
        System.out.println(" r for read mode ");
        System.out.println(" a for append mode ");
        Scanner in =new Scanner(System.in);
        String s=in.nextLine();
        if(s.equalsIgnoreCase("r"))
        {
            new FReading();
        }
        else if(s.equalsIgnoreCase("w")||s.equalsIgnoreCase("a"))
        {
            writingToFile(s);
            
            
        }
        else
        {
            System.out.println("Sorry you try to do unexpected ,betterluck next time ");
        }
        
        
        in.close();
        
    }
    
    public static void writingToFile(String s)
    {
        Scanner in=null;
        try
        {
            String source;
            File f=new File("file1.txt");
            
            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
            //For writing new Content Everytime you run
            FileWriter f0 =null;
            if(s.equalsIgnoreCase("w"))
            {
                f0 = new FileWriter(f,false);
                System.out.println("CAUTION >> Please understand it will overwrite the content of the file ");
                System.out.println("Type 'no' to exit");
                System.out.println("Do you want to proceed :type 'yes' ");
                
                           
          class Male_Faculty3
{
    private String MF_firstname;
    private String MF_lastname;
    private int MF_gradeYear;
    private String MF_teacherID;
    private String MF_courses = "";
    private int MF_salary = 0;
    private  int MF_costofSubject = 2500;
    private  int MF_id = 1000;
    
    public Male_Faculty3()
    {
        Scanner scan = new Scanner(System.in);
        
        out.print("Enter First Name: ");
        this.MF_firstname = scan.nextLine();
        
        out.print("Enter Last Name: ");
        this.MF_lastname = scan.nextLine();
        
        out.println("Please Enetr any one option that which faculty member belongs:- "
                + "\n1-For Freshmen\n 2-For-Senior\n 3-For Junior");
        this.MF_gradeYear = scan.nextInt();
        setMF_TeacherID();
        out.println("Teacher ID: " + MF_teacherID);
    }
    private void setMF_TeacherID()
    {
        MF_id++;
        this.MF_teacherID = MF_gradeYear + "" + MF_id;
    }
    public void tech()
    {
        do
        {
            out.println("Enetr Courses that you teach:"
                    + "\n Q to Quit.");
            Scanner scan = new Scanner(System.in);
            String course = scan.nextLine();
            if(!course.equals("Q"))
            {
                MF_courses = MF_courses + "\n" + course;
                MF_salary = MF_salary + MF_costofSubject;
            }
            else
            {
                break;
            }
            
        }
        while(1 != 0);
            out.println("Subjects teach: " + MF_courses);
            out.println("Tutior balance: " + MF_salary);
            
    }
    public void viewSalary()
    {
        out.println("Your Salary is:- " + MF_salary);
    }
    
    public void payTuitor()
    {
        viewSalary();
        out.println("Enter Your amount to transist: $");
        Scanner scan = new Scanner(System.in);
        int pyment = scan.nextInt();
        MF_salary = MF_salary - pyment;
        out.println("Thank You For Your pyment transist: $" + pyment);
        viewSalary();
    }
    public String toString()
    {
        return "Name: " + MF_firstname + " " + MF_lastname+
                "\n Grade level: " + MF_gradeYear +
                "\nTeacher ID: " + MF_teacherID +
                "\nCourses Tech: " + MF_courses +
                "\nSalary: " + MF_salary;
                
                
    }
    

    
}

                System.out.println("Write 'stop' when you finish writing file ");
                f.delete();
                f.createNewFile();
                while(!(source=bf.readLine()).equalsIgnoreCase("stop")){
                    f0.write(source + System.getProperty("line.separator"));
                    
                }
                
                in.close();
            }
            //For appending the content
            else
            {  f0 = new FileWriter(f,true);
                System.out.println("Write 'stop' when you finish appending file ");
                while(!(source=bf.readLine()).equalsIgnoreCase("stop")){
                    f0.append(source+ System.getProperty("line.separator"));
                }
            }
            f0.close();
            
        }
        catch(Exception e){
            System.out.println("Error : " );
            e.printStackTrace();
        }
        
        
    }
    
    
    
}

class FReading {
    public static String str="";
    
    public FReading() {
        
        try{
            File f5=new File("file1.txt");
            if(! f5.exists())
            f5.createNewFile();
            FileReader fl=new FileReader(f5);
            BufferedReader bf=new BufferedReader(fl);
            //For reading till end
            while((str=bf.readLine())!=null){
                System.out.println(str);
            }
            fl.close();
            }catch(IOException e){
            System.out.println("Error : " );
        }
    }
}
