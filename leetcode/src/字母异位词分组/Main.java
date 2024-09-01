package 字母异位词分组;

import java.util.*;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2024年09月02日 7:36
 */
public class Main {
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            map.putIfAbsent(encode(str), new ArrayList<>());
            map.get(encode(str)).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String encode(String str) {
        char[] chars = new char[26];
        char[] array = str.toCharArray();
        for (char c : array) {
            chars[c - 'a'] ++;
        }
        return new String(chars);
    }
}