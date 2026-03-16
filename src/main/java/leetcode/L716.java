package leetcode;

import java.util.List;
import java.util.TreeMap;

public class L716 {
    
    class MaxStack {

        class Node {
            int value;
            Node prev, next;
            Node(int value) {
                this.value = value;
            }
        }
        class DoubleLinkedList {
            Node head, tail;
            DoubleLinkedList() {
                head = new Node(0);
                tail = new Node(0);
                head.next = tail;
                tail.prev = head;
            }

            Node add(int x) {
                Node node = new Node(x);
                node.prev = tail.prev;
                node.next = tail;
                tail.prev.next = node;
                tail.prev = node;
                return node;
            }

            int remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return node.value;
            }

            Node peek() {
                return tail.prev;
            }
            
            int pop() {
                return remove(peek());
            }
        }

        private DoubleLinkedList dll;
        private TreeMap<Integer, List<Node>> map;

        public MaxStack() {
            dll = new DoubleLinkedList();
            map = new TreeMap<>();
        }

        public void push(int x) {
            Node node = dll.add(x);
            map.computeIfAbsent(x, k -> new java.util.ArrayList<>()).add(node);
        }

        public int pop() {
            int val = dll.pop();
            List<Node> nodes = map.get(val);
            nodes.remove(nodes.size() - 1);
            if (nodes.isEmpty()) {
                map.remove(val);
            }
            return val;
        }

        public int top() {
            return dll.peek().value;
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int maxVal = peekMax();
            List<Node> nodes = map.get(maxVal);
            Node node = nodes.remove(nodes.size() - 1);
            if (nodes.isEmpty()) {
                map.remove(maxVal);
            }
            dll.remove(node);
            return maxVal;
        }
    }

    // generate test case
    public static void main(String[] args) {
        MaxStack maxStack = new L716().new MaxStack();
        maxStack.push(5);
        maxStack.push(1);


        System.out.println(maxStack.popMax()); // 5
        System.out.println(maxStack.peekMax()); // 5

    }
}
