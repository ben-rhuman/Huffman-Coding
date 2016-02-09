/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Ben Rhuman, Isaac Sotelo, Brendan Tracey Based of code by Qing Yang
 */
////////////////////////////////////////////////////////////////
class Tree {

    public Node root; // first node of tree
    // -------------------------------------------------------------

    public Tree() // constructor
    {
        root = null;
    } // no nodes in tree yet
    //-------------------------------------------------------------

    public void insert(int freq, char dd) {
        Node newNode = new Node(); // make new node
        newNode.iData = freq; // insert data
        newNode.dData = dd;
        if (root == null) // no node in root
        {
            root = newNode;
        } else // root occupied
        {
            Node current = root; // start at root
            Node parent;
            while (true) // (exits internally)
            {
                parent = current;
                if (freq < current.iData) // go left?
                {
                    current = current.leftChild;
                    if (current == null) // if end of the line,
                    { // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } // end if go left
                else // or go right?
                {
                    current = current.rightChild;
                    if (current == null) // if end of the line
                    { // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                } // end else go right
            } // end while
        } // end else not root
    } // end insert()
    // -------------------------------------------------------------

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    temp.displayNode();
                    //System.out.print(temp.dData + temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null
                            || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            } // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        } // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    } // end displayTree()
    // -------------------------------------------------------------
} // end class Tree
////////////////////////////////////////////////////////////////

