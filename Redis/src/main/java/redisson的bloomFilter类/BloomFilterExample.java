package redisson的bloomFilter类;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;

public class BloomFilterExample {
    public static void main(String[] args) {
        // 创建 Redisson 客户端
        RedissonClient redisson = RedissonConfig.createRedissonClient();
        
        // 创建布隆过滤器
        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("myBloomFilter");
        
        // 初始化布隆过滤器，指定预计数据量和误差率
        bloomFilter.tryInit(10000, 0.03); // 预计数据量10000，误差率0.03
        
        // 添加元素
        bloomFilter.add("element1");
        bloomFilter.add("element2");
        
        // 检查元素是否存在
        boolean exists1 = bloomFilter.contains("element1"); // true
        boolean exists2 = bloomFilter.contains("element3"); // false
        
        System.out.println("element1 exists: " + exists1);
        System.out.println("element3 exists: " + exists2);
        
        // 关闭 Redisson 客户端
        redisson.shutdown();
    }
}
