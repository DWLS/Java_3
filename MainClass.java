package Lesson_1.Generics;

public class MainClass {
    public static void main(String[] args) {

    }

    public static void problemWithObjClass() {
        ObjClass a = new ObjClass(new Integer(20));
        int x = (int) a.getObj();
        System.out.println("x: " + x);
        a.info();
        a.setObj("Hello");
        if (a.getObj() instanceof Integer) {
            int z = (int) a.getObj();
            System.out.println("z: " + z);
        }
        a.info();
    }

    public static void genericTest() {
        GenClass<Integer> a = new GenClass<>(20);
        int x = a.getObj();
        a.info();
    }

    public static void generic2TypeTest() {
        GenClass2Types<Integer, String> a = new GenClass2Types<>(20, "Java");
        a.info();
    }
}
