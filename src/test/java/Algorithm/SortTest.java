package Algorithm;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * 说 明：
 * Created by wuzhu on 2017/3/6.
 */
public class SortTest {
    @Test
    public void testInsertSort() throws Exception {
        int arr[] = {1,15,2,6,8,2,3,10,21,16,18,13,21,9};
        Sort.insertSort(arr);
    }

}