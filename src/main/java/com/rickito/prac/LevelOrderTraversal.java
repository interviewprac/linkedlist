package com.rickito.prac;

import java.util.*;

public class LevelOrderTraversal {

    Node root;
    static class Node
    {
        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data=data;
        }
    }

    public void printLevelOrder(Node node)
    {
        Queue<Node> q = new LinkedList<Node>() ;

        q.add(node);

        while (!q.isEmpty())
        {
            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if(temp.left!=null)
                q.add(temp.left);

            if(temp.right!=null)
                q.add(temp.right);
        }

    }

    public void printReverseLevelOrder(Node node)
    {
        Queue<Node> q = new LinkedList<Node>() ;

        Stack<Node> s = new Stack<Node>();
        q.add(node);

        while (!q.isEmpty())
        {
            Node temp = q.poll();
            s.add(temp);

            if(temp.left!=null) {
                q.add(temp.left);
            }

            if(temp.right!=null) {
                q.add(temp.right);
            }
        }

        while(!s.isEmpty())
        {
            System.out.print(s.pop().data+ "  ");
        }

    }
    // Driver method
    public static void main(String[] args)
    {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(9);
        tree.root.right.right = new Node(7);
        tree.printLevelOrder(tree.root);
        System.out.println("========================== Reverse =====================");
        tree.printReverseLevelOrder(tree.root);
    }

}
