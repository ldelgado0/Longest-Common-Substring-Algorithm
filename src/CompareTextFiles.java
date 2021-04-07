import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CompareTextFiles
{
   
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> file1Lines = new ArrayList<String>(); 
        ArrayList<String> file2Lines = new ArrayList<String>(); 

        BufferedReader file1 = new BufferedReader(new FileReader("one.txt"));
        BufferedReader file2 = new BufferedReader(new FileReader("two.txt"));
        try
        {
            String line = file1.readLine(); 
            String line2 = file2.readLine(); 

            while(line != null)
            {
                file1Lines.add(line); 
                line = file1.readLine(); 
            }

            while(line2 != null)
            {
                file2Lines.add(line2); 
                line2 = file2.readLine();
            }
        }
        finally
        {
            file1.close();
            file2.close(); 
        }

        HashSet<String> set = new HashSet<String>();
 
        for (int i = 0; i < file1Lines.size(); i++)
        {
            for (int j = 0; j < file2Lines.size(); j++)
            {
                if(file1Lines.get(i).equals(file2Lines.get(j)))
                {
                    set.add(file1Lines.get(i));
                }
            }
        }
        System.out.println("The # of common lines: " + set.size());
        System.out.println("The common lines are");
        System.out.println(set);   
        System.out.println("\n");

        System.out.println("Feedback for 1st file"); 
        System.out.println(file1Lines.toString() + " is:"); 
        for(int m = 0; m < file1Lines.size(); m++)
        {
            if(set.contains(file1Lines.get(m)))
            {
                System.out.println(file1Lines.get(m) + " is in both files"); 
            }
            else
            {
                System.out.println(file1Lines.get(m) + " is only in this file");
            }
        }

        System.out.println("\n");
        System.out.println("Feedback for 2nd file"); 
        System.out.println(file2Lines.toString() + " is:"); 
        for(int n = 0; n < file2Lines.size(); n++)
        {
            if(set.contains(file2Lines.get(n)))
            {
                System.out.println(file2Lines.get(n) + " is in both files"); 
            }
            else
            {
                System.out.println(file2Lines.get(n) + " is only in this file");
            }
        }

    }
}