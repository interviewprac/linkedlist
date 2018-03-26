package com.rickito.prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PrintDiagonally {

    static class Node{

        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data = data;
        }
    }

    Node root;

    public void printDiagonally(Node node)
    {

        HashMap<Integer, Vector<Node>> map= new HashMap<Integer,Vector<Node>>();
        printDiagonal(node, 0, map);
        for (Map.Entry<Integer,Vector<Node>> entry: map.entrySet())
        {
         for(Node nodeTemp: entry.getValue())
         {
             System.out.print(nodeTemp.data);
         }
            System.out.println();

    }
    }

    public void printDiagonal(Node node, int dist, HashMap<Integer,Vector<Node>> map)
    {
        Vector<Node> nodes = map.get(dist);

        if (node == null)
            return;

        if(nodes == null)
        {
            nodes = new Vector<>();
            nodes.add(node);
           }

        else
        {
            nodes.add(node);
            }
        map.put(dist,nodes);

        printDiagonal(node.left, dist+1, map);
        printDiagonal(node.right, dist, map);
    }

    // Driver method
    public static void main(String[] args)
    {
        PrintDiagonally tree = new PrintDiagonally();
        tree.root = new PrintDiagonally.Node(1);
        tree.root.left = new PrintDiagonally.Node(2);
        tree.root.right = new PrintDiagonally.Node(3);
        tree.root.left.left = new PrintDiagonally.Node(4);
        tree.root.left.right = new PrintDiagonally.Node(5);
        tree.root.left.right.right = new PrintDiagonally.Node(9);
        tree.root.right.right = new PrintDiagonally.Node(7);
        tree.printDiagonally(tree.root);
    }
}
