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


    public static ListN removeDuplicates(ListN llist) {

        ListN temp = llist;

        while (temp.next != null) {
            if (temp.data == temp.next.data) {

                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return llist;
    }

    class Result {

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            List list = new List();

            int listC = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < listC; i++) {
                int listI= scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                list.insert(listI);
            }

            ListN Otherlist = removeDuplicates(list.head);

            printList(Otherlist, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
