package OldProblemSolutions;

/**
 * Created by Goki_PC on 2/28/2017.
 */

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinarySearchTree {
    public static Node root;

    public BinarySearchTree()
    {
        this.root = null;
    }

    public boolean find(int id)
    {
        Node current = root;
        while(current != null)
        {
            if(current.data == id)
                return true;
            else if(current.data > id)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }

    public boolean find(Node root, int id){
        Node current = root;
        if(root == null) return false;
        if(current.data == id) return true;
        if(current.data < id)
            return find(current.right, id);
        else
            return find(current.left, id);
    }

    public void insert(int val)
    {
        Node newNode = new Node(val);

        if(root == null)
        {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;
        while(true)
        {
            parent = current;
            if(val < current.data)
            {
                current = current.left;
                if(current == null)
                {
                    parent.left = newNode;
                    return;
                }
            }
            else
            {
                current = current.right;
                if(current == null)
                {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public boolean delete(int val)
    {
        Node parent = root;
        Node current = root;

        boolean isLeftChild = false;

        while(current.data != val)
        {
            parent = current;
            if(current.data > val)
            {
                isLeftChild = true;
                current = current.left;
            }
            else
            {
                isLeftChild = false;
                current = current.right;
            }
        }

        if(current == null)
        {
            return false;
        }

        if(current.left == null && current.right == null)
        {
            if(current == root)
            {
                root = null;
            }
            if(isLeftChild == true)
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
        }else if(current.right == null)
        {
            if(current == root)
            {
                root = current.left;
            }else if(isLeftChild)
            {
                parent.left = current.left;
            }
            else
            {
                parent.right = current.left;
            }
        }
        else if(current.left == null)
        {
            if(current == root)
            {
                root = current.right;
            }
            else if(isLeftChild)
            {
                parent.left = current.right;
            }
            else
            {
                parent.right = current.right;
            }
        }
        else if(current.left != null && current.right != null)
        {
            Node sucsr = getSuccessor(current);

            if(current == root)
            {
                root = sucsr;
            }else if(isLeftChild)
            {
                parent.left = sucsr;
            }
            else
            {
                parent.right = sucsr;
            }

            sucsr.left = current.left;
        }

        return true;
    }

    public Node getSuccessor(Node deleteNode)
    {
        Node sucr = null;
        Node sucrPrnt = null;
        Node current = deleteNode.right;

        while(current != null)
        {
            sucrPrnt = sucr;
            sucr = current;
            current = current.left;
        }

        if(sucr != deleteNode.right)
        {
            sucrPrnt.left = sucr.right;
            sucr.right = deleteNode.right;
        }
        return sucr;
    }

}
