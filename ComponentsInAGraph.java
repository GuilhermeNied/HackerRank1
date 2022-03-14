import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] aras) {
       
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] parent = new int[2 * n + 1];
        int[] count = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            count[i] = 1;
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();           
            int root_a = a;
            int root_b = b;
            while (parent[root_a] != root_a) root_a = parent[root_a];
            while (parent[root_b] != root_b) root_b = parent[root_b];
            if (root_b == root_a) continue;
            if (count[root_b] < count[root_a]) {
                parent[root_b] = root_a;
                count[root_a] += count[root_b];
            } else {
                parent[root_a] = root_b;
                count[root_b] += count[root_a];               
            }
            
        }
        int min = 2 * n + 1;
        int max = 2;
        for (int i = 1; i <= 2 * n; i++) {
            if (parent[i] != i) continue;
            if (count[i] == 1) continue;
            min = Math.min(min, count[i]);
            max = Math.max(max, count[i]);
            
        }
        System.out.println(min + " " + max);
    }
}
