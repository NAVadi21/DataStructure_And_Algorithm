import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node head;
    Node tail;

    boolean isEmpty() {
        return head == null && tail == null;
    }

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int front = head.data;
        if (tail == head) {
            tail = head = null;
        } else {
            head = head.next;
        }
        return front;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return head.data;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data to enqueue: ");
                    int data = scanner.nextInt();
                    queue.enqueue(data);
                    System.out.println("Data enqueued successfully.");
                    break;
                case 2:
                    int dequeuedData = queue.dequeue();
                    if (dequeuedData != -1) {
                        System.out.println("Dequeued data: " + dequeuedData);
                    }
                    break;
                case 3:
                    int frontData = queue.peek();
                    if (frontData != -1) {
                        System.out.println("Front data: " + frontData);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
    }
}
