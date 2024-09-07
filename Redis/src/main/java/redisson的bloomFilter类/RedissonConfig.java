package redisson的bloomFilter类;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.redisson.api.RedissonClient;

public class RedissonConfig {
    public static RedissonClient createRedissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(6); // Redis 地址
        return Redisson.create(config);
    }
}
