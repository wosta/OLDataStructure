import java.util.Arrays;

/*
 *@author:
 *@create: 2018-07-25 22:07
 *@description:
 **/
public class Array<E> {
    private E[] data;
    private int size;// 当前下标值

    public Array(){
        this(10);
    }

    public Array(int capacity){
        this.data = (E[])new Object[capacity];
        this.size = 0;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public int getSize(){
        return this.size;
    }

    public Boolean isEmpty(){
        return this.size == 0;
    }

    // 往数组后面添加元素
    public void addLast(E e){
        this.add(size, e);
    }

    // 添加第一个元素
    public void addFirst(E e){
        this.add(0, e);
    }

    public void add(int index, E ele){
        if (size == this.data.length) {
            throw new IllegalArgumentException("Add failed, the array is full");
        }
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Add failed. Require index > 0 or index < size");
        }
        int i ;
        for (i = size; i>index; i--){
            this.data[i] = this.data[i-1];
        }
        this.data[index] = ele;
        size++;
    }

    // 获取索引位置的元素
    public E get(int index){
        if (index < 0 || index > size-1){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    // 修改索引位置元素
    public void set(int index, E ele) {
        if (index < 0 || index > size-1){
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = ele;
    }

    // 是否包含要找的元素
    public boolean contains(E ele){
        int i;
        for (i = 0; i < size; i++) {
            if (ele.equals(data[i]) ) {
                return true;
            }
        }
        return false;
    }

    // 查找元素并返回索引
    public int find(E ele){
        int i;
        for (i = 0; i < size; i++) {
            if (data[i].equals(ele)) {
                return i;
            }
        }
        return -1;
    }

    // 查找所有元素索引
    public int[] findAll(int e) {
        int[] indexs = new int[size];
        int i;
        int j = 0;
        for (i = 0; i<size; i++) {
            if (data[i].equals(e)){
                indexs[j] = i;
                j++;
            }
        }
        return Arrays.copyOfRange(indexs, 0, j);
    }

    // 删除索引位置元素并返回该元素值
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Move failed. Index is illegal.");
        }
        int i;
        E res = data[index];
        //TODO: You can write like this, but is wrong. why ?
        // 当i=index+1 && i<size时 这里就不成立所以就避免了data[i] 下标越界，而注释的地方并没有。妙啊~~~
//        for (i = index; i < size; i++) {
//            data[i] = data[i+1];
//        }
        for (i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--; // loitering objects != memory leak
        /*
        * 如果没有这句话，data[size] 指向了一个对象，这不同于基本数据类型，基本数据有默认值，所以你写多少都没有关系
        * 而对象有引用，虽然此时访问不到，但是它是一个loitering object Java垃圾回收机制是不会收掉，这里收不收也不是必须的
        * 所以下面这一行代码是可写可不写。
        */
        data[size] = null;
        return res;
    }

    // 删除首个元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    // 删除某个元素
    public boolean removeElement(E ele){
        int index = find(ele);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    // 删除数组中该元素所有的位置
    public boolean removeAllElement(int ele) {
        int[] indexs = findAll(ele);
        int i;
        for (i = 0; i<indexs.length; i++){
            remove(indexs[i]);
            if (i == (indexs.length - 1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer();
        bf.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        bf.append("[");
        int i;
        for (i = 0; i < size; i++) {
            bf.append(data[i]);
            if (i != size - 1){
                bf.append(", ");
            }
        }
        bf.append("]");
        return bf.toString();
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20);
        int i;
        for (i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(2, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        arr.addLast(200);
        System.out.println(arr);

        System.out.println(arr.get(5));

        arr.set(3, 1);
        System.out.println(arr);

        int ele = arr.find(1);
        System.out.println("find: " + ele);

        int[] indexs = arr.findAll(1);
        System.out.print("Find all indexs: [");
        for (i = 0; i < indexs.length; i++) {
            System.out.print(indexs[i] + ", ");
        }
        System.out.println("]");

        arr.remove(9);
        System.out.println(arr);
    }
}
