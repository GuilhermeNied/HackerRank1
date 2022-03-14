import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for(int i=0; i < n;i++)
        arr[i] = scanner.nextInt();
    
    Stack<Integer> stack = new Stack<Integer>();
    stack.add(0);
    long[] store = new long[n];
    long count =0;
    for(int i=1; i < n;i++){
        while(! stack.isEmpty() && arr[stack.peek()] < arr[i]){
            stack.pop();
        }
        if(! stack.isEmpty() && arr[stack.peek()] == arr[i]){
            store[i] = store[stack.pop()]+1;
            count += store[i];
        }
        stack.push(i);
    }
    System.out.println(count*2); 
    }
}
