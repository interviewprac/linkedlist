package com.rickito.prac;

public class PrintBoundaryTree {

    static  class Node{
        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data =data;
        }
    }

    Node root;
    public void printLeftMostNodes(Node root)
    {
        Node node =root;
        if(root ==null)
            return;

        else if(node.left!=null)
        {
            System.out.println(node.data);
            printLeftMostNodes(node.left);
        }

        else if(node.right!=null)
        {
            System.out.println(node.data);
            printLeftMostNodes(node.right);
        }
    }

    public void printLeafNodes(Node root)
    {
        Node node = root;

        if(node!=null)
        {
            printLeafNodes(node.left);
            if(node.left==null && node.right==null)
            {
                System.out.println(node.data);

            }
            printLeafNodes(node.right);

        }
           }

    public void printRightmostNodes(Node node)
    {
        if (node != null)
        {
            if (node.right != null)
            {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printRightmostNodes(node.right);
                System.out.print(node.data + " ");
            }
            else if (node.left != null)
            {
                printRightmostNodes(node.left);
                System.out.print(node.data + " ");
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }


    public void printBoundary(Node root)
    {
        printLeftMostNodes(root);

        printLeafNodes(root);
       // printLeafNodes(root.right);

        printRightmostNodes(root);
    }


    public static void main(String args[])
    {
        PrintBoundaryTree tree = new PrintBoundaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);

    }

    static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1) return false;
        if (n <= 3) return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }


    }
