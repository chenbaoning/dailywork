public class TestInnerClass {
    public static void main(String[] args) {
        TestInnerClass testInnerClass = new TestInnerClass();
        User user = testInnerClass.new User();

//        User logHdfs = new User();
        user.name = "hah";

    }
    final class User {
        public String name;
    }
}
