package com.rickito.prac;


import java.util.ArrayList;

public class Test {
    public static void main(String args[] ) {

        //first create tree
        Node rootNode = new Node ('A' , new Node('B',null,
                new Node('D',
                        new Node('K',
                                new Node('Z',null,
                                        null),null),
                        new Node('L',null,null))),
                new Node('C',
                        new Node('E',
                                null,
                                new Node('M',null,null)),null) );

        ArrayList <Node> path = new ArrayList<Node>();
        System.out.println(getPath(rootNode,'Z',path));
        System.out.println(path);
        path = new ArrayList<Node>();
        System.out.println(getPath(rootNode,'M',path));
        System.out.println(path);

    }
    static boolean getPath(Node rootNode, char key, ArrayList<Node> path ){
        //return true if the node is found
        if( rootNode==null)
            return false;
        if (rootNode.getdata()==key){
            path.add(rootNode);
            return true;
        }
        boolean left_check = getPath( rootNode.left,key,path);
        boolean right_check = getPath( rootNode.right,key,path);
        if ( left_check || right_check){
            path.add(rootNode);
            return true;
        }
        return false;

    }
    static class Node {
        char data;
        Node left;
        Node right;
        public Node( char data, Node left, Node right){
            this.left=left;
            this.right=right;
            this.data=data;
        }
        public char getdata(){
            return data;
        }
        public String toString(){
            return " " + data + " ";
        }
    }

}
