/*
 *@author: olive
 *@create: 2018-08-05 19:14
 *@description:
 **/
public class Student {
    private String name;
    private int score;

    public Student(String name, int socre) {
        this.name = name;
        this.score = socre;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> array = new Array<>();
        Student ww = new Student("ww", 96);
        array.addLast(new Student("zs", 100));
        array.addLast(new Student("ls", 80));
        array.addLast(ww);
        System.out.println(array.toString());

        int fineIndex = array.find(ww);
        System.out.println("Find the index of student is " + fineIndex);
    }
}
