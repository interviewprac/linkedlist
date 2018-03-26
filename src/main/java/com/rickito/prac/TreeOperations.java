package com.rickito.prac;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperations {

    static class Node
    {
        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data= data;
        }
    }

    Node root;
    public void bfs(Node node)
    {
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (queue.size()>0)
        {
            Node temp= queue.poll();

            System.out.print(temp.data + " ");

            if(temp.left!=null)
                queue.add(temp.left);

            if(temp.right!=null)
                queue.add(temp.right);
        }
    }

    public void bfsHeight(Node n)
    {
        if(n==null)
            return;

        int h = findHeight(n);
        System.out.println("Height: "+ h);
        for (int i=1; i<=h; i++)
        {
            printlevel(n, i);
        }

    }

    public void printlevel(Node n, int level)
    {
        if(n==null)
            return;

        if(level==1)
            System.out.print(n.data + " ");
        else
        {
            printlevel(n.left,level-1);
            printlevel(n.right,level-1);
        }
    }

    public int findHeight(Node n)
    {
        if(n==null)
            return 0;

        int lh =findHeight(n.left);
        int rh = findHeight(n.right);

        return Math.max(lh,rh) +1;
    }

    public void mirror(Node n)
    {
        if(n == null)
            return;

        Node temp = n.left;
        n.left= n.right;
        n.right= temp;

        mirror(n.left);
        mirror(n.right);
    }

    public boolean checkMirror(Node n1, Node n2)
    {
        if(n1==null && n2 == null)
            return true;

        if(n1==null || n2==null)
            return false;

       return (n1.data==n2.data)&& checkMirror(n1.left,n2.right) && checkMirror(n1.right,n2.left);

    }


    public static void main(String args[])
    {
        TreeOperations tree = new TreeOperations();
         tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(9);
        tree.root.right.right = new Node(7);
        tree.bfs(tree.root);
        System.out.println();
        System.out.println("==========================");
        tree.bfsHeight(tree.root);
        System.out.println("=============================");
        tree.mirror(tree.root);
        tree.bfs(tree.root);
       // System.out.println(tree.checkMirror());

    }
}
