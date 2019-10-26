package tuanhiep.usa.algo.cracking;

import java.util.Stack;

public class QueueFromStacks {
    public static void main(String[] args) {

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

    /**
     * Move all element from newest on top stack to oldest(reversedStack) on top stack while reversedStack is empty
     */
    private void shiftStack() {
        if (reversedStack.isEmpty()) {
            while (!stack.isEmpty()) {
                reversedStack.add(stack.pop());
            }
        }


    }


}
