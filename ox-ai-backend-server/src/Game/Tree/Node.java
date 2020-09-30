package Game.Tree;

import Game.Board;

import java.util.ArrayList;

public class Node {
    private Board data;
    private Node root;
    private ArrayList<Node> children;

    Node(Board data){       //Root node constructor
        this.data = data;
        this.root = null;
    }

    Node(Board data, Node root){    //Branch and leaf constructor
        this.data = data;
        this.root = root;
    }

    void addChild(Board data){
        if (children == null){
            children = new ArrayList<>();   //Maybe should initialise in constructor? memory vs computations
        }
        children.add(new Node(data, this));
    }

    boolean isLeaf(){
        if (children == null){
            return true;
        }
        else {return false;}        //Could also check if children is empty
    }

    Board getData(){
        return this.data;
    }
}
