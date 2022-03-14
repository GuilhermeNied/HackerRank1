import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner s = null;
        int[] array = null;
        int rot = 0;
        try {
            s = new Scanner(System.in);
            String firstLineStr = s.nextLine();
            String[] firstLineSplit = firstLineStr.split(" ");
            int arrayLength = Integer.parseInt(firstLineSplit[0]);
            array = new int[arrayLength];
            rot = Integer.parseInt(firstLineSplit[1]);

            String secondLineStr = s.nextLine();
            String[] secondLineSplit = secondLineStr.split(" ");
            for(int i = 0; i < secondLineSplit.length; i++) {
                array[i] = Integer.parseInt(secondLineSplit[i]);
            }
        } finally {
            s.close();
        }

        for(int i = 0; i < array.length; i++) {
            int index = (i + rot) % array.length;
            System.out.print(array[index] + " ");
        }
    }
}
