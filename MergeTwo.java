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

    static class List {
        public ListN head;
        public ListN tail;

        public List() {
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


    static ListN mergeLists(ListN head1, ListN head2) {
        if(head1==null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        ListN t1 = head1, t2 = head2;
        ListN head = null, tail = null;
        if(t1.data<=t2.data) {
            head = t1;
            tail = t1;
            t1= t1.next;
        } else {
            head = t2;
            tail = t2;
            t2 =  t2.next;
        }
        while(t1!=null && t2!=null) {
            if(t1.data<=t2.data) {
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }

        }
        if(t1!=null) {
            tail.next = t1;
        } else {
            tail.next = t2;
        }
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int test = 0; test < tests; test++) {
            List list1 = new List();

            int list1C = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < list1C; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                list1.insert(llist1Item);
            }

            List list2 = new List();

            int list2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < list2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                list2.insert(llist2Item);
            }

            ListN list3 = mergeLists(list1.head, list2.head);

            printList(list3, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
