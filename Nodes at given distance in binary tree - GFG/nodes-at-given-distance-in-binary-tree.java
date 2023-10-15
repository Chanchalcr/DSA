//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        HashMap<Integer, ArrayList<Integer>> graph = makeGraph(root);
        Queue<Integer> q = new LinkedList<>();
        q.offer(target);
        HashSet<Integer> vis = new HashSet<>();
        vis.add(target);
        while(!q.isEmpty()) {
            if(k == 0) {
                ArrayList<Integer> list = new ArrayList<>(q);
                Collections.sort(list);
                return list;
            }
            int size = q.size();
            while(size-- > 0) {
                int temp = q.poll();
                for(int i : graph.get(temp)) {
                    if(!vis.contains(i)) {
                        q.offer(i);
                        vis.add(i);
                    }
                }
            }
            k--;
        }
        return new ArrayList<Integer>();
    }
    public static HashMap<Integer, ArrayList<Integer>> makeGraph(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        graph.put(root.data, new ArrayList<>());
        while(!q.isEmpty()) {
            Node temp = q.poll();
            
            if(temp.left != null) {
                q.offer(temp.left);
                graph.put(temp.left.data, new ArrayList<>());
                graph.get(temp.data).add(temp.left.data);
                graph.get(temp.left.data).add(temp.data);
            }
            if(temp.right != null) {
                q.offer(temp.right);
                graph.put(temp.right.data, new ArrayList<>());
                graph.get(temp.data).add(temp.right.data);
                graph.get(temp.right.data).add(temp.data);
            }
        }
        return graph;
    }
};