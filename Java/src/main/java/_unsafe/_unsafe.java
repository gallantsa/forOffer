package _unsafe;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

@Slf4j
public class _unsafe {
    private static final Unsafe unsafe = reflectGetUnsafe();
    private static final _unsafe _Unsafe = new _unsafe();
    private int value;
    private volatile int a;

    public static void main(String[] args) throws Exception {
        // 演示Unsafe内存操作
        // _Unsafe.memoryTest();

        // 演示内存屏障
        // test2();

        // 演示对象操作
        // test3();

        // 演示CAS操作
        // test4();
    }

    private static void test4() {
        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                _Unsafe.increment(i);
                System.out.print(_Unsafe.a + " ");
            }
        }).start();
        new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                _Unsafe.increment(i);
                System.out.print(_Unsafe.a + " ");
            }
        }).start();
    }

    private void increment(int x) {
        while (true) {
            try {
                long fieldOffset = unsafe.objectFieldOffset(_unsafe.class.getDeclaredField("a"));
                if (unsafe.compareAndSwapInt(this, fieldOffset, x - 1, x))
                    break;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test3() throws NoSuchFieldException {
        Unsafe unsafe = reflectGetUnsafe();
        assert unsafe != null;
        long offset = unsafe.objectFieldOffset(_unsafe.class.getDeclaredField("value"));
        _unsafe main = new _unsafe();
        System.out.println("value before putInt: " + main.value);
        unsafe.putInt(main, offset, 42);
        System.out.println("value after putInt: " + main.value);
        System.out.println("value after putInt: " + unsafe.getInt(main, offset));
    }

    private static void test2() {
        ChangeThread changeThread = new ChangeThread();
        new Thread(changeThread).start();
        while (true) {
            boolean flag = changeThread.isFlag();
            unsafe.loadFence(); //加入读内存屏障
            if (flag) {
                System.out.println("detected flag changed");
                break;
            }
        }
        System.out.println("main thread end");
    }

    /**
     * 获取Unsafe实例
     *
     * @return Unsafe实例
     */
    public static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    private void memoryTest() {
        int size = 4;
        // 分配新的本地空间
        long addr = unsafe.allocateMemory(size);
        // 重新调整内存空间的大小
        long addr3 = unsafe.reallocateMemory(addr, size * 2);
        System.out.println("addr: " + addr);
        System.out.println("addr3: " + addr3);
        try {
            // 将内存设置为指定值
            unsafe.setMemory(null, addr, size, (byte) 1);
            for (int i = 0; i < 2; i++) {
                // 内存拷贝
                unsafe.copyMemory(null, addr, null, addr3 + size * i, 4);
            }
            System.out.println(unsafe.getInt(addr));
            System.out.println(unsafe.getLong(addr3));
        } finally {
            // 清除内存
            unsafe.freeMemory(addr);
            unsafe.freeMemory(addr3);
        }
    }
}

@Getter
class ChangeThread implements Runnable {
    /**
     * volatile
     **/
    boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("subThread change flag to:" + flag);
        flag = true;
    }
}

