package Game.Tree;

import Game.Board;

import java.util.LinkedList;

public class Tree {

    static void printPreOrderTree(Node node){
        System.out.println(node.toString());
        if (!node.isLeaf()){
            Node temp = node.getLeftMostChild();
            while (temp != null){
                printPreOrderTree(temp);
                temp = temp.getRightSibling();
            }
        }
    }


    public static void main(String[] args){
        Node root = new Node(new Board(new int[]{0,0,0,0,0,0,0,0,0}));
        root.addChild(new Board(new int[]{1,0,0,0,0,0,0,0,0}));
        System.out.println(root.toString());
        System.out.println(root.getLeftMostChild().toString());

    }
}
