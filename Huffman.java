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
    int freqTable;
    String codeTable[];
    Tree huffTree;
    String encoded;
    String decoded;
    
    public Huffman(String input){
        this.input = input;
    }
}
