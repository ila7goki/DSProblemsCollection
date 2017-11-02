package OldProblemSolutions;

import java.util.Hashtable;

/**
 * Created by Goki_PC on 3/9/2017.
 */


public class LinkedLists {

    private Node head;
    private int length;

    public LinkedLists()
    {
        head = null;
        length = 0;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public int getLength()
    {
        return length;
    }

    public Node insertAtStart(int val)
    {
        Node newHead = new Node(val);
        if(head != null)
            newHead.setNext(head);

        head = newHead;
        length++;
        return head;
    }

    public Node insertAtEnd(int val)
    {
        Node newNode = new Node(val);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            Node currentNode = head;
            while(currentNode.next != null)
            {
                currentNode = currentNode.next;
            }
            currentNode.setNext(newNode);
        }
        length++;
        return head;
    }

    public void insertAtPos(int val, int pos)
    {
        Node newNode = new Node(val);
        Node currentNode = head;
        int currPos = 1;
        while(currentNode.next != null && currPos < pos-1)
        {
            currentNode = currentNode.next;
            currPos++;
        }
        newNode.setNext(currentNode.next);
        currentNode.setNext(newNode);
        length ++;
    }

    public void display()
    {
        if(length == 0)
        {
            System.out.println("Empty list");
            return;
        }
        if(head.getNext() == null)
        {
            System.out.println(head.getData());
            return;
        }
        Node currentNode = head;
        System.out.print(head.getData() + "->");
        //currentNode = currentNode.next;
        while(currentNode.next != null)
        {
            //System.out.println(currentNode.getData() + "->");
            currentNode = currentNode.next;
            System.out.print(currentNode.getData() + "->");
        }
        System.out.println("\n");
    }

    public void deleteDups(Node head) {
        Hashtable flags = new Hashtable();
        Node current = head.next;
        Node prev = head;
        flags.put(head.data, true);
        while (current != null) {
            if (flags.containsKey(current.data)) {
                prev.next = current.next;
                current = current.next;
                this.length--;
            } else {
                flags.put(current.data, true);
                prev = prev.next;
                current = current.next;
            }
        }
    }

    public void deleteDupsWithoutStorage(Node head)
    {
        Node current = head.next;
        Node prev = head;

        while(current != null)
        {
            Node n = head;
            while(n != current)
            {
                if(n.data == current.data)
                {
                    Node temp = current.next;
                    prev.next = temp;
                    current = temp;
                    break;
                }
                n = n.next;
            }

            if(n == current) {
                prev = current;
                current = current.next;
            }
        }
    }

    public int findNthLast(Node head, int n)
    {
        if(head == null || n > this.length || n < 1)
        {
            return 0;
        }

        Node start = head;
        Node nthAfterStart = head;

        for(int i = 0; i < n-1; i++)
        {
            nthAfterStart = nthAfterStart.next;
        }

        while(nthAfterStart.next != null)
        {
            start = start.next;
            nthAfterStart = nthAfterStart.next;
        }
       return start.data;
    }

    public Node addTwoLists(Node first, Node second)
    {
        Node result = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        while(first != null || second != null)
        {
            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            System.out.println((first != null ? first.data : 0) + " + " + (second != null ? second.data : 0) + "= " + sum + ", " + carry);
            temp = new Node(sum);

            if(result == null)
            {
                result = temp;
            }
            else
            {
                prev.next = temp;
            }
            prev = temp;

            if(first != null)
            {
                first = first.next;
            }
            if(second != null)
            {
                second = second.next;
            }

            if(carry > 0)
            {
                temp.next = new Node(carry);
            }
        }
        return result;
    }

    // OldProblemSolutions.Node class
    private class Node
    {
        Integer data;
        Node next;

        public Node(Integer data)
        {
            this.data = data;
            this.next = null;
        }

        public Node(Integer data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        public Integer getData()
        {
            return this.data;
        }

        public void setData(Integer data)
        {
            this.data = data;
        }

        public Node getNext()
        {
            return this.next;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }
    }

    public static void main(String[] args)
    {
        LinkedLists list = new LinkedLists();
        list.insertAtStart(2);
        list.insertAtStart(7);
        list.insertAtEnd(9);
        list.insertAtStart(9);
        list.insertAtStart(6);
        list.insertAtPos(12,5);
        list.insertAtEnd(7);
        list.insertAtEnd(7);
        list.insertAtEnd(6);
        list.display();
        list.deleteDups(list.head);
        list.deleteDupsWithoutStorage(list.head);
        list.display();
        LinkedLists list1 = new LinkedLists();
        list1.insertAtStart(7);
        list1.insertAtEnd(5);
        list1.insertAtEnd(9);
        list1.insertAtEnd(4);
        list1.insertAtEnd(6);
        list1.display();

        LinkedLists list2 = new LinkedLists();
        list2.insertAtEnd(8);
        list2.insertAtEnd(4);
        list2.display();

        Node result = list1.addTwoLists(list1.head, list2.head);
        while(result != null) {
            System.out.print(result.data + "->");
            result = result.next;
        }
        //System.out.println(list.getLength());
        System.out.print(list.findNthLast(list.head, 4));
    }

}
