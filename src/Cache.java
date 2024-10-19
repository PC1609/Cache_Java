import Exceptions.NotFoundException;
import Exceptions.StorageFullException;

public class Cache <Key, Value> {
    private final Storage<Key, Value> storage;
    private final Eviction_policy eviction_policy;

    public Cache(Storage<Key, Value> storage, Eviction_policy eviction_policy){
        this.storage=storage;
        this.eviction_policy=eviction_policy;
    }

    public void putKey(Key key, Value value){
        try{
            storage.putKey(key,value);
            eviction_policy.keyAccessed(key);
        }catch(StorageFullException exception){
            System.out.println("Cache storage is full. Trying to evict data from it.");
            Key removeKey = (Key) eviction_policy.evictKey();
            if(removeKey==null){
                throw new RuntimeException("Unexpected error. Unable to remove key from full Cache storage. ");
            }
            storage.removeKey(removeKey);
            eviction_policy.removeKey(removeKey);
            System.out.println("The least recently used data "+ removeKey+" removed." );
            storage.putKey(key,value);
        }
    }

    public Value getValue(Key key){
        try{
            Value value = storage.getValue(key);
            eviction_policy.keyAccessed(key);
            return value;
        }catch(NotFoundException exception){
            System.out.println("Invalid key");
            return null;
        }
    }
}
