
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ben Rhuman, Isaac Sotelo, Brendan Tracey Based of code by Qing Yang
 */
public class Huffman {

    String input;
    PriorityQ theQ = new PriorityQ();
    int[] freqTable = new int[28];
    String[] codeTable = new String[28];
    Tree huffTree;
    String encoded;
    String decoded;

    public Huffman(String input) {
        this.input = input;
        Arrays.fill(freqTable, 0);
        System.out.println(input);
        makeFreqTable();
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
            System.out.print(freqTable[i] + " ");
        }
        System.out.print("\n");
    }

    public void queueTree() {
        for (int i = 0; i < freqTable.length; i++) {
            if (freqTable[i] > 0) {
                Tree t = new Tree();
                t.insert(freqTable[i], (char) (i + 65));
                theQ.insert(t);
            }
        }
    }

    public void makeHuffmanTree() {
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

    public void displayTree() {
        huffTree.displayTree(); // Prints out tree for user to view
    }

    private void findCode(Node localRoot, String code) {
        if (localRoot.dData == '+') {
            findCode(localRoot.leftChild, code + "0");
            findCode(localRoot.rightChild, code + "1");
        } else {
            codeTable[(int) localRoot.dData - 65] = code;
        }
    }

    public void code() {
        encoded = "";
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

    public void decode() {
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
