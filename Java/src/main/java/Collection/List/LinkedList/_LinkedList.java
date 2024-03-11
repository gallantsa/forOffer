package Collection.List.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class _LinkedList {
    public static void main(String[] args) {
        // 首尾指针维护的双向链表
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        // 构造函数可以直接传入Collection, ArrayList也是
        LinkedList<Integer> integers = new LinkedList<>(new ArrayList<>(list));
        System.out.println();
    }
}
