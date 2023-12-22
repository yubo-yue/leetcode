package ms;


public class T1 {
    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node addTwoNums(Node a, Node b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        Node r1 = reverse(a);
        Node r2 = reverse(b);
        int carry = 0;
        Node r = new Node(-1);
        Node p = r;
        while (r1 != null && r2 != null) {
            int sum = r1.val + r2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            p.next = new Node(sum);
            p = p.next;
            r1 = r1.next;
            r2 = r2.next;
        }

        if (r1 == null) {
            while (r2 != null) {
                int sum = r2.val + carry;
                carry = sum / 10;
                sum = sum % 10;
                p.next = new Node(sum);
                p = p.next;
                r2 = r2.next;
            }
        }

        if (r2 == null) {
            while (r1 != null) {
                int sum = r1.val + carry;
                carry = sum / 10;
                sum = sum % 10;
                p.next = new Node(sum);
                p = p.next;
                r1 = r1.next;
            }
        }

        if (carry > 0) {
            p = new Node(carry);
        }

        return reverse(r.next);

    }

    private Node reverse(Node node) {
        Node p = node;
        if (node.next == null) {
            return node;
        }

        Node r = reverse(node.next);
        p.next.next = p;
        p.next = null;
        return r;
    }
}
