package com.rickito.prac;

public class TreeTraversal {

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

    public void mirror(Node node)
    {
        if(node ==null)
            return;

        Node leftTemp = node.left;
        node.left = node.right;
        node.right =leftTemp;
        mirror(node.left);
        mirror(node.right);
    }
    public void preorder(Node node)
    {
        if(node ==null)
            return;

        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);

    }

    public void inorder(Node node)
    {
        if(node ==null)
            return;

        inorder(node.left);
        System.out.println(node.data);

        inorder(node.right);

    }
    // Driver method
    public static void main(String[] args)
    {
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.preorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.inorder(tree.root);

       tree.mirror(tree.root);
        System.out.println("==============================");
       tree.inorder(tree.root);
    }
}
