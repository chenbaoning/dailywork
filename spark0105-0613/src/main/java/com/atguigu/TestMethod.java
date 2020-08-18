package com.atguigu;

public class TestMethod {
    public static void main(String[] args) {
        AA aa = new BB();

        // 动态绑定机制：在调用成员方法时，会将这个方法和对象的实际内存进行绑定,然后调用
        // 属性没有动态绑定机制,在哪里声明在哪使用
        System.out.println(aa.getResult());
    }

}

class AA {
    public int i = 10;

    public int getResult() {
        return getI() + 10;
    }

    private int getI() {
        return i;
    }
}

class BB extends AA {
    public int i = 20;

    //    public int getResult() {
//        return i + 20;
//    }
    public int getI() {
        return i;
    }

    public int getB() {
        return i + 11;
    }
}


