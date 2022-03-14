import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class LinkList {
        public ListNode head;

        public LinkList() {
            this.head = null;
        }


    }

    public static void printSinglyLinkedList(ListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }


    static ListNode insertNodeAtTail(ListNode head, int data) {
        ListNode temp = head;
        if(temp == null){
            head = new ListNode(data);
            return head;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new ListNode(data);
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        LinkList list = new LinkList();

        int listC = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < listC; i++) {
            int listI= scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            ListNode listH = insertNodeAtTail(list.head, listI);

            list.head = listH;
        }



        printSinglyLinkedList(list.head, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
