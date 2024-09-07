package 排行榜实现;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisLeaderboard {

    private static final String LEADERBOARD_KEY = "leaderboard";
    private Jedis jedis;

    public RedisLeaderboard() {
        // 连接到 Redis
        this.jedis = new Jedis("localhost", 6379);
        jedis.select(6);
    }

    // 添加或更新用户分数
    public void addOrUpdateUserScore(String user, double score) {
        jedis.zadd(LEADERBOARD_KEY, score, user);
    }

    // 获取排行榜前 N 名用户
    public List<String> getTopUsers(int topN) {
        return jedis.zrevrange(LEADERBOARD_KEY, 0, topN - 1);
    }

    // 获取用户的排名
    public Long getUserRank(String user) {
        return jedis.zrevrank(LEADERBOARD_KEY, user);
    }

    // 获取用户的分数
    public Double getUserScore(String user) {
        return jedis.zscore(LEADERBOARD_KEY, user);
    }

    // 删除用户
    public void removeUser(String user) {
        jedis.zrem(LEADERBOARD_KEY, user);
    }

    // 获取排行榜分页查询
    public List<String> getUsersByPage(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        int end = start + pageSize - 1;
        return jedis.zrevrange(LEADERBOARD_KEY, start, end);
    }

    // 关闭连接
    public void close() {
        jedis.close();
    }

    public static void main(String[] args) {
        RedisLeaderboard leaderboard = new RedisLeaderboard();

        // 添加用户及其分数
        leaderboard.addOrUpdateUserScore("user1", 100);
        leaderboard.addOrUpdateUserScore("user2", 200);
        leaderboard.addOrUpdateUserScore("user3", 150);

        // 更新用户分数
        leaderboard.addOrUpdateUserScore("user1", 250);

        // 获取排行榜前 3 名用户
        List<String> topUsers = leaderboard.getTopUsers(3);
        System.out.println("Top 3 users: " + topUsers);

        // 获取用户的排名
        Long rank = leaderboard.getUserRank("user1");
        System.out.println("User1 rank: " + rank);

        // 获取用户的分数
        Double score = leaderboard.getUserScore("user1");
        System.out.println("User1 score: " + score);

        // 获取排行榜第 2 页，每页 2 个用户
        List<String> pageUsers = leaderboard.getUsersByPage(2, 2);
        System.out.println("Page 2 users: " + pageUsers);

        // 删除用户
        leaderboard.removeUser("user1");

        // 关闭连接
        leaderboard.close();
    }
}

