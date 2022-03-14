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




    static int get(ListN head, int positionFromTail) {

        ListN fast = head;
        ListN slow = head;

        int pos = 0;
        while (pos < positionFromTail) {
            fast = fast.next;
            pos++;
        }
        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int test = 0; test < tests; test++) {
            List list = new List();

            int listC = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < listC; i++) {
                int listItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                list.insert(listItem);
            }

            int position = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = get(list.head, position);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
