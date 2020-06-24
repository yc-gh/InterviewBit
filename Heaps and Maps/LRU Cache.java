//https://www.interviewbit.com/problems/lru-cache/

public class Solution {
    
    static class Item
    {
        int key, value;
        Item next, prev;
        Item(int k, int v) 
        {
            this.key = k;
            this.value = v;
        }    
    }
    
    Map<Integer,Item> map; 
    Item head, tail;
    int capacity;
    
    public Solution(int capacity) 
    {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Item(0,0);
        tail = new Item(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) 
    {
        Item mapped = map.get(key);
        if(mapped!=null) //Already in cache
        {
            deleteItem(mapped);
            addToTail(mapped);
            return mapped.value;
        }
        return -1;
    }
    
    public void set(int key, int value) 
    {

        Item mapped = map.get(key);
        if(mapped!=null)
        {
            mapped.value = value;
            deleteItem(mapped);
            addToTail(mapped);
        }
        else
        {
            Item newItem = new Item(key, value);
            if(map.size()>=capacity)
            {
                Item headNext = head.next;
                deleteItem(head.next);
                map.remove(headNext.key);
            }
            addToTail(newItem);
            map.put(key, newItem);
        }
    }
    
    private void deleteItem(Item item)
    {
        item.prev.next = item.next;
        item.next.prev = item.prev;
    }
    
    private void addToTail(Item item)
    {
        item.prev = tail.prev;
        item.next = tail;
        item.prev.next = item;
        tail.prev = item;
    }
}
