import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long size = s.nextLong();

        Map<Long, Long> map = new HashMap<>();
        long operations = s.nextLong();

        for (long i = 0; i < operations; i++) {
            long start = s.nextLong();
            long end = s.nextLong();
            long value = s.nextLong();

            map.put(start, (map.containsKey(start) ? map.get(start) : 0) + value);
            map.put(end + 1, (map.containsKey(end + 1) ? map.get(end + 1) : 0) - value);
        }

        long max = 0;
        long value = 0;
        for (long i = 0; i < size; i++) {
            value += (map.containsKey(i + 1) ? map.get(i + 1) : 0);
            max = Math.max(max, value);
        }

        System.out.println(max);
    }
}
