package LintCode.Binary.Tree;

/**
 * Created by Administrator on 2017/6/17.
 */
//Definition for Doubly-ListNode.
class DoublyListNode {
      int val;
      DoublyListNode next, prev;
      DoublyListNode(int val) {
          this.val = val;
          this.next = this.prev = null;
      }
}
public class Tree378ConvertBinarySearchTreeToDoublyLinkedList {
    /**
     * 比较慢的recursion
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        DoublyListNode dln = new DoublyListNode(root.val);

        if (root.left != null) {
            DoublyListNode tmpp = bstToDoublyList(root.left);
            while (tmpp.next != null) {
                tmpp = tmpp.next;
            }
            tmpp.next = dln;
            dln.prev = tmpp;
        }
        if (root.right != null) {
            DoublyListNode tmp = bstToDoublyList(root.right);
            dln.next = tmp;
            tmp.prev = dln;
        }
        while (dln.prev != null) {
            dln = dln.prev;
        }
        return dln;
    }
}