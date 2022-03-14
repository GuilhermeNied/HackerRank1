import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i = 0; i < N; ++i) {
            String input = scan.next();
            if(hm.get(input) == null) hm.put(input,1);
            else {
                int val = hm.get(input);
                hm.put(input,++val);
            }
        }

        int Q = scan.nextInt();
        while(Q-->0) {
            String query = scan.next();
            if(hm.get(query) == null) System.out.println(0);
            else System.out.println(hm.get(query));
        }
    }
}
