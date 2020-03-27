package mycode.offersword;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author pan
 * @create 2019-11-21-16:20
 */
public class QueueWhitStack {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        QueueWhitStack.push(1);
        QueueWhitStack.push(2);
        QueueWhitStack.push(3);
        QueueWhitStack.push(4);
        try {
            System.out.println(QueueWhitStack.pop());
            System.out.println(QueueWhitStack.pop());
            System.out.println(QueueWhitStack.pop());
            System.out.println(QueueWhitStack.pop());
            System.out.println(QueueWhitStack.pop());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static int pop() throws Exception {
        if (stack1.empty()) {
            throw new Exception("队列为空");
        }
        int result = 0;
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        result = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void push(int i) {
        stack1.push(i);
    }
}
