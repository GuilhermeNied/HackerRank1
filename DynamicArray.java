import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<Integer>());
        }
        int q = s.nextInt();
        int la = 0;
        for (int i = 0; i < q; i++) {
            if (s.nextInt() == 1) {
                lists.get((s.nextInt() ^ la) % n).add(s.nextInt());
            }
            else {
                ArrayList<Integer> l = lists.get((s.nextInt() ^ la) % n);
                la = l.get(s.nextInt() % l.size());
                System.out.println(la);
            }
        }
    }
}
