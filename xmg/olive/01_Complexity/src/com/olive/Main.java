package com.olive;

/**
 * @author olive
 * @date 2019-09-26 11:11
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(fib1(6));
        System.out.println(fib2(6));
    }

    public static int fib2(int n) {
        if (n > 1){
            int first = 0;
            int second = 1;
            int sum = 0;
            // n-1 表示第n项需要加的次数
            // 1 2 3 4 5 6
            // 1 1 2 3 5 8 13 21
            for (int i = 0; i < n - 1; i++) {
                // 第n项表示 n-2=first n-1=second 之和
                sum = first + second;
                // 下一轮之后将 后一个second给前一个first
                // sum赋值给second
                // 注意下面两行顺序不可互换
                first = second;
                second = sum;
            }
            return sum;
        }else {
            return 1;
        }
    }

    public static int fib1(int n) {
        if (n <= 2) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

}
