// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;
public class Warning
{
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args)
    {
        int creditHrs=0; // number of semester hours earned
        double qualityPts=0; // number of quality points earned
        double gpa; // grade point (quality point) average
        String line, name, inputName = "students.dat";
        name = "nama";
        String outputName = "warning.dat";

        try
        {
            File file = new File("C:\\Users\\ACER\\Documents\\NetBeansProjects\\RnW\\src\\students.dat");
            File ofile = new File("C:\\Users\\ACER\\Documents\\NetBeansProjects\\RnW\\src\\warning.dat");
            Scanner scan = new Scanner(file);
            PrintWriter outFile = new PrintWriter(ofile);
            // Print a header to the output file
            outFile.println ();
            outFile.println ("Students on Academic Warning");
            outFile.println ();
            // Process the input file, one token at a time
//            while (scan.hasNextLine())
//            {
                while(scan.hasNext()){
                    name = scan.next();
                    creditHrs = scan.nextInt();
                    qualityPts = scan.nextDouble();
//                    try{
//                        creditHrs = Integer.parseInt(scan.next());
//                    }
//                    catch(NumberFormatException en){
////                        try{
////                            qualityPts = Double.parseDouble(scan.next());
////                        }
////                        catch(NumberFormatException ex){
////                        name = scan.next();
////                        }
//                    }
                    gpa = qualityPts/creditHrs;
                    line = name + " " + creditHrs + " " + gpa;
                    if(gpa < 1.5 && creditHrs <30 || gpa < 1.75 && creditHrs < 60 || gpa <2){
                        outFile.println(line);
                    }
                }
                
                // determine if the student is on warning. If so,
                // write the student data to the output file.
//            }
            outFile.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("The file " + inputName + " was not found.");
        }
        catch (IOException exception)
        {
            System.out.println (exception);
        }
        catch (NumberFormatException e)
        {
            System.out.println ("Format error in input file: " + e);
        }
    }
}