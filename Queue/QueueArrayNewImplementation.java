public class Queue {
    private int maxSize; // Maximum size of the queue
    private int[] queueArray; // Array to store queue elements
    private int front; // Index of the front element
    private int rear; // Index of the rear element
    private int currentSize; // Current number of elements in the queue
    
    public Queue(int capacity) {
        maxSize = capacity;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public boolean isFull() {
        return currentSize == maxSize;
    }
    
    public int size() {
        return currentSize;
    }
    
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Unable to enqueue element: " + data);
            return;
        }
        
        rear = (rear + 1) % maxSize; // Circular increment of rear index
        queueArray[rear] = data;
        currentSize++;
        
        System.out.println("Enqueued element: " + data);
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Unable to dequeue element.");
            return -1;
        }
        
        int dequeuedElement = queueArray[front];
        front = (front + 1) % maxSize; // Circular increment of front index
        currentSize--;
        
        return dequeuedElement;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Unable to peek element.");
            return -1;
        }
        
        return queueArray[front];
    }
    
    public static void main(String[] args) {
        Queue queue = new Queue(5); // Create a queue of capacity 5
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        
        int dequeuedElement = queue.dequeue();
        System.out.println("Dequeued element: " + dequeuedElement);
        
        queue.enqueue(50);
        
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        
        while (!queue.isEmpty()) {
            dequeuedElement = queue.dequeue();
            System.out.println("Dequeued element: " + dequeuedElement);
        }
        
        System.out.println("Queue size: " + queue.size());
    }
}
