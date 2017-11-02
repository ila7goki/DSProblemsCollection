package LinkedLists;

/**
 * Created by Goki_PC on 10/25/2017.
 */
public class Node {

    int data;
    Node next = null;

    public Node(int data)
    {
        this.data = data;
    }

    public int getData()
    {
        return this.data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext()
    {
        return this.next;
    }


}
