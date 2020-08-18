import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestGeneric {

    public static void main(String[] args) {


        List<? extends A> list1 = new ArrayList<A>();


//        HashMap( ("a", 1), ("b", 2), ("c", 3) )
//        Map( ("a", 2), ("b", 3), ("d", 4) )

        HashMap map1 = new HashMap();
        map1.put("a",1);
        map1.put("b",2);
        map1.put("c",3);

        HashMap map2 = new HashMap();
        map2.put("a",2);
        map2.put("b",3);
        map2.put("c",1);

        map1.putAll(map2);

        System.out.println(map1);


    }
}
class A{

}
class B extends A{

}
class C extends B{

}