//https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/

public class Solution {
    
    static class Node
    {
        char ch;
        Node next, prev;
        Node(char c) 
        {
            ch = c;
        }
    }
    
    static Node head, tail;
    
    public String solve(String A) {
        
        Map<Character, Node> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        head=new Node('0');
        tail = new Node('0');
        head.next = tail;
        tail.prev = head;
        
        for(char ch : A.toCharArray())
        {
            if(!map.containsKey(ch))
            {
                Node newNode = new Node(ch);
                addNode(newNode);
                map.put(ch, newNode);
            }
            else
            {
                Node node = map.get(ch);
                if(node!=null) 
                {
                    removeNode(node);
                    map.put(ch, null);
                }
            }
            
            if(head.next == tail) sb.append("#");
            else sb.append(head.next.ch);
        }
        
        return sb.toString();
    }
    
    private static void addNode(Node node)
    {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
    
    private static void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
