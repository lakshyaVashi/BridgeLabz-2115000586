import java.util.*;

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size;
    private LinkedList<Entry<K, V>>[] buckets;

    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getBucketIndex(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % buckets.length;
    }

    public void put(K key, V value) {
        if (size > LOAD_FACTOR * buckets.length) {
            resize();
        }

        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return;

        Iterator<Entry<K, V>> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            if (iterator.next().key.equals(key)) {
                iterator.remove();
                size--;
                return;
            }
        }
    }

    private void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        System.out.println(map.get("banana")); 
        map.remove("banana");
        System.out.println(map.get("banana")); 
    }
}
