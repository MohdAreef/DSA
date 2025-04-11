/*
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should 
be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
*/

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        pushAll(root);

    }

    public int next() {

        TreeNode temp = stack.pop();
        pushAll(temp.right);

        return temp.val;

    }

    public boolean hasNext() {

        return !stack.isEmpty();

    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    
// Another Solution
class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int nextpointer = -1, size = 0;

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);

    }

    public BSTIterator(TreeNode root) {
        inorder(root);

        size = list.size();

    }

    public int next() {
        nextpointer++;
        return list.get(nextpointer);

    }

    public boolean hasNext() {

        if (nextpointer + 1 < size)
            return true;
        return false;

    }
}
