package Game.Tree;

import Game.Board;
import java.util.LinkedList;

public class Node {
    private Board data;
    private Node root;
    private LinkedList<Node> children;

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
            children = new LinkedList<>();   //Maybe should initialise in constructor? memory vs computations
        }
        children.add(new Node(data, this));
    }

    boolean isLeaf(){
        return children == null;        //Could also check if children is empty
    }

    boolean isRoot(){
        return root == null;
    }

    Board getData(){
        return this.data;
    }
}
