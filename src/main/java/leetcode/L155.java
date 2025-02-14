package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class L155 {

    public static class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
            this.minStack.push(Integer.MAX_VALUE);
        }

        public void push(int v) {
            stack.push(v);
            minStack.push(Math.min(v, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public Integer top() {
            return stack.peek();
        }

        public Integer getMin() {
            return minStack.peek();
        }

    }
}
