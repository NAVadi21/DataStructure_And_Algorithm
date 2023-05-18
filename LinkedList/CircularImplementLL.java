public class CircularLinkedList {
    private Node head; // Head node of the circular linked list
    
    // Node class
    private static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Method to check if the circular linked list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Method to insert a node at the beginning of the circular linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            head = newNode;
            newNode.next = head; // Point back to itself since it's the only node
        } else {
            Node last = head;
            
            while (last.next != head) {
                last = last.next;
            }
            
            newNode.next = head; // Point to the current head
            head = newNode; // Update head
            last.next = head; // Make last node point to the new head
        }
        
        System.out.println("Inserted element " + data + " at the beginning.");
    }
    
    // Method to insert a node at the end of the circular linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            head = newNode;
            newNode.next = head; // Point back to itself since it's the only node
        } else {
            Node last = head;
            
            while (last.next != head) {
                last = last.next;
            }
            
            last.next = newNode; // Make the last node point to the new node
            newNode.next = head; // Make the new node point back to head
        }
        
        System.out.println("Inserted element " + data + " at the end.");
    }
    
    // Method to delete the first node of the circular linked list
    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("Circular linked list is empty. Unable to delete.");
            return;
        }
        
        Node last = head;
        
        while (last.next != head) {
            last = last.next;
        }
        
        if (head == last) { // Only one node in the list
            head = null;
        } else {
            head = head.next; // Move head to the next node
            last.next = head; // Make the last node point to the new head
        }
        
        System.out.println("Deleted the first element.");
    }
    
    // Method to display the elements of the circular linked list
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular linked list is empty.");
            return;
        }
        
        Node current = head;
        
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        
        circularLinkedList.insertAtBeginning(10);
        circularLinkedList.insertAtEnd(20);
        circularLinkedList.insertAtEnd(30);
        circularLinkedList.display();
        
        circularLinkedList.deleteFirst();
        circularLinkedList.display();
        
        circularLinkedList.deleteFirst();
        circularLinkedList.display();
        
        circularLinkedList.deleteFirst();
        circularLinkedList.display();
    }
}
