import java.io.*;
import java.util.*;
import java.text.*;

public class Solution {

    public static void main(String[] args) {
       
        
        Scanner scanner = new Scanner(System.in) ;
        Integer n = scanner.nextInt() ;
        if (n < 1 || n > 100000) {
            throw new IllegalArgumentException("1 <= n <= 100000") ;
        }

        DecimalFormat fmt = new DecimalFormat("#.#") ;
        SplitNumber set = new SplitNumber() ;
        for (int i=0;i<n;i++) {
            String operation = scanner.next() ;
            if (operation.equals("a") ) {
                set.addNum(scanner.nextInt());
            } else if  (operation.equals("r")) {
                if (!set.removeNum(scanner.nextInt())) {
                    System.out.println("Wrong!") ;
                    continue ;
                }
            } else {
                throw new IllegalArgumentException("Operation must be a or r") ;
            }
            Double median = set.getMedian() ;
            if (median != null) {
                
                System.out.println(fmt.format(median)) ;
            } else {
                System.out.println("Wrong!") ;
            }
       }       
    }
    
    private static class SplitNumber {
        private NumberSet small = new NumberSet() ;
        private NumberSet large = new NumberSet() ;
        
        public void addNum(Integer num) {
            if (small.getLastNum() >= num) {
                small.addNum(num) ;
            } else {
                large.addNum(num) ;
            }
            Tree() ;
        }
        
        public boolean removeNum(Integer num) {
            boolean removed = false ;
            if (small.getLastNum() >= num) {
                removed = small.removeNum(num) ;
            } else {
                removed = large.removeNum(num) ;
            }
            if (removed) {
                Tree() ;
            }
            return removed ;
        }
        
        public void Tree() {
            if (small.getNumberCnt()-large.getNumberCnt()>1) {
                
                Integer middleNum = small.getLastNum() ;
                small.removeNum(middleNum);
                large.addNum(middleNum) ;
            } else if (large.getNumberCnt()>small.getNumberCnt()) {
                
                Integer middleNum = large.getFirstNum() ;
                large.removeNum(middleNum);
                small.addNum(middleNum) ;
            }
         }
        
        
        public Double getMedian() {
            if (small.getNumberCnt()<=0 && large.getNumberCnt() <=0) {
                return null ;
            }

            if (small.getNumberCnt() > large.getNumberCnt()) {
                return (double)small.getLastNum() ;
            } else if (small.getNumberCnt() < large.getNumberCnt()) {
                return (double)large.getFirstNum() ;
            } else {
                return (((long)small.getLastNum()+(long)large.getFirstNum())/2d) ;
            }
        }
        
        public String toString() {
            return "small:"+small+" large:"+large ;
        }
    }
    
    private static class NumberSet {
        private SortedMap<Integer,Integer> map = new TreeMap<Integer,Integer>() ;
        private int numberCnt = 0;

        public void addNum(Integer num) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num)+1) ;
            } else {
                map.put(num,1) ;
            }
            numberCnt++ ;
        }

        public boolean removeNum(Integer num) {
            Integer current = map.get(num) ;
            if (current == null) {
                return false ;
            }
            if (current==1) {
                map.remove(num) ;
            } else {
                map.put(num,current-1) ;            
            }
            numberCnt-- ;
            return true ;
        }
        
        public Integer getFirstNum() {
            if (map.isEmpty()) {
                return Integer.MIN_VALUE ;
            }
            return map.firstKey() ;
        }
        
        public Integer getLastNum() {
            if (map.isEmpty()) {
                return Integer.MAX_VALUE ;
            }
            return map.lastKey() ;
        }
        
        public Integer getNumberCnt() {
            return numberCnt ;
        }
        
        public String toString() {
            return map+":"+numberCnt ;
        }
    }

}
