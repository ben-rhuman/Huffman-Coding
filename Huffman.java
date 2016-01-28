
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class Huffman {

    String input;
    PriorityQ theQ;
    int[] freqTable = new int[28]; 
    String[] codeTable;
    Tree huffTree;
    String encoded;
    String decoded;

    public Huffman(String input) {
        this.input = input;
        Arrays.fill(freqTable, 0);
        System.out.println(input);
        char c = 'A';
        int cc = (int)c - 65;
        System.out.println(cc);
        makeFreqTable();
        queueTree();
        makeHuffmanTree();
    }

    public void makeFreqTable(){
        int temp;
        for(int i = 0; i < input.length(); i++){
            //System.out.println((int)input.charAt(i));
            //temp = (int)input.charAt(i) - 65;
            freqTable[(int)input.charAt(i) - 65]++;
        }
        System.out.println("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z [ \\");
        for(int i = 0; i < freqTable.length; i++){
            System.out.print(freqTable[i] + " ");
        }
        System.out.print("\n");
    }
    
    public void queueTree(){
        
    }
    
    public void makeHuffmanTree(){
        
    }
    
    public void makeCodeTable(){
        
    }
    
    public void displayTree() {
        
    }

    public void code() {
        
    }

    public void decode() {
        
    }

}
