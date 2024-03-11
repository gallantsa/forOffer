package fail_fast;

import java.util.ArrayList;
import java.util.Iterator;

public class ShowFailFast {
    public static void main(String[] args) {
        // 创建一个ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        // 获取迭代器
        Iterator<Integer> iterator = list.iterator();
        // 遍历元素
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                // 删除元素
                list.remove(integer);
            }
        }
    }
}
