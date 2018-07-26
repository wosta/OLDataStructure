/*
 *@author:
 *@create: 2018-07-25 22:07
 *@description:
 **/
public class Array {
    private int[] data;
    private int size;// 当前下标值

    public Array(){
        this(10);
    }

    public Array(int capacity){
        this.data = new int[capacity];
        this.size = capacity;
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
    public void addLast(int e){
        this.add(size, e);
    }

    // 添加第一个元素
    public void addFirst(int e){
        this.add(0, e);
    }

    public void add(int index, int ele){
        if (size == this.data.length) {
            throw new IllegalArgumentException("Add failed, the array is full");
        }
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Add failed. Require index > 0 or index < size");
        }
        int i ;
        for (i = size - 1; i>index; i--){
            this.data[i] = this.data[i-1];
        }
        this.data[index] = ele;
        size++;
    }

    public static void main(String[] args) {

    }
}
