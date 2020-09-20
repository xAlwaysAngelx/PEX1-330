package com.company;
import java.util.Scanner;
import java.lang.Math;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Vector330ClassWorks {

    public static class xyVectors  {
        public static double x1;
        public static double x2;
        public static double scale;
        public static double y1;
        public static double y2;
        public static double xFin;
        public static double yFin;
        public static double dotFin;
        public static double magFin;
        public static double radians;
        public static double degrees;
    }

    public static void parseVectorAddSubDot(Scanner inputScanner, Scanner inputString) {
        xyVectors value = new xyVectors();
        Pattern originalPattern = inputString.delimiter();
        inputScanner.useDelimiter("[" + originalPattern + ",]");
        if (inputScanner.hasNext("<")) {
            inputScanner.next("<");  //gobble up the '<'
            if (inputScanner.hasNextDouble()) {
                value.x1 = inputScanner.nextDouble(); //capture the x coordinate
                inputScanner.useDelimiter(originalPattern); //restore original delimiters
                if (inputScanner.hasNext(",")) {
                    inputScanner.next(","); //gobble up the comma
                    if (inputScanner.hasNextDouble()) {
                        value.y1 = inputScanner.nextDouble();
                        inputScanner.useDelimiter(originalPattern);
                        if (inputScanner.hasNext(">")) {
                            inputScanner.next(">"); //gobbles up the closing '>'
                            if (inputScanner.hasNext("\\+")) {
                                inputScanner.next("\\+");
                                inputScanner.useDelimiter("[" + originalPattern + ",]");
                                if (inputScanner.hasNext("<")) {
                                    inputScanner.next("<");  //gobble up the '<'
                                    if (inputScanner.hasNextDouble()) {
                                        value.x2 = inputScanner.nextDouble(); //capture the x coordinate
                                        inputScanner.useDelimiter(originalPattern); //restore original delimiters
                                        if (inputScanner.hasNext(",")) {
                                            inputScanner.next(","); //gobble up the comma
                                            if (inputScanner.hasNextDouble()) {
                                                value.y2 = inputScanner.nextDouble();
                                                inputScanner.useDelimiter(originalPattern);
                                                if (inputScanner.hasNext(">")) {
                                                    inputScanner.next(">");
                                                }
                                            }
                                        }
                                    }
                                }
                                add(value);
                            }
                            else if(inputScanner.hasNext("-"))  {
                                inputScanner.next("-");
                                inputScanner.useDelimiter("[" + originalPattern + ",]");
                                if (inputScanner.hasNext("<")) {
                                    inputScanner.next("<");  //gobble up the '<'
                                    if (inputScanner.hasNextDouble()) {
                                        value.x2 = inputScanner.nextDouble(); //capture the x coordinate
                                        inputScanner.useDelimiter(originalPattern); //restore original delimiters
                                        if (inputScanner.hasNext(",")) {
                                            inputScanner.next(","); //gobble up the comma
                                            if (inputScanner.hasNextDouble()) {
                                                value.y2 = inputScanner.nextDouble();
                                                inputScanner.useDelimiter(originalPattern);
                                                if (inputScanner.hasNext(">")) {
                                                    inputScanner.next(">");
                                                }
                                            }
                                        }
                                    }
                                }
                                subtract(value);
                            }
                            else if(inputScanner.hasNext("."))  {
                                inputScanner.next(".");
                                inputScanner.useDelimiter("[" + originalPattern + ",]");
                                if (inputScanner.hasNext("<")) {
                                    inputScanner.next("<");  //gobble up the '<'
                                    if (inputScanner.hasNextDouble()) {
                                        value.x2 = inputScanner.nextDouble(); //capture the x coordinate
                                        inputScanner.useDelimiter(originalPattern); //restore original delimiters
                                        if (inputScanner.hasNext(",")) {
                                            inputScanner.next(","); //gobble up the comma
                                            if (inputScanner.hasNextDouble()) {
                                                value.y2 = inputScanner.nextDouble();
                                                inputScanner.useDelimiter(originalPattern);
                                                if (inputScanner.hasNext(">")) {
                                                    inputScanner.next(">");
                                                }
                                            }
                                        }
                                    }
                                }
                                dotProduct(value);
                            }
                        }
                        //                        System.out.println("This is x " + xCoord);    //tests to see if it catches the x and y coord
                        //                        System.out.println("This is y " + yCoord);
                    }
                }
            }
        }
    }

    public static void parseVectorMagnitude(Scanner inputScanner, Scanner inputString) {
        xyVectors value = new xyVectors();
        Pattern originalPattern = inputString.delimiter();
        inputScanner.useDelimiter("[" + originalPattern + ",]");
        if (inputScanner.hasNext("\\|")) {
            inputScanner.next("\\|");
            inputScanner.useDelimiter("[" + originalPattern + ",]");
            if (inputScanner.hasNext("<")) {
                inputScanner.next("<");  //gobble up the '<'
                if (inputScanner.hasNextDouble()) {
                    value.x1 = inputScanner.nextDouble(); //capture the x coordinate
                    inputScanner.useDelimiter(originalPattern); //restore original delimiters
                    if (inputScanner.hasNext(",")) {
                        inputScanner.next(","); //gobble up the comma
                        if (inputScanner.hasNextDouble()) {
                            value.y1 = inputScanner.nextDouble();
                            inputScanner.useDelimiter(originalPattern);
                            if (inputScanner.hasNext(">")) {
                                inputScanner.next(">"); //gobbles up the closing '>'
                                if (inputScanner.hasNext("\\|")) {
                                    inputScanner.next("\\|");
                                }
                            }
                        }
                    }
                }
                magnitude(value);
            }
        }
    }

    public static void parseVectorUnit(Scanner inputScanner, Scanner inputString) {
        xyVectors value = new xyVectors();
        Pattern originalPattern = inputString.delimiter();
        if (inputScanner.hasNext("unit")) {
            inputScanner.next("unit");
            inputScanner.useDelimiter("[" + originalPattern + ",]");
            if (inputScanner.hasNext("<")) {
                inputScanner.next("<");  //gobble up the '<'
                if (inputScanner.hasNextDouble()) {
                    value.x1 = inputScanner.nextDouble(); //capture the x coordinate
                    inputScanner.useDelimiter(originalPattern); //restore original delimiters
                    if (inputScanner.hasNext(",")) {
                        inputScanner.next(","); //gobble up the comma
                        if (inputScanner.hasNextDouble()) {
                            value.y1 = inputScanner.nextDouble();
                            inputScanner.useDelimiter(originalPattern);
                            if (inputScanner.hasNext(">")) {
                                inputScanner.next(">"); //gobbles up the closing '>'
                                if (inputScanner.hasNext("\\|")) {
                                    inputScanner.next("\\|");
                                }
                            }
                        }
                    }
                }
                normalize(value);
            }
        }
    }

    public static void parseVectorDir(Scanner inputScanner, Scanner inputString) {
        xyVectors value = new xyVectors();
        Pattern originalPattern = inputString.delimiter();
        if (inputScanner.hasNext("dir")) {
            inputScanner.next("dir");
            inputScanner.useDelimiter("[" + originalPattern + ",]");
            if (inputScanner.hasNext("<")) {
                inputScanner.next("<");  //gobble up the '<'
                if (inputScanner.hasNextDouble()) {
                    value.x1 = inputScanner.nextDouble(); //capture the x coordinate
                    inputScanner.useDelimiter(originalPattern); //restore original delimiters
                    if (inputScanner.hasNext(",")) {
                        inputScanner.next(","); //gobble up the comma
                        if (inputScanner.hasNextDouble()) {
                            value.y1 = inputScanner.nextDouble();
                            inputScanner.useDelimiter(originalPattern);
                            if (inputScanner.hasNext(">")) {
                                inputScanner.next(">"); //gobbles up the closing '>'
                                if (inputScanner.hasNext("\\|")) {
                                    inputScanner.next("\\|");
                                }
                            }
                        }
                    }
                }
                direction(value);
            }
        }
    }

    public static void parseVectorScale(Scanner inputScanner, Scanner inputString) {
        xyVectors value = new xyVectors();
        Pattern originalPattern = inputString.delimiter();
        if (inputScanner.hasNextDouble()) {
            value.scale = inputScanner.nextDouble(); //capture the scale
            if (inputScanner.hasNext("\\*")) {
                inputScanner.next("\\*");
                inputScanner.useDelimiter("[" + originalPattern + ",]");
                if (inputScanner.hasNext("<")) {
                    inputScanner.next("<");  //gobble up the '<'
                    if (inputScanner.hasNextDouble()) {
                        value.x1 = inputScanner.nextDouble(); //capture the x coordinate
                        inputScanner.useDelimiter(originalPattern); //restore original delimiters
                        if (inputScanner.hasNext(",")) {
                            inputScanner.next(","); //gobble up the comma
                            if (inputScanner.hasNextDouble()) {
                                value.y1 = inputScanner.nextDouble();
                                inputScanner.useDelimiter(originalPattern);
                                if (inputScanner.hasNext(">")) {
                                    inputScanner.next(">"); //gobbles up the closing '>'
                                }
                            }
                        }
                    }
                }
                scale(value);
            }
        }
    }

    public static void add(xyVectors value) {
        xyVectors result = new xyVectors();
        result.xFin = value.x1 + value.x2;
        result.yFin = value.y1 + value.y2;
    }

    public static void subtract(xyVectors value) {
        xyVectors result = new xyVectors();
        result.xFin = value.x1 - value.x2;
        result.yFin = value.y1 - value.y2;
    }

    public static void dotProduct(xyVectors value)  {
        xyVectors result = new xyVectors();
        result.dotFin = ((value.x1 * value.x2) + (value.y1 * value.y2));

    }

    public static void magnitude(xyVectors value)   {
        xyVectors result = new xyVectors();
        result.magFin = Math.sqrt((value.x1 * value.x1) + (value.y1 * value.y1));
    }

    public static void normalize(xyVectors value)   {
        xyVectors result = new xyVectors();
        double magnitude = Math.sqrt((value.x1 * value.x1) + (value.y1 * value.y1));
        if (magnitude != 0) {
            result.xFin = value.x1/magnitude;
            result.yFin = value.y1/magnitude;
        }
    }

    public static void direction(xyVectors value)   {
        xyVectors result = new xyVectors();
        result.radians = Math.atan2(value.y1, value.x1);
        result.degrees = (180 * result.radians) / Math.PI;
//        result.radians = (360 + Math.round(result.degrees)) % 360;
    }

    public static void scale(xyVectors value) {
        xyVectors result = new xyVectors();
        result.xFin = value.scale * value.x1;
        result.yFin = value.scale + value.y1;
    }

}
