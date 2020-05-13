// https://www.interviewbit.com/problems/copy-list/

// No extra space but slower
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        
        RandomListNode curr = head;
        
        while(curr!=null)
        {
            RandomListNode newNode = new RandomListNode(curr.label);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        curr = head;
        
        while(curr!=null)
        {
            if(curr.random!=null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        
        curr = head;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode prev = newHead;
        
        while(curr!=null)
        {
            RandomListNode next = curr.next.next;
            prev.next = curr.next;
            prev = prev.next;
            curr.next = next;
            curr = curr.next;
        }
        
        return newHead.next;
    }
}


// HashMap
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        
        RandomListNode curr = head;
        
        Map<RandomListNode,RandomListNode> map = new LinkedHashMap<>();
        
        while(curr!=null)
        {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }

        for(RandomListNode node : map.keySet())
        {
            if(node.random!=null)
                map.get(node).random = map.get(node.random);
            map.get(node).next = map.get(node.next);
        }

        // Or just iterate the original list and set mappings
        
        return newHead.next; //or map.get(head)
    }
}


// Faster approach but uses extra space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        
        RandomListNode curr = head;
        
        List<RandomListNode> list = new ArrayList<>();
        
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode prev = newHead;
        
        while(curr!=null)
        {
            list.add(curr);
            RandomListNode next = curr.next;
            RandomListNode newNode = new RandomListNode(curr.label);
            curr.next = newNode;
            curr = next;
            prev.next = newNode;
            prev = newNode;
        }

        for(RandomListNode node : list)
        {
            if(node.random!=null) 
                node.next.random = node.random.next; 
            //Avoid reconstructing old list here 
            //A random pointer might be pointing to a preceding node 
            //in which case node.random.next 
            //is pointing to some node in original list not new list
        }
        
        return newHead.next;
    }
}