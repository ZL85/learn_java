package learnjava_11;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MapTest {
    @Test
    public void test1(){
        Map map = new HashMap();

        map.put(null,null);

        System.out.println(map);
    }
    @Test
    public void test2(){
        Map map = new Hashtable();

//        map.put("a",null); //NullPointerException
//        map.put(null,1); //NullPointerException
        map.put("a",1);

        System.out.println(map);
    }

    @Test
    public void test3(){
        LinkedHashMap map = new LinkedHashMap();

        map.put("Tom",23);
        map.put("a",new Date());
        map.put(1,"b");

        System.out.println(map);
    }


}
