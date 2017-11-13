package LinkedLists;

/**
 * Created by Goki_PC on 10/26/2017.
 */
public class LinkedListProblems {

    private static LinkedList list = new LinkedList();

    private static void populateList()
    {
        list.appendToEnd(4);
        list.appendToEnd(4);
        list.appendToEnd(6);
        list.appendToEnd(6);
        list.appendToEnd(192);
        list.appendToEnd(12);
        list.appendToEnd(24);
        list.appendToEnd(4);
    }

    private static void printList()
    {
        for (int i : list)
        {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    private static void removeDuplicates()
    {
        //list.removeDuplicatesWithoutBuffer();
        list.removeDuplicatesWithBuffer();
    }

    public static void main(String[] args)
    {
        populateList();
        printList();
        removeDuplicates();
        printList();
        list.getKthToLastRecursive(list.head, 0);
        System.out.println("--" + list.getKthToLastIterative(0));
    }
}
