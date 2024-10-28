package array;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2024年10月28日 13:49
 */
public class Array {
    private int[] data;

    // 数组长度
    private int n;

    // 数组中实际个数
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 根据下标查找元素
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    /**
     * 查找元素是否存在
     * @param value
     * @return
     */
    public boolean contains(int value) {
        for (int i = 0; i < count; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 向数组末尾添加元素
     * @param value
     * @return
     */
    public boolean add(int value) {
        if (count == n) {
            System.out.println("数组已满");
            return false;
        }
        data[count] = value;
        count++;
        return true;
    }

    /**
     * 根据下标插入元素
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        if (count == n) {
            System.out.println("数组已满");
            return false;
        }
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
        return true;
    }

    /**
     * 根据下标删除元素
     * @param index
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        count--;
        return true;
    }

    /**
     * 返回排序后的数组
     */
    public int[] sort() {
        int[] sortedData = new int[count];
        System.arraycopy(data, 0, sortedData, 0, count);
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (sortedData[j] > sortedData[j + 1]) {
                    int temp = sortedData[j];
                    sortedData[j] = sortedData[j + 1];
                    sortedData[j + 1] = temp;
                }
            }
        }
        return sortedData;
    }

    /**
     * 打印所有元素
     */
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0, 1);
        array.insert(0, 2);
        array.insert(1, 3);
        array.insert(3, 4);
        array.insert(3, 5);
        array.printAll();
        array.delete(2);
        array.printAll();
    }
}
