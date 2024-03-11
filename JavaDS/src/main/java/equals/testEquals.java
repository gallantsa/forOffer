package equals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class testEquals {
    public static void main(String[] args) {
        // System.out.println(10 == 10.0); // true
        // System.out.println("123".equals(new String("123"))); // true
        // System.out.println("123".hashCode());

        Set<Integer> set = new HashSet<>();
        set.add(123);

        // set底层用的hashmap
        // private transient HashMap<E,Object> map;
        // hashMap的值固定为: private static final Object PRESENT = new Object();
        /*public boolean add (E e){
            return map.put(e, PRESENT) == null;
        }*/

    }
}
