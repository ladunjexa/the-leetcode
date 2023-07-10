/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node node = head, copiedNode = new Node(node.val), pointerNode = copiedNode;

        map.put(node, pointerNode);

        while(node.next != null) {
            node = node.next;
            pointerNode.next = new Node(node.val);
            pointerNode = pointerNode.next;
            map.put(node, pointerNode);
        }

        node = head;
        pointerNode = copiedNode;

        while(node != null) {
            pointerNode.random = map.get(node.random);
            pointerNode = pointerNode.next;
            node = node.next;
        }

        return copiedNode;
    }
}
