package tuanhiep.usa.algo.others;

import tuanhiep.usa.common.abstractAlgo;

import java.util.PriorityQueue;
import java.util.Stack;

public class QueueFromStacks extends abstractAlgo {
    @Override
    public void setUpDefault() {

    }

    @Override
    public void run() {

    }

    @Override
    public Object getResult() {
        return null;
    }

    @Override
    public void print() {

    }

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> reversedStack = new Stack<>();

    public void add(int element) {
        stack.push(element);
    }

    public int poll() {
        shiftStack();
        return reversedStack.pop();

    }

    public int peek() {
        shiftStack();
        return reversedStack.peek();

    }

    private void shiftStack() {
        if (reversedStack.isEmpty()) {
            while (!stack.isEmpty()) {
                reversedStack.add(stack.pop());
            }
        }


    }


}
