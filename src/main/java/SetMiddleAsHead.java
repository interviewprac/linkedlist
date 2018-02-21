
public class SetMiddleAsHead {

    public static class Node{

        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    public static void setMiddle()
    {
        Node oneNext =head;
        Node prev=head;
        Node twoNext =head;

        while(twoNext!=null && twoNext.next!=null)
        {
            prev = oneNext;
            oneNext = oneNext.next;
            twoNext = twoNext.next.next;

        }
        prev.next = oneNext.next;
        oneNext.next =head;
        head = oneNext;
    }


    // To insert a node at the beginning of
    // linked list.
    static void push(int new_data)
    {
        /* allocate node */
        Node new_node = new Node(new_data);

        /* link the old list off the new node */
        new_node.next = head;

        /* move the head to point to the new node */
        head = new_node;
    }

    public static void printLinkedList(Node head)
    {
        Node p = head;
        while(p!= null)
        {
            System.out.println(p.data + " ");
            p = p.next;
        }
    }

    public  static  void main(String args[])
    {
        // Create a list of 5 nodes
        head = null;
        int i;
        for (i = 5; i > 0; i--)
            push(i);

        System.out.print(" list before: ");
        printLinkedList(head);

        setMiddle();

        System.out.print(" list After:  ");
        printLinkedList(head);
    }
}
