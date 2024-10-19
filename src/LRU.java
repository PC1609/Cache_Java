import Data_structures.Doubly_Linked_List;
import Data_structures.Doubly_Linked_List_Node;

import java.util.Map;

public class LRU<Key> implements Eviction_policy<Key> {
    private Doubly_Linked_List<Key> dll; //has nodes with key as element, tracks recent and least recently used keys
    private Map<Key, Doubly_Linked_List_Node<Key>> map;//map key to Node, to identify which node to delete by key

    public LRU(Doubly_Linked_List <Key> dll,Map<Key,Doubly_Linked_List_Node <Key>> map ){
        this.dll=dll;
        this.map=map;
    }

    @Override
    public Key evictKey() {
        Doubly_Linked_List_Node<Key> firstNode = dll.getFirstNode();
        if (firstNode!=null){
            dll.removeFirstNode();
        }
        Key key = firstNode.getElement();
        map.remove(key);
        return key;
    }

    public void keyAccessed(Key key){
        if (map.containsKey(key)){
            dll.removeNode(map.get(key));
            dll.addNodeToLast(map.get(key));
        }
        else{
            Doubly_Linked_List_Node<Key> newNode = new Doubly_Linked_List_Node<>(key);
            dll.addNodeToLast(newNode);
            map.put(key,newNode);
        }
    }
    public void removeKey(Key key){
        dll.removeNode(map.get(key));
        map.remove(key);
    }
}
