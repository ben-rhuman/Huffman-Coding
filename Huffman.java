/**
 *
 * @author Ben Rhuman, Isaac Sotelo, Brendan Tracey 
 * Based of code by Qing Yang
 */

import java.util.Arrays;

////////////////////////////////////////////////////////////////
public class Huffman {

    String input; // Holds the unencoded raw user input
    String encoded = "";
    String decoded;
    int[] freqTable = new int[28]; // Holds the frequency of the 28 possible characters
    String[] codeTable = new String[28]; //Holds the binary code assigned to each of the 28 possible characters
    PriorityQ theQ = new PriorityQ(); //Intializes queue for use in tree building
    Tree huffTree;

    public Huffman(String input) {  //Class constructor
        this.input = input;
        Arrays.fill(freqTable, 0);  //Intializes the frequency array data to 0's.
        System.out.println(input);
        makeFreqTable();  //Method calls makes frequency table and construct the huffman tree with user input data
        queueTree();
        makeHuffmanTree();
    }

    public void makeFreqTable() {
        int temp;
        for (int i = 0; i < input.length(); i++) {
            freqTable[(int) input.charAt(i) - 65]++;  //uses ASCII value of character in input to count occurances
        }
        System.out.println("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z [ \\");
        for (int i = 0; i < freqTable.length; i++) {
            System.out.print(freqTable[i] + " "); //Prints out frequency
        }
        System.out.print("\n");
    }

    public void queueTree() {   // Builds the queue along with all the subtrees that exist within.
        for (int i = 0; i < freqTable.length; i++) {
            if (freqTable[i] > 0) {
                Tree t = new Tree();
                t.insert(freqTable[i], (char) (i + 65));
                theQ.insert(t);
            }
        }
    }

    public void makeHuffmanTree() { //Goes through the process of combining the two lowest priority subtrees and then replacing them within the queue until a single tree is left
        while (!theQ.isEmpty()) {
            Tree t = new Tree();
            Tree left = theQ.remove();
            Tree right = theQ.remove();
            t.insert(left.root.iData + right.root.iData, '+');
            t.root.leftChild = left.root;
            t.root.rightChild = right.root;
            if (theQ.isEmpty()) {
                huffTree = t;
            } else {
                theQ.insert(t);
            }
        }
    }

    public void displayTree() { // Calls the slightly modified display tree method from the Tree class
        huffTree.displayTree(); // Prints out tree for user to view
    }

    private void findCode(Node localRoot, String code) { //Recursively traverses tree saving the leaf node locations as a string in their respective codeTable[] slot
        if (localRoot.dData == '+') {
            findCode(localRoot.leftChild, code + "0");
            findCode(localRoot.rightChild, code + "1");
        } else {
            codeTable[(int) localRoot.dData - 65] = code;
        }
    }

    public void code() {    // Takes codeTable data and creates a coded string with the binary versions of the substrings within the user input
        findCode(huffTree.root, encoded);
        for (int i = 0; i < codeTable.length; i++) {
            if (freqTable[i] > 0) {
                System.out.println((char) (i + 65) + " " + codeTable[i]);
            }
        }
        System.out.println("Coded message:");
        for (int i = 0; i < input.length(); i++) {
            encoded += codeTable[(int) input.charAt(i) - 65];
        }

        System.out.print("\n" + encoded + "\n");
    }

    public void decode() { //Traverses tree based on direction given by the encoded string
        Node current = huffTree.root;
        decoded = "";

        for (int i = 0; i < encoded.length(); i++) {
            if (encoded.charAt(i) == '0') {
                current = current.leftChild;
                if (current.leftChild == null) {
                    decoded += current.dData;
                    current = huffTree.root;
                }
            } else {
                current = current.rightChild;
                if (current.rightChild == null) {
                    decoded += current.dData;
                    current = huffTree.root;
                }
            }
        }
        System.out.println("Decoded msg: \n" + decoded);
    }
}
