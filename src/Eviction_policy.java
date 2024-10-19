public interface Eviction_policy<Key> {
    Key evictKey();

    void keyAccessed(Key key);

    void removeKey(Key key);
}
