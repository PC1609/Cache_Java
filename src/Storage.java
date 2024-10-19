import com.sun.jdi.Value;

public interface Storage<Key, Value> {
    Value getValue(Key key);

    void putKey(Key key, Value value);

    void removeKey(Key key);
}
