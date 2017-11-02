package Trees;

/**
 * Created by Goki_PC on 10/31/2017.
 */
public class TreeTraversals {

    TreeNode root;

    public TreeTraversals()
    {
        this.root = null;
    }

    private void inOrderTraversal(TreeNode root)
    {
        if(root != null)
        {
            inOrderTraversal(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrderTraversal(root.getRight());
        }
    }

    private void postOrderTraversal(TreeNode root)
    {
        if(root != null)
        {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            System.out.print(root.getValue() + " ");
        }
    }

    private void preOrderTraversal(TreeNode root)
    {
        if(root != null)
        {
            System.out.print(root.getValue() + " ");
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
        }
    }

    public void inOrderTraversal()
    {
        inOrderTraversal(this.root);
    }

    public void preOrderTraversal()
    {
        preOrderTraversal(this.root);
    }

    public void postOrderTraversal()
    {
        postOrderTraversal(this.root);
    }

    public static void main(String[] args)
    {
        TreeTraversals tree = new TreeTraversals();
        tree.root = new TreeNode(7);
        tree.root.setLeft(new TreeNode(5));
        tree.root.setRight(new TreeNode(6));
        tree.root.left.setLeft(new TreeNode(3));
        tree.root.left.setRight(new TreeNode(9));
        tree.root.right.setLeft(new TreeNode(2));
        tree.root.right.setRight(new TreeNode(4));

        tree.inOrderTraversal();
        System.out.print("\n");
        tree.preOrderTraversal();
        System.out.print("\n");
        tree.postOrderTraversal();
    }
}
