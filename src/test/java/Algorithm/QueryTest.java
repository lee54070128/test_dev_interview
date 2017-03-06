package Algorithm;

import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * 说 明：
 * Created by wuzhu on 2017/3/6.
 */
public class QueryTest {
    @Test
    public void testBinarySearch() throws Exception {
        int[] data = new int[]{1,2,4,5,7,9,10,12,13,14,16,18,20};
        System.out.println("length:"+data.length);
        Query.BinarySearch(data,0,data.length-1,18);
        Query.BinarySearch(data,0,data.length-1,1);
        Query.BinarySearch(data,0,data.length-1,20);
        Query.BinarySearch(data,0,data.length-1,10);
        String a = "aa";
        System.out.println(a.hashCode());
        Map<String,Integer> hash = new HashMap<String,Integer>();
    }

}