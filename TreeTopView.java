import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {


    static class Pair{
        public Node node;
        public int dt;

        public Pair(Node node, int dt){
            this.node = node;
            this.dt = dt;
        }
    }

    public static void topView(Node root) {
        if(root == null)
            return;
        Map<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            Node node = pair.node;
            int dt = pair.dt;
            if(!mp.containsKey(dt)){
                mp.put(dt, node.data);
            }
            if(node.left != null){
                q.add(new Pair(node.left, dt-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, dt+1));
            }
        }
        for(Map.Entry<Integer, Integer> ent : mp.entrySet()){
            System.out.print(ent.getValue()+ " ");
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}
