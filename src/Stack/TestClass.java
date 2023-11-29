package Stack;

import Queue.Queue;

public class TestClass {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        fillStack(stack);
        printStack(stack);

        String input = "2*[5*(2-3)(9+4)]";
        Stack<Character> bracketStack = new Stack<Character>();
        System.out.println(isValid(input, bracketStack));
    }
    public static void fillStack(Stack<Integer> pStack) {
        for (int i = 0; i < 25; i++) {
            double rand = Math.random() * 10000;
            pStack.push((int) rand);
        }
    }
    public static int findLargest(Stack<Integer> pStack) {
        if (pStack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int top = pStack.top();
        pStack.pop();
        System.out.println("pop");
        int valueFromStack = findLargest(pStack);
        int max;
        if(top > valueFromStack){  // ist das gleiche wie int max = Math.max(top, findLargest(pStack));
            max = top;
        }else{
            max = valueFromStack;
        }
        pStack.push(top);
        return max;
    }
    public static boolean isValid(String input, Stack<Character> pStack) {
        if (input.isEmpty()) return pStack.isEmpty();

        char c = input.charAt(0);
        String remaining = input.substring(1);

        if (c == '(' || c == '[' || c == '{') {
            pStack.push(c);
        } else if (c == ')' || c == ']' || c == '}') {
            if (pStack.isEmpty()) {
                return false;
            }
            char top = pStack.top();
            pStack.pop();
            if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                return false;
            }
        }

        return isValid(remaining, pStack);
    }
    public static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("\n");
            return;
        }
        int top = stack.top();
        stack.pop();
        System.out.print(top);
        printStack(stack);
        stack.push(top);
    }
}
