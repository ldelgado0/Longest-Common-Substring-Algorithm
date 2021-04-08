//Partners: Alexandra Fernandez & Daniela Delgado
//Running time of LongestCommonSubfile() = O(n * m) where n and m are the size of two respective arraylists 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DnaAlgo
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

            while (line != null)
            {
                file1Lines.add(line);
                line = file1.readLine();
            }

            while (line2 != null)
            {
                file2Lines.add(line2);
                line2 = file2.readLine();
            }
        } finally
        {
            file1.close();
            file2.close();
        }

        int file1Size = file1Lines.size();
        int file2Size = file2Lines.size();

        ArrayList<String> commonLines = largestCommonSubfile(file1Lines, file2Lines, file1Size, file2Size);

        System.out.println("The common lines are");
        System.out.println(commonLines.toString());
        System.out.println("\n");

        System.out.println("Feedback for 1st file");
        System.out.println(file1Lines.toString() + " is:");
        int newFile1Size = file1Lines.size();
        for(int a = 0; a < newFile1Size; a++)
        {
            if(commonLines.contains(file1Lines.get(a)))
            {
                System.out.println(file1Lines.get(a) + " is in both files");
            }
            else
            {
                System.out.println(file1Lines.get(a) + " is only in this file");
            }
        }

        System.out.println("\n");
        System.out.println("Feedback for 2nd file");
        System.out.println(file2Lines.toString() + " is:");
        int newFile2Size = file2Lines.size();
        for(int b = 0; b < newFile2Size; b++)
        {
            if(commonLines.contains(file2Lines.get(b)))
            {
                System.out.println(file2Lines.get(b) + " is in both files");
            }
            else
            {
                System.out.println(file2Lines.get(b) + " is only in this file");
            }
        }

    }

    public static ArrayList<String> largestCommonSubfile(ArrayList<String> file1Lines, ArrayList<String> file2Lines, int file1Size, int file2Size)
    {

        ArrayList<String> commonLines = new ArrayList<String>();

        int[][] table = new int[file1Size+1][file2Size+1];

        for (int a=0; a<= file1Size; a++)
        {
            for (int b=0; b<= file2Size; b++)
            {
                if (a == 0 || b == 0)
                    table[a][b] = 0;
                else if (file1Lines.get(a-1).equals(file2Lines.get(b-1)))
                    table[a][b] = table[a-1][b-1] + 1;
                else
                    table[a][b] = Math.max(table[a-1][b], table[a][b-1]);
            }
        }

        int longestAmount = table[file1Size][file2Size];
        System.out.println("The # of common lines: " + longestAmount);

        while (file1Size > 0 && file2Size > 0)
        {
            if (file1Lines.get(file1Size-1).equals(file2Lines.get(file2Size-1)))
            {
                commonLines.add(0, file1Lines.get(file1Size-1));
                file1Size = file1Size - 1;
                file2Size = file2Size - 1;
            }
            else if (table[file1Size-1][file2Size] > table[file1Size][file2Size-1])
            {
                file1Size = file1Size - 1;
            }
            else
            {
                file2Size = file2Size -1;
            }
        }

        return commonLines;
    }

}