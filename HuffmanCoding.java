/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author k28h885
 */
public class HuffmanCoding {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        String inputData = "";
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Enter first letter of enter, show, code, or decode: ");
            int choice = getChar();
            switch (choice) {
                case 'e':                       // Enter: User inputs desired lines of text to compress
                    String temp = "";
                    System.out.print("Enter text lines, terminate with $\n");
                    do {                         // Do-while loop so that this loop will end when a user enters "$"
                        inputData += temp;
                        temp = s.nextLine() + "\\"; // "\" represent linefeeds and "[" represent spaces
                    } while (!temp.equals("$\\"));
                    inputData = inputData.replaceAll(" ", "[");
                    System.out.println(inputData);
                    System.out.println(inputData.length());
                    getFrequency(inputData);
                    //some priority queue = getFrequency(inputData);
                    break;
                case 's':
                    break;
                case 'c':
                    break;
                case 'd':
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

//        int value;
//        Tree theTree = new Tree();
//        theTree.insert(50, 1.5);
//        theTree.insert(25, 1.2);
//        theTree.insert(75, 1.7);
//        theTree.insert(12, 1.5);
//        theTree.insert(37, 1.2);
//        theTree.insert(43, 1.7);
//        theTree.insert(30, 1.5);
//        theTree.insert(33, 1.2);
//        theTree.insert(87, 1.7);
//        theTree.insert(93, 1.5);
//        theTree.insert(97, 1.5);    
//            switch (choice) {
//                case 's':
//                    theTree.displayTree();
//                    break;
//                case 'i':
//                    System.out.print("Enter value to insert: ");
//                    value = getInt();
//                    theTree.insert(value, value + 0.9);
//                    break;
//                case 'f':
//                    System.out.print("Enter value to find: ");
//                    value = getInt();
//                    Node found = theTree.find(value);
//                    if (found != null) {
//                        System.out.print("Found: ");
//                        found.displayNode();
//                        System.out.print("\n");
//                    } else {
//                        System.out.print("Could not find ");
//                    }
//                    System.out.print(value + '\n');
//                    break;
//                case 'd':
//                    System.out.print("Enter value to delete: ");
//                    value = getInt();
//                    boolean didDelete = theTree.delete(value);
//                    if (didDelete) {
//                        System.out.print("Deleted " + value + "\n");
//                    } else {
//                        System.out.print("Could not delete ");
//                    }
//                    System.out.print(value + "\n");
//                    break;
//                case 't':
//                    System.out.print("Enter type 1, 2 or 3: ");
//                    value = getInt();
//                    theTree.traverse(value);
//                    break;
//                default:
//                    System.out.print("Invalid entry\n");
//            } // end switch
//        } // end while
//    } // end main()
// -------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // -------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    // -------------------------------------------------------------
    public static void /*PriorityQ*/ getFrequency(String input) {
        //PriorityQ freq = new PriorityQ();
        String[] charCheck = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "R", "X", "Y", "Z", "[", "\\", "]"};
        int count;
        for (int i = 0; i < charCheck.length; i++) {
            count = 0;
            for (int j = 0; j < input.length(); j++) {
                if(charCheck[i].equalsIgnoreCase(input.substring(j,j+1))){
                    count++;
                }
                //System.out.println(input.substring(j, j + 1));
            }
            System.out.println(charCheck[i] + ": " + count);
        }
        //return //Some priority queue
    }
}