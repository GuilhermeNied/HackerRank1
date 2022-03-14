import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
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



    static boolean compareLists(ListN head1, ListN head2) {
        while((head1!=null && head2!=null) && head1.data == head2.data){
            head1 = head1.next;
            head2 = head2.next;
        }
        return (head1 == null && head2 == null);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bfWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int test = 0; test < tests; test++) {
            List list1 = new List();

            int list1C = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < list1C; i++) {
                int list1I = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                list1.insert(list1I);
            }

            List list2 = new List();

            int list2C = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < list2C; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                list2.insert(llist2Item);
            }

            boolean result = compareLists(list1.head, list2.head);

            bfWriter.write(String.valueOf(result ? 1 : 0));
            bfWriter.newLine();
        }

        bfWriter.close();

        scanner.close();
    }
}
