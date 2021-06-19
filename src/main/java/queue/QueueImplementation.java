package queue;

public class QueueImplementation {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.print();
        queue.enqueue(6);
        System.out.println("Dequeue : " + queue.dequeue());
        System.out.println("Dequeue : " + queue.dequeue());
        queue.print();
        queue.enqueue(6);
        System.out.println("Dequeue : " + queue.dequeue());
        queue.print();
    }
}

class Queue<T> {

    Object[] queue;
    int front, rear, capacity, currentSize;

    public Queue(int size) {
        queue = new Object[size];
        this.capacity = size;
        front = currentSize = 0;
        rear = -1;
    }

    public void enqueue(Object object) {
        if(isFull(this)) {
            System.out.println("Queue is full!");
            return;
        }
        rear++;
        queue[rear] = object;
        currentSize++;
    }

    boolean isFull(Queue queue) {
        return (queue.capacity == queue.currentSize);
    }

    public T dequeue() {
        if (isEmpty(this)) {
            System.out.println("Queue is empty!");
            return null;
        }
        T object = (T) queue[front];
        for (int i=1; i < currentSize; i++) {
            queue[i-1] = (T) queue[i];
        }
        queue[rear] = null;
        currentSize--;
        rear--;
        return object;
    }

    boolean isEmpty(Queue queue) {
        return (queue.currentSize == 0);
    }

    public void print() {
        for (int i=0; i<currentSize; i++) {
            System.out.println(queue[i]);
        }
    }
}