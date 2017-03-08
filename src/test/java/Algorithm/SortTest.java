package Algorithm;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * 说 明：
 * Created by wuzhu on 2017/3/6.
 */
public class SortTest {

    //插入排序测试
    @Test
    public void testShellInsertSort() throws Exception {
        int arr[] = {1,15,2,6,8,2,3,10,21,16,18,13,21,9};
        Sort.shellInsertSort(arr);
    }

    //希尔排序测试
    @Test
    public void testInsertSort() throws Exception {
        int arr[] = {1,15,2,6,8,2,3,10,21,16,18,13,21,9};
        Sort.insertSort(arr);
    }

    //优化选择排序
    @Test
    public void testSelectSort()throws Exception{
        Sort.simpleSelectSort(new int[]{1,15,2,6,8,2,3,10,21,16,18,13,21,9});
    }

    //优化冒泡排序
    @Test
    public void testBubbleSort()throws Exception{
        Sort.bubbleSort(new int[]{1,15,2,6,8,2,3,10,21,16,18,13,21,9});
        Sort.bubbleSort2(new int[]{1,15,2,6,8,2,3,10,21,16,18,13,21,9});
        Sort.bubbleSort(new int[]{1,2,6,8,10,21,21,25});
        Sort.bubbleSort2(new int[]{1,2,6,8,10,21,21,25});
        Sort.bubbleSort2(new int[]{111,28,16,8,10,2,2});
    }

    //选择快速排序
    @Test
    public void testQuickSort()throws Exception{
        Sort.quickSort(new int[]{1,15,2,6,8,2,3,10,21,16,18,13,21,9},0,13);
        Sort.quickSort(new int[]{1,2,6,8,10,21,21,25},0,6);
        Sort.quickSort(new int[]{111,28,16,8,10,2,2},0,6);
        Sort.quickSort(new int[]{2,12},0,1);
    }

    //归并排序
    @Test
    public void testMergeSort()throws Exception{
        Sort.mergeSort(new int[]{1,15,2,6,8,3,10,21,16,18,13,9});
        Sort.mergeSort(new int[]{111,28,16,8,10,2,2});
    }
}