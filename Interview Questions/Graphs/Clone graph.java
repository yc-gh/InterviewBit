// https://www.interviewbit.com/problems/clone-graph/

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        return clone(node,map);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, 
                        Map<UndirectedGraphNode,UndirectedGraphNode> map)
    {
        if(node==null) return null;
        
        if(map.containsKey(node)) return map.get(node);
        
        map.put(node, new UndirectedGraphNode(node.label));
        
        for(UndirectedGraphNode adj : node.neighbors)
        {
            map.get(node).neighbors.add(clone(adj,map));
        }
        
        return map.get(node);
    }
}