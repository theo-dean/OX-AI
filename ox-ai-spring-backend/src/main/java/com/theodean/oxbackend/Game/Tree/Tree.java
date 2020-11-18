package com.theodean.oxbackend.Game.Tree;
import com.theodean.oxbackend.Game.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Tree {

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

    static void populateTree(Node node){

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
            Node root = new Node(new Board(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
            root.addChild(new Board(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0}));
            root.addChild(new Board(new int[]{0,1,0,0,0,0,0,0,0}));
            root.getLeftMostChild().addChild(new Board(new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0}));
            root.getLeftMostChild().getLeftMostChild().addChild(new Board(new int[]{1,1,1,0,0,0,0,0,0}));
            //System.out.println(root.toString());
            //System.out.println(root.getLeftMostChild().toString());
            //System.out.println(root.getLeftMostChild().getRightSibling().toString());
            //System.out.println(root.getLeftMostChild().getLeftMostChild().toString());
            //printPreOrderTree(root);
            Board tempBoard = new Board(new int[]{1,2,1,1,0,2,0,0,2});
            ArrayList<Board> temp = tempBoard.possibleMoves();
            System.out.println(tempBoard);
            System.out.println("ORIGINAL_BOARD");
            Iterator<Board> it = temp.iterator();
            while (it.hasNext()){
                Board tempIt = it.next();
                System.out.println(tempIt);
                System.out.println(tempIt.gameStatus());
                            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
