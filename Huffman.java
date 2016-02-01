
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
    String[] codeTable;
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
                theQ.insert(t);  //It works first try!!!!
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
            if(theQ.isEmpty()){
                huffTree.root = t.root;
            }else
                theQ.insert(t);
        }
    }

    public void makeCodeTable() {

    }

    public void displayTree() {

    }

    public void code() {

    }

    public void decode() {

    }

}
