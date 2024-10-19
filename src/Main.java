import static org.junit.jupiter.api.Assertions.assertEquals;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cache<Integer, String> cache = new Cache_main<Integer, String>().mainCacheFxn(3);

        cache.putKey(11, "Priyanka");
        cache.putKey(2, "Tina");

        assertEquals("Priyanka", cache.getValue(11)); // Accessing 1 after 2 got inserted which makes 2 the least recently used till now.
        cache.putKey(32, "Sumit");
        assertEquals("Sumit", cache.getValue(32));

        // Now if i try to add any element, the eviction should happen
        // Also eviction should happen based on LeastRecentlyUsedItem
        // which is 2 in this case.
        cache.putKey(46, "Mukesh");

        cache.getValue(2); // This should throw exception "Tried to access non-existing key."
        System.out.println(cache.getValue(46));;

    }
}