package com.theodean.oxbackend.Game.Tree;
import com.theodean.oxbackend.Game.Board;

import java.util.ArrayList;
import java.util.Iterator;

public class Tree {

    /** Performs a pre-order search of a tree given a root node. */
    static void printPreOrderTree(Node node){
        System.out.println(node.toString());    //Process (in this context by printing) the current node
        System.out.println(node.getData().gameStatus());    //Check game status
        System.out.println("Heuristic: "+ node.getHeuristic()); //Check the heuristic value of the node (null if not processed)
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

    /** Returns a numerical representation of the heuristic value of a Node. */
    static int evaluationFunction(Node node){
        if (node.getData().gameStatus() == Board.gameState.PLAYER_WIN){
            return -1;
        }
        if (node.getData().gameStatus() == Board.gameState.AI_WIN){
            return 1;
        }
        else return 0;  // Draw
    }

    /** Performs the minmax function; calculating the move that best minimises loss (and maximises gain). */
    static int minMax(Node node, boolean maximising){
        if (node.isLeaf()){
            node.setHeuristic(evaluationFunction(node));
            return evaluationFunction(node);
        }
        if (maximising){
            int val = -1;
            Node temp = node.getLeftMostChild();
            while (temp != null){
                val = Integer.max(val, minMax(temp, false));
                node.setHeuristic(val);
                temp = temp.getRightSibling();
            }
            return val;
        }
        else {
            int val = 1;
            Node temp = node.getLeftMostChild();
            while (temp != null){
                val = Integer.min(val, minMax(temp, true));
                node.setHeuristic(val);
                temp = temp.getRightSibling();
            }
            return val;
        }
    }

    /** Returns the grid reference of the best move for the AI (naught) player from the given game. */
    public static int bestMoveNaught(Node node) throws Exception{
        populateTree(node);

        Node temp = node.getLeftMostChild();
        int maxHeuristic = Integer.MIN_VALUE;
        int move = 0;
        while(temp != null){
            if (evaluationFunction(temp) == 1) { // If the move is a winning one, pick it.
                return node.getData().gridDifference(temp.getData());
            }
            if (minMax(temp, true) > maxHeuristic){
                maxHeuristic = temp.getHeuristic();
                move = node.getData().gridDifference(temp.getData());
            }
            temp = temp.getRightSibling();
        }
        return move;
    }

    public static void main(String[] args){ // Messy test method; todo: clean this shit up
        try {
/*            Node root = new Node(new Board(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
            root.addChild(new Board(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0}));
            root.addChild(new Board(new int[]{0,1,0,0,0,0,0,0,0}));
            root.getLeftMostChild().addChild(new Board(new int[]{1, 1, 0, 0, 0, 0, 0, 0, 0}));
            root.getLeftMostChild().getLeftMostChild().addChild(new Board(new int[]{1,1,1,0,0,0,0,0,0}));*/

            Board tempBoard = new Board(new int[]{1,2,0,0,1,0,0,0,0});
            Node root = new Node(tempBoard);
            //populateTree(root);
            //minMax(root, false);
            //printPreOrderTree(root);
            //System.out.println(minMax(root,true));
            printPreOrderTree(root);
            System.out.println(bestMoveNaught(root));

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
