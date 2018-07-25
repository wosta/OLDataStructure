/*
 *@author:
 *@create: 2018-07-25 22:07
 *@description:
 **/
public class Array {
    private int[] data;
    private int size;

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

    public static void main(String[] args) {

    }
}
