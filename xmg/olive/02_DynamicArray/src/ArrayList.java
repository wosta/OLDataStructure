/**
 * @author olive
 * @date 2019-09-27 18:48
 */
public class ArrayList {
    /*
    数组长度
     */
    private int size;
    /*
    所有元素的集合
     */
    private int[] elements;
    /*
    数组默认开辟的空间长度
     */
    private static final int CAPACITY_DEFAULT = 10;

    public ArrayList() {
        this(CAPACITY_DEFAULT);
    }

    public ArrayList(int size) {
        if (size < 10) {
            size = CAPACITY_DEFAULT;
        }
        elements = new int[size];
    }

    public int size(){
        return size;
    }

    /*
    根据下标获取元素
     */
    public int getElement(int index) {
        return 0;
    }

    /*
     * 根据元素获取下标
     */
    public int getIndex(int element) {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isCantain(int ele){
        return fasle;
    }

    public void clear() {
        size = 0;
    }
}
