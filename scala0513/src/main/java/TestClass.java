public class TestClass {
    String name = "zhangs";

    TestClass(String n) {
        n = name;
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass("2");
        System.out.println(testClass.name);
    }
}
