package com.theodean.oxbackend.Game.Tree;

import com.theodean.oxbackend.Game.Board;

public class Node {
    private Board data;
    private Node root;
    private Node leftMostChild;
    private Node rightSibling;

    Node(Board data){       //Root node constructor
        this.data = data;
        this.root = null;
    }

    Node(Board data, Node root){    //Branch and leaf constructor
        this.data = data;
        this.root = root;
    }

    void addChild(Board data){      //Adds a child node to this node
        if (leftMostChild == null) {        //If no children exist, this will be the left most child node
            leftMostChild = new Node(data, this);
        } else {
            Node temp = leftMostChild;
            while (temp.getRightSibling() != null){     //If at least 1 child already exists, find the "end" child, and become the right sibling of that child
                temp = temp.getRightSibling();
            }
            try {
                temp.addRightSibling(data);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

   private void addRightSibling(Board data) throws Exception{
        if (getRightSibling() == null){
            rightSibling = new Node(data, this);
        } else {
            throw new Exception("Right sibling already exists.");
        }
    }

    boolean isLeaf(){
        return leftMostChild == null;        //Could also check if children is empty
    }

    boolean isRoot(){
        return root == null;
    }

    Board getData(){
        return this.data;
    }

    Node getLeftMostChild(){
        return leftMostChild;
    }

    Node getRightSibling(){
        return rightSibling;
    }

    public String toString(){
        return data.toString();
    }
}
