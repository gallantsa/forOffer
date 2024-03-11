package Map.HashMap;

import java.util.HashMap;

public class _HashMap {
    public static void main(String[] args) {
        // static final float DEFAULT_LOAD_FACTOR = 0.75f; 负载因子默认0.75
        HashMap<Integer, Integer> map = new HashMap<>();

        // return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        // 调用无参构造器, 初始化HashMap不会创建容量, 当添加第一个元素时, 会创建容量为16的数组
        map.put(null, 1); // key为null的哈希值为0, 否则取hashCode再右移16位
        // 键值都可以为空, key只能有一个为null, 值可以有多个
        // 线程不安全, hashTable和ConcurrentHashMap都是线程安全的, ConcurrentHashMap更好
        // 设置容量大小会被扩为2的幂次方, 为了减少哈希冲突
        HashMap<Integer, Integer> hashMap = new HashMap<>(5);
    }
}
