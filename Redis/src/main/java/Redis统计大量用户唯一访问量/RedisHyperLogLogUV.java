package Redis统计大量用户唯一访问量;

import redis.clients.jedis.Jedis;

public class RedisHyperLogLogUV {

    private static final String UV_KEY = "uv";

    private Jedis jedis;

    public RedisHyperLogLogUV() {
        // 连接到 Redis
        this.jedis = new Jedis("localhost", 6379);
        jedis.select(6);
    }

    // 添加用户访问记录
    public void addUserVisit(String userId) {
        jedis.pfadd(UV_KEY, userId);
    }

    // 获取独立用户访问量
    public long getUniqueVisitorCount() {
        return jedis.pfcount(UV_KEY);
    }

    // 关闭连接
    public void close() {
        jedis.close();
    }

    public static void main(String[] args) {
        RedisHyperLogLogUV uvCounter = new RedisHyperLogLogUV();

        // 模拟用户访问
        uvCounter.addUserVisit("user1");
        uvCounter.addUserVisit("user2");
        uvCounter.addUserVisit("user3");
        uvCounter.addUserVisit("user1"); // 重复访问
        uvCounter.addUserVisit("user4");

        // 获取独立用户访问量
        long uniqueVisitors = uvCounter.getUniqueVisitorCount();
        System.out.println("Unique Visitors: " + uniqueVisitors); // 输出: 4

        // 关闭连接
        uvCounter.close();
    }
}

