package com.theodean.oxbackend.Game.Tree;

import com.theodean.oxbackend.Game.Board;

import java.util.Collection;

public class Node {
    private Board data;
    private int heuristic;
    private Node root;
    private Node leftMostChild;
    private Node rightSibling;

    //TODO: write javadoc for this class
    public Node(Board data) {       //Root node constructor
        this.data = data;
        this.root = null;
    }

    Node(Board data, Node root) {    //Branch and leaf constructor
        this.data = data;
        this.root = root;
    }

    void addChild(Board data) {      //Adds a child node to this node
        if (leftMostChild == null) {        //If no children exist, this will be the left most child node
            leftMostChild = new Node(data, this);
        } else {
            Node temp = leftMostChild;
            while (temp.getRightSibling() != null) {     //If at least 1 child already exists, find the "end" child, and become the right sibling of that child
                temp = temp.getRightSibling();
            }
            try {
                temp.addRightSibling(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void addChildren(Collection<Board> children){
        for(Board child : children){
           addChild(child);
        }
    }

    private void addRightSibling(Board data) throws Exception {
        if (getRightSibling() == null) {
            rightSibling = new Node(data, this);
        } else {
            throw new Exception("Right sibling already exists.");
        }
    }

    boolean isLeaf() {
        return leftMostChild == null;        //Could also check if children is empty
    }

    boolean isRoot() {
        return root == null;
    }

    Board getData() {
        return this.data;
    }

    Node getLeftMostChild() {
        return leftMostChild;
    }

    Node getRightSibling() {
        return rightSibling;
    }

    void setHeuristic(int heuristic){
        this.heuristic = heuristic;
    }

    int getHeuristic() {
        return this.heuristic;
    }

    public String toString() {
        return data.toString();
    }
}
