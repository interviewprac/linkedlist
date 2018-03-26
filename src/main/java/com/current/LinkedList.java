package com.current;

// Java program to reverse a linked list in groups of
// given size
class LinkedList {
    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    static Node mergeSort(Node h) {

        if (h == null || h.next == null) {
            return h;
        }


        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;

        middle.next = null;


        Node left = mergeSort(h);


        Node right = mergeSort(nextofmiddle);
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    static Node getMiddle(Node h) {

        //Base case
        if (h == null)
            return h;
        Node fastptr = h.next;
        Node slowptr = h;


        while (fastptr != null) {
            fastptr = fastptr.next;
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        return slowptr;
    }

    static Node sortedMerge(Node a, Node b) {
        Node result = null;

        if (a == null)
            return b;
        if (b == null)
            return a;


        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;

    }

    static Node sort(int k, Node list) {
        Node end = list;
        for (int i = 0; i < k - 1 && end.next != null; i++) {
            end = end.next; // get end of first group
        }
        if (end.next == null) {
            return mergeSort(list); // if last group, sort and return
        }

        Node rest = sort(k, end.next); // sort rest of list
        end.next = null; // split first group from list
        list = mergeSort(list); // sort first group

        end = list;
        while (end.next != null) {
            end = end.next; // get end of sorted first group
        }
        end.next = rest; // rejoin sorted rest of list to sorted first group

        return list;
    }

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Function to print linked list */
    void print(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        LinkedList llist = new LinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(19);
        llist.push(81);
        llist.push(7);
        llist.push(36);
        llist.push(522);
        llist.push(42);
        llist.push(332);
        llist.push(22);
        llist.push(111);

        System.out.println("Given Linked List");
        llist.printList();

        //llist.head = llist.reverse(llist.head, 3);

        //System.out.println("Reversed list");
        //llist.printList();

        Node head = llist.head;
        Node temp = LinkedList.sort(3, head);
        System.out.println("Sorted List ");
        llist.printList();
        System.out.println(temp.data);
        llist.print(temp);
    }
}