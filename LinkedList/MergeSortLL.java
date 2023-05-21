import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    Node getMiddle(Node node) {
        if (node == null) {
            return node;
        }

        Node slow = node;
        Node fast = node.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            linkedList.addNode(data);
        }

        System.out.println("Original Linked List:");
        linkedList.display();

        linkedList.head = linkedList.mergeSort(linkedList.head);

        System.out.println("Sorted Linked List:");
        linkedList.display();
    }
}
// SortList Leetcode 148 solution
// class Solution {
//     public ListNode sortList(ListNode head) {
//         if (head == null || head.next == null) {
//         return head;
//     }
//     // findMid
//     ListNode mid = getMid(head);
//     // left & right MS
//     ListNode rightHead = mid.next;
//     mid.next = null;
//     ListNode newLeft = sortList(head);
//     ListNode newRight = sortList(rightHead);
//     // merge
//     return merge(newLeft, newRight);
// }
//     private ListNode getMid(ListNode head){
//      //slow-fast approach
//      ListNode slow = head;
//      ListNode fast = head.next;
//      while(fast != null && fast.next != null) {
//          slow=slow.next; //+1
//          fast=fast.next.next; //+2
//      }
//      return slow; //mid Node of LL
//  }
//  private ListNode merge(ListNode head1, ListNode head2) {
//     ListNode mergedLL = new ListNode(-1);
//     ListNode temp = mergedLL;
//     while (head1 != null && head2 != null) {
//         if (head1.val <= head2.val) {
//             temp.next = head1;
//             head1 = head1.next;
//         } else {
//             temp.next = head2;
//             head2 = head2.next;
//         }
//         temp = temp.next;
//     }
//     if (head1 != null) {
//         temp.next = head1;
//     }
//     if (head2 != null) {
//         temp.next = head2;
//     }
//     return mergedLL.next;
// }
// } 
