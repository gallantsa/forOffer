package Collection.List.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _ArrayList {
    public static void main(String[] args) {
        // 底层是可变数组
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); // 初始化时不指定容量, 默认为0, 当添加第一个元素时, 会扩为10, 之后再扩容都是1.5倍
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1); // 每次扩容一倍
        list.add(1, 2);
        ArrayList<Integer> clone = (ArrayList<Integer>) list.clone();
        // ArrayList可以被克隆
        for (Integer integer : clone) {
            System.out.println(integer);
        }

        // Integer[] array = (Integer[]) list.toArray(); 报错
//        Integer[] array = list.toArray(new Integer[0]);
//        for (Integer integer : array) {
//            System.out.println(integer);
//        }



        // toArray()要创建一个固定类型的字符串数组
//        public <T > T[]toArray(T[]a){
//            if (a.length < size)
//                // Make a new array of a's runtime type, but my contents:
//                return (T[]) Arrays.copyOf(elementData, size, a.getClass());
//            System.arraycopy(elementData, 0, a, 0, size);
//            if (a.length > size)
//                a[size] = null;
//            return a;
//        }
    }
}
