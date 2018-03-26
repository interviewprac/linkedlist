package com.rickito.prac;

public class Diameter {

    Node root;
    static class Node{

        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data = data;
        }
    }

    public int diameter(Node node)
    {
        if(node == null)
            return 0;

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        int leftDiameter = diameter(node.left);
        int rightDiameter = diameter(node.right);

        return Math.max(leftDiameter, Math.max(rightDiameter, (leftHeight+ rightHeight+1)));
    }

    public int findHeight(Node node)
    {
        if(node==null)
        {
            return  0;
        }

        int lh =findHeight(node.left);
        int rh = findHeight(node.right);

        return Math.max(lh,rh)+1;
    }

    // Driver method
    public static void main(String[] args)
    {
        Diameter tree = new Diameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(9);
        tree.root.right.right = new Node(7);
        System.out.println(tree.diameter(tree.root));
    }

}
