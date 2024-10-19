import Data_structures.Doubly_Linked_List;
import Data_structures.Doubly_Linked_List_Node;

import java.util.HashMap;
import java.util.Map;

public class Cache_main<Key,Value> {
    public Cache<Key,Value> mainCacheFxn(Integer capacity){
        return new Cache<Key,Value>(new HashMap_based_storage<Key,Value>(capacity), new LRU(
                new Doubly_Linked_List<Key>(), new HashMap<Key, Doubly_Linked_List_Node<Key>>()));
    }
}
