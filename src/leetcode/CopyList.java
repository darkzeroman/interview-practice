package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyList {
    public static void main(String[] args) {
        RandomListNode r = new RandomListNode(1);
        r.orig = true;
        new CopyList().copyRandomList(r);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode newHead = null;
        RandomListNode newTail = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode currNode = head;
        while (currNode != null) {
            RandomListNode n = new RandomListNode(currNode.label);
            n.random = currNode.random;
            if (newHead == null) {
                newHead = n;
                newTail = n;
            } else {
                newTail.next = n;
                newTail = n;

            }
            map.put(currNode, n);
            currNode = currNode.next;
        }

        RandomListNode h = newHead;
        while (h != null) {
            h.random = map.get(h.random);
            h = h.next;
        }

        return newHead;
    }

    private static class RandomListNode {
        RandomListNode next, random;
        int label;
        boolean orig = false;

        public RandomListNode(int label) {
            this.label = label;
        }

    }
}
