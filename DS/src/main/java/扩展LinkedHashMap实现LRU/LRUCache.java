package 扩展LinkedHashMap实现LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int maxCacheSize;

    LRUCache(int initialCapacity, int maxCacheSize) {
        super(initialCapacity, 0.75F, true);
        this.maxCacheSize = maxCacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > this.maxCacheSize;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(4, 4);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.keySet());
        lruCache.put(5, 5);
        System.out.println(lruCache.keySet());
        lruCache.put(6, 6);
        lruCache.get(5);
        System.out.println(lruCache.keySet());
        lruCache.put(7, 7);
        System.out.println(lruCache.keySet());
    }

}
