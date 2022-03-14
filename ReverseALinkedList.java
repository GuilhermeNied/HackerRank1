import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class ListN {
        public int data;
        public ListN next;

        public ListN(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class LinkList {
        public ListN head;
        public ListN tail;

        public LinkList() {
            this.head = null;
            this.tail = null;
        }

        public void insert(int nodeData) {
            ListN node = new ListN(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printList(ListN node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static ListN reverse(ListN head) {
        ListN t = head;
        Stack<Integer> x = new Stack<>();
        while(t != null){
            x.push(t.data);
            t = t.next;
        }
        t = head;
        while(t != null){
            t.data = x.pop();
            t = t.next;
        }
        return head;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            LinkList llist = new LinkList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insert(llistItem);
            }

            ListN llist1 = reverse(llist.head);

            printList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
