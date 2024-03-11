package Map.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class _ConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>();
        // 简直不能为空, 空指针异常 if (key == null || value == null) throw new NullPointerException();
        hashMap.put(null, null);
    }
}
