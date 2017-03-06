package Algorithm;

import java.util.Arrays;

/**
 * 说 明：排序算法
 * Created by wuzhu on 2017/3/6.
 */
public class Sort {
    /**
     * 说 明：插入排序，把未排序的数字一个个插入有序表中
     * */
    public static void insertSort(int[] arr){
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if(arr[i]<arr[i-1]){  //如果待排序数字比有序表中最大数小
                int temp = arr[i];
                int j=i-1;
                while(j>0 && arr[j]>temp){
                    arr[j+1] = arr[j]; //元素后移
                    j--;
                }
                arr[j+1] = temp;
            }
           System.out.println(Arrays.toString(arr));
        }
    }
}
