import java.util.EmptyStackException;

// Public class MyStack of generic type T
public class MyStack<T> {
    // StackNode class inherits generic type T
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T item) {
            this.data = item;
        }
    }
    
    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        StackNode<T> item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }



    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        Integer i1 = Integer.valueOf(1);
        Integer i2 = Integer.valueOf(2);
        Integer i3 = Integer.valueOf(3);
        stack.push(i1);
        stack.push(i2);
        stack.push(i3);

        System.out.println(stack.peek());
    }

}