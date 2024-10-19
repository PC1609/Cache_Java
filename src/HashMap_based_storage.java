import Exceptions.NotFoundException;
import Exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMap_based_storage<Key,Value> implements Storage<Key, Value> {
    Map<Key,Value> storage;
    private final Integer capacity;

    public HashMap_based_storage(Integer capacity){
        this.capacity=capacity;
        storage = new HashMap<>();
    }

    @Override
    public Value getValue(Key key) {
        if (!storage.containsKey(key)){ throw new NotFoundException("Invalid key"); }
        return storage.get(key);
    }

    @Override
    public void putKey(Key key, Value value) {
        if (this.isFull()){
            throw new StorageFullException("Storage capacity is full");
        }
        storage.put(key,value);
    }

    @Override
    public void removeKey(Key key) {
        if (!storage.containsKey(key)){ throw new NotFoundException("Invalid key"); }
        storage.remove(key);
    }

    public boolean isFull(){
        return (storage.size()==capacity);
    }
}
