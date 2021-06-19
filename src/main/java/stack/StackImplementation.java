package stack;

public class StackImplementation {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (!stack.isStackEmpty()) {
            int value = stack.pop();
            System.out.println(value);
        }
        stack.pop();
    }
}

class Stack<T> {
    private Object[] stackArray;
    private int maxSize, maxIndex;

    Stack(int size) {
        this.maxSize = size;
        stackArray = new Object[size];
        this.maxIndex = -1; //first item "0" if "-1" so it's empty
    }

    public void push(Object item) {
        if (!isStackFull()) {
            maxIndex = maxIndex+1;
            stackArray[maxIndex] = item;
        } else {
            System.out.println("Stack is full!");
        }
    }

    // to prevent out of bound exception
    public boolean isStackFull() { return (maxIndex == maxSize-1); }

    public T pop() {
        if (isStackEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        T item = (T) stackArray[maxIndex];
        maxIndex = maxIndex - 1;
        return item;
    }

    public boolean isStackEmpty() { return maxIndex == -1; }
}
