package LinkedLists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Goki_PC on 10/25/2017.
 */
public class LinkedList implements Iterable<Integer>
{
    public Node head;
    public int length;

    public LinkedList()
    {
        head = null;
        length = 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node nextNode = head;
            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                Integer result = nextNode.getData();
                nextNode = nextNode.getNext();

                return result;
            }
        };
    }

    public int getHeadVal()
    {
        return this.head.getData();
    }

    public void appendToEnd(int value)
    {
        Node end = new Node(value);
        Node n = this.head;

        if(head == null)
        {
            head = end;
        }
        else
        {
            while(n.next != null)
            {
                n = n.next;
            }
            n.next = end;
            this.length++;
        }
    }

    public void removeDuplicatesWithBuffer()
    {
        Node current = head;
        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        while(current != null)
        {
            if(set.contains(current.getData()))
            {
                prev.next = current.getNext();
            }
            else
            {
                set.add(current.getData());
              //  System.out.println(current.getData());
                prev = current;
            }
            current = current.getNext();
        }

    }

    public void removeDuplicatesWithoutBuffer()
    {
        Node current = head;
        while(current != null)
        {
            Node runner = current;
            while(runner.getNext() != null)
            {
                if(runner.getNext().getData() == current.getData())
                {
                    System.out.println("Runner next: " + runner.getNext().getData());
                    System.out.println("Current Data: " + current.getData());
                    runner.next = runner.next.next;
                }
                else
                {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }
}
