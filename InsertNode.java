import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class LinkListNode {
        public int data;
        public LinkListNode next;

        public LinkListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class LinkList {
        public LinkListNode head;
        public LinkListNode tail;

        public LinkList() {
            this.head = null;
            this.tail = null;
        }

      
    }

    public static void printLinkList(LinkListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

   
   static LinkListNode insert(LinkListNode list, int data) {
        LinkListNode temp;
        if(list == null){
            list = new LinkListNode(data);
            return list;
        }
        temp = new LinkListNode(data);
        temp.next = list;
        list = temp;
        return list;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        LinkList list = new LinkList();

        int listC = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < listC; i++) {
            int listI = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
          LinkListNode list_head = insert(list.head, listI);

          list.head = list_head;
        }



        printLinkList(list.head, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}