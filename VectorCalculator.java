package com.company;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * VectorCalculator -  ADD STUFF HERE<br>
 *
 * <i>Documentation: </i>
 *
 * @author C22Lindsay.Brummett
 */
public class VectorCalculator {
    /**
     * @param args array of strings for command line arguments
     */
    public static void main(String[] args) {
    Scanner inputString = new Scanner(System.in);
    System.out.println("Welcome to the Vector Calculator!");
    System.out.println("Please input 'help' to find a list of options for what the calculator can do and how to format" +
            " your inputs.\n");
    boolean continuePlaying = true;
    //Vector330Class.vectorClass(); test of using a different class
        do {
            System.out.print("Enter vector expression: ");
            String input = inputString.nextLine();
            Scanner inputScanner = new Scanner(input);
            StringTokenizer inputTokens = new StringTokenizer(input, "[<>+-.]", true);
//            while (inputTokens.hasMoreTokens()) {
//                System.out.println("Token: " + inputTokens.nextToken()); //testing token input
                String[] arr = input.split(" ", 2);
                String firstWord = arr[0];
                if (firstWord.equals("<")) {
                    if (input.contains("+") || input.contains("-")) {
                        Vector330ClassWorks.parseVectorAddSubDot(inputScanner, inputString);
                        double resultX = Vector330ClassWorks.xyVectors.xFin;
                        double resultY = Vector330ClassWorks.xyVectors.yFin;
                        System.out.println("Result is < " + resultX + ", " + resultY + " >\n");
                    } else if (input.contains(".")) {
                        Vector330ClassWorks.parseVectorAddSubDot(inputScanner, inputString);
                        double resultDot = Vector330ClassWorks.xyVectors.dotFin;
                        System.out.println("Result is " + resultDot + "\n");
                    }
                }
                else if (firstWord.equals("|"))  {
                    Vector330ClassWorks.parseVectorMagnitude(inputScanner, inputString);
                    double resultMag = Vector330ClassWorks.xyVectors.magFin;
                    System.out.println("Result is " + resultMag + "\n");
                }
                else if (firstWord.equals("unit"))   {
                    Vector330ClassWorks.parseVectorUnit(inputScanner, inputString);
                    double resultX = Vector330ClassWorks.xyVectors.xFin;
                    double resultY = Vector330ClassWorks.xyVectors.yFin;
                    System.out.println("Result is < " + resultX + ", " + resultY + " >\n");
                }
                else if (firstWord.equals("dir"))   {
                    Vector330ClassWorks.parseVectorDir(inputScanner, inputString);
                    double radians = Vector330ClassWorks.xyVectors.radians;
                    double degrees = Vector330ClassWorks.xyVectors.degrees;
                    System.out.printf("Result is %.5f (%.5f degrees)\n\n", radians, degrees);
                }
                else if (firstWord.equals("dir"))   {
                    Vector330ClassWorks.parseVectorDir(inputScanner, inputString);
                    double radians = Vector330ClassWorks.xyVectors.radians;
                    double degrees = Vector330ClassWorks.xyVectors.degrees;
                    System.out.printf("Result is %.5f (%.5f degrees)\n\n", radians, degrees);
                }
                else if (inputScanner.hasNextDouble())   {
                    Vector330ClassWorks.parseVectorScale(inputScanner, inputString);
                    double resultX = Vector330ClassWorks.xyVectors.xFin;
                    double resultY = Vector330ClassWorks.xyVectors.yFin;
                    System.out.println("Result is < " + resultX + ", " + resultY + " >\n");
                }
                else if (firstWord.equals("help"))   {
                    System.out.println("a. A vector added to another vector in the form: < 4.2, 7.1 > + < 1.1, 2.6 > " +
                            "where the\n" +
                            "vectors follow the format prescribed in requirement 1.d.x and there is a space\n" +
                            "before and after the “+”.\n" +
                            "b. A vector minus another vector in the form: < 4.2, 7.1 > - < 1.1, 2.6 > where the\n" +
                            "vectors follow the format prescribed in requirement 1.d.x and there is a space\n" +
                            "before and after the “-”.\n" +
                            "c. A vector dot product with another vector in the form: < 4.2, 7.1 > . < 1.1, 2.6 >\n" +
                            "where the vectors follow the format prescribed in requirement 1.d.x and there is a\n" +
                            "space before and after the “.”.\n" +
                            "d. A vector norm with a vector expression encompassed on either side with “|” in the\n" +
                            "form, | < 3.0, 4.0 > | that produces the length (magnitude) of the vector.\n" +
                            "e. A scalar-vector multiplication as a number followed by “*” as a multiply sign and\n" +
                            "then a vector as in the form: 5.1 * < 3.2, 7.2 >.\n" +
                            "f. A vector direction with the word, “dir” followed by a space and then a vector of\n" +
                            "the form: dir < 5.4, 6.3 > that produce the vector’s angle from the x-axis in both\n" +
                            "radians and degrees.\n" +
                            "g. A unit vector calculation with the word, “unit” followed by a space and then a\n" +
                            "vector of the form: unit < 3.0, 4.0 > that produces a vector in the same direction as\n" +
                            "the original vector but with a length of one.\n" +
                            "h. An “exit” command that causes the vector calculation to close and exit. \n");
                }
                else if (firstWord.equals("exit")) {
                    continuePlaying = false;
                }
                else {
                    System.out.println("Invalid input, please try again.\n");
                }
        } while(continuePlaying);
        System.out.println("\nThank you for using the Vector Calculator.");
    }
}
