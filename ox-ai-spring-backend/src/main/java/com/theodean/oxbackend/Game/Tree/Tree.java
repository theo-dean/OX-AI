package com.theodean.oxbackend.Game.Tree;
import com.theodean.oxbackend.Game.Board;

import java.util.ArrayList;
import java.util.Iterator;

public class Tree {

    /** Performs a pre-order search of a tree given a root node. */
    static void printPreOrderTree(Node node){
        System.out.println(node.toString());    //Process (in this context by printing) the current node
        System.out.println(node.getData().gameStatus());    //Check game status
        if (!node.isLeaf()){
            Node temp = node.getLeftMostChild();    //Expand left child
            while (temp != null){   //if the Left child exists
                printPreOrderTree(temp);    //recurse
                temp = temp.getRightSibling();  // Get parent's right sibling
            }
        }
    }

    /** Populates the game tree with all possible future moves from the current Board state. */
    static void populateTree(Node node){
        if(node.getData().gameStatus() == Board.gameState.ACTIVE){
            node.addChildren(node.getData().possibleMoves());
            Node temp = node.getLeftMostChild();
            while (temp!= null){
                populateTree(temp);
                temp = temp.getRightSibling();
            }
        }
    }

/*    static void printPostOrder(Node node) {       // Fix Me
        if (!node.isLeaf()) {
            Node temp = node.getLeftMostChild();
            while (temp != null) {
                printPostOrder(temp);
                temp = temp.getRightSibling();
            }
        }
        else {
            System.out.println(node.toString());
        }
    }*/


    public static void main(String[] args){
        try {
            /*Node root = new Node(new Board(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
            root.addChild(new Board(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0}));
            root.addChild(new Board(new int[]{0,1,0,0,0,0,0,0,0}));
            root.getLeftMostChild().addChild(new Board(new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0}));
            root.getLeftMostChild().getLeftMostChild().addChild(new Board(new int[]{1,1,1,0,0,0,0,0,0}));*/
            //System.out.println(root.toString());
            //System.out.println(root.getLeftMostChild().toString());
            //System.out.println(root.getLeftMostChild().getRightSibling().toString());
            //System.out.println(root.getLeftMostChild().getLeftMostChild().toString());
            //printPreOrderTree(root);
            Board tempBoard = new Board(new int[]{1,0,0,2,1,1,2,0,2});
            Node root = new Node(tempBoard);
            populateTree(root);
            printPreOrderTree(root);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
