/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author issamalzouby
 */
import java.util.*;

public class GPACalculator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        char letterGrade;    // User defined letter grade 
        int creditHours =0 ;     // User defined number of credit hours
        char quitCmd;        // Indicates quit/continue

        quitCmd = 'a';

        int qualityPoints = 0;
        int totalCreditHrs = 0;

        while (quitCmd != 'q') {

            // Get user data
            
            try{
            System.out.print("Enter letter grade: ");
            letterGrade = scnr.nextLine().charAt(0);
            
            //errorchecking unknown letter grade
            
            if(getLetterGradeValue(letterGrade) == -1){
                //throw new Exception("Invlaid letter grade");
                throw new InputMismatchException("Invalid number of credits, Try Again!");
            } 
                System.out.println("Enter number of credit hours");
            creditHours = scnr.nextInt();
            
            //errorchecking negative credit hours
            
            if(creditHours < 0 ){
               // throw new Exception("Invalid number of credits, Try Again!");
                throw new InputMismatchException("Invalid number of credits, Try Again!");
           
            }
            
           /* System.out.print("Enter number of credit hours: ");
            creditHours = scnr.nextInt();
            totalCreditHrs += creditHours;

            qualityPoints += getLetterGradeValue(letterGrade) * creditHours;
            System.out.print("\nEnter any key to continue entering grade or 'q' to quit: ");
            quitCmd = scnr.next().charAt(0);
            scnr.nextLine();*/
           totalCreditHrs += creditHours;
           
          qualityPoints += getLetterGradeValue(letterGrade) * creditHours;
            }catch (Exception excpt){
            System.out.println(excpt.getMessage());
            System.out.println("Cannot compute GPA");
        }/*catch (InputMismatchException excpt){
            scnr.nextLine();
            System.out.println("Cannot compute GPA");
        }*/
            System.out.println("\nEnter any key to continue entering grade" + "or 'q' to quit" );
            quitCmd = scnr.next().charAt(0);
            scnr.nextLine();
        }

        try{
        // cacluate GPA - Divide the total quality points by the total credit hours.
        double gpa = computeIntGPA(qualityPoints, totalCreditHrs);

        //Print user GPA info
        System.out.println("GPA: " + gpa);
        }catch (ArithmeticException excpt){
            System.out.println(excpt.getMessage());
            System.out.println("Illegal Operation");
        }

    }

    private static int getLetterGradeValue(char letterGrade) {
        if (letterGrade == 'a' || letterGrade == 'A') {
            return 4;
        }
        if (letterGrade == 'b' || letterGrade == 'B') {
            return 3;
        }
        if (letterGrade == 'c' || letterGrade == 'C') {
            return 2;
        }
        if (letterGrade == 'd' || letterGrade == 'D') {
            return 1;
        } 
        if (letterGrade == 'f' || letterGrade == 'F') {
            return 0;
        } else {
            return -1;
        }
    }

    private static int computeIntGPA(int qualityPoints, int ceditHours) {
        return qualityPoints / ceditHours;
    }

    private static double computeGPA(int qualityPoints, int ceditHours) {
        return ((double) qualityPoints) / ceditHours;
    }
}
