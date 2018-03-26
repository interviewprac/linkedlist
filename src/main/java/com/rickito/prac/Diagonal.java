package com.rickito.prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Diagonal {

    Node root;

    static class Node{
        Node left ;
        Node right;
        int data;

        Node(int data)
        {
            this.data = data;
        }
    }


    public void printDiagonalUtil(Node node, int d, HashMap<Integer,Vector<Node>> map)
    {
        if(node== null)
        {
            return;
        }
        Vector<Node> k = map.get(d);

        if(k ==null)
        {
            k = new Vector<Node>();
            k.add(node);
        }

        else
        {
            k.add(node);
        }

        map.put(d,k);

        printDiagonalUtil(node.left, d+1,map);
        printDiagonalUtil(node.right,  d, map);

    }

    public void printDiagonal(Node root)
    {
        HashMap<Integer,Vector<Node>> map= new HashMap<>();
        printDiagonalUtil(root,0,map);

        for(Map.Entry entry: map.entrySet())
        {
           Vector<Node> vector = (Vector<Node>)entry.getValue();
            for(Node n: vector)
            {
                System.out.print(n.data + "  ");
            }

            System.out.println();
        }
    }

    // Driver method
    public static void main(String[] args)
    {
        Diagonal tree = new Diagonal();
        tree.root = new Diagonal.Node(1);
        tree.root.left = new Diagonal.Node(2);
        tree.root.right = new Diagonal.Node(3);
        tree.root.left.left = new Diagonal.Node(4);
        tree.root.left.right = new Diagonal.Node(5);
        tree.root.left.right.right = new Diagonal.Node(9);
        tree.root.right.right = new Diagonal.Node(7);
        tree.printDiagonal(tree.root);
    }
}
