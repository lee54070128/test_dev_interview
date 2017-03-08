package Algorithm;

import java.util.Arrays;

/**
 * 说 明：排序算法
 * Created by wuzhu on 2017/3/6.
 */
public class Sort {
    /**
     * 说 明：交换数组里两个数字
     * */
    private static void swap(int[] data,int first,int second){
        if(data == null || data.length < first+1 || data.length < second+1){
            return;
        }
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    /**
     * 说 明：1.插入排序，把未排序的数字一个个插入有序表中
     * */
    public static void insertSort(int[] arr){
        int length = arr.length;
        if(length <=1){
            return;
        }
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

    /**
     * 说 明：2.插入排序-希尔排序。
     * 按照增量，把序列分成 长度/增量 个组，[0,0+增量，0+2*增量，....]为一组，然后按照插入排序把各组进行排序
     * 然后把缩小增量，再次排序
     * */
    public static void shellInsertSort(int[] data){
        if(data == null || data.length <=1){
            return;
        }
        int incr = data.length/2;
        while(incr >0) {
            System.out.println("incr="+incr);
            //排序各个希尔序列
            for (int index = 0; index < incr; index++) {
                int i = index+incr;
                //排列单个希尔序列，插入排序
                while (i < data.length) {
                    int j = i-incr;
                    int temp = data[i];
                    while (j > 0 && temp < data[j]) {
                        data[j+incr] = data[j];
                        j -= incr;
                    }
                    data[j + incr] = temp;
                    i += incr;
                }
            }
            incr /= 2;  //缩小增量
            System.out.println(Arrays.toString(data));
        }
    }

    /**
     * 说 明：3.简单选择排序。
     * 对未排序列，每次选择出最小和最大的两个数，最小的放在最前面，最大的放在最后面
     * */
    public static void simpleSelectSort(int[] data){
        if(data == null || data.length <=1){
            return;
        }

        for(int i=0,j=data.length-1;i<j;i++,j--){
            int min = i;
            int max = j;
            //先处理开头结尾
            if(data[i] > data[j]){
                swap(data,i,j);
            }

            //找到未排序的子字符串的最大值最小值
            for(int index=i+1; index<j; index++){
                if(data[index] > data[max]){
                    max = index;
                }
                if(data[index] < data[min]){
                    min = index;
                }
            }
            //确定最大值最小值最终位置
            if(i != min){
                swap(data,i,min);
            }
            if(j != max ){
                swap(data,j,max);
            }
            System.out.println(Arrays.toString(data));
        }
//        System.out.println(Arrays.toString(data));
    }

    /**
     * 说 明：4.选择排序-堆排序。
     * 暂时先不写
     * */
    public static void selectHeapSort(int[] data){

    }

    /**
     * 说 明：5.1交换-冒泡排序。
     * 原理：从开头开始，比较相邻两个元素，把较大的放在后面，较小的放在前面，这样较大的沉在下面
     * 变形：设置一个变量，记录最后一次交换的位置，然后下次直接排序该序号之前的序列
     * 注意：每一趟都要初始化pos值，否则会死循环
     * */
    public static void bubbleSort(int[] data){
        if(data == null || data.length <=1){
            return;
        }
        int pos = 0;  //最初交换的位置
        for (int i = data.length-1; i > 0; i = pos) {
            pos = 0;
            for (int j = 0; j < i; j++) {
                if(data[j] > data[j+1]){
                    swap(data,j,j+1);
                    pos = j;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 5.2 冒泡排序：优化，每趟排序找到最大值和最小值，可以省掉一半时间
     * 注意：需要注意当不需要排序时，最大值和最小值的情况
     * */
    public static void bubbleSort2(int[] data){
        if(data == null || data.length <=1){
            return;
        }

        int low = 0;  //最大值最初交换的位置
        int high = data.length-1;  //最小值最初交换的位置
        while(low < high){
            int left = low;
            int right = high;
            low = high = 0;  //当再没有发生交换时，这里就决定出口
            for (int j = left; j < right; j++) {
                //找到最大值
                if(data[j] > data[j+1]){
                    swap(data,j,j+1);
                    high = j;  //记录最后一次最大值交换的位置
                }
            }

            //找到最小值
            for (int i = right; i > left; i--) {
                if(data[i] < data[i-1]){
                    swap(data,i,i-1);
                    low = i;   //记录最后一次较小值交换的位置
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 说 明：交换-快速排序
     * 原理：选择一个基准值，一般选择第一，然后游标分别从头和尾开始，和这个基准值比较，
     * 如果左边游标指向的数比基准值小，则游标向右，直到找到一个比基准值大的数；同理，右边的游标找比基准值小的数
     * */
    public static void quickSort(int[] data,int start,int end){
        if(data == null || data.length <=1){
            return;
        }
        if(start <0 || end > data.length-1 || start > end){
            System.out.println("参数有误！");
            return;
        }
        int left = start,right = end;
        int base = data[left];
        while (left < right){
            while (left<right && data[right]>=base )right--;  //从左边扫描比基准值小的值，必须先从右边开始扫描，因为基准值是在左边
            swap(data,right,left);  //基准直到right指的位置
            while (left<right && data[left] <= base )left++;  //从左边扫描比基准值大的值，然后把基准值和比起大的值交换
            swap(data,left,right);  //基准值又回到left指的位置
        }
        //left位置就是基准值的位置
        if(start < left-1) {
            quickSort(data, start, left - 1);
        }
        if(left+1 < end) {
            quickSort(data, left + 1, end);
        }
        System.out.println(Arrays.toString(data));
    }

    /**
     * 快速排序的改进：当序列基本有序时，快速排序会退化为冒泡排序，因此改进成，当序列长度小于k时，使用插入排序。一般k设为8
     * */
    public static void quickSort2(int[] data,int start,int end){}

    /**
     * 说 明：归并排序。每个元素都可看成长度为1的有序表，然后把待排序列中的元素两两归并
     * */
    private static void merge(int[] a,int[] temp,int left,int mid,int right){
        if(a == null || right-left <= 0 )
            return ;
        if(left<0 || right > a.length-1 || left > mid || mid > right || temp.length != a.length) {
            System.out.println("数组错误！");
            return ;
        }
        int i = left;
        int j = mid + 1;
        int index = i;
        while (i<=mid && j <=right && index < a.length-1){
            if(a[i]<=a[j]){
                temp[index++] = a[i++];
            }else{
                temp[index++] = a[j++];
            }
        }
        //当一个有序序列扫描完了
        while(i<=mid){
            temp[index++] = a[i++];
        }
        while(j <= right){
            temp[index++] = a[j++];
        }
    }

    public static void mergeSort(int[] data){
        if(data == null || data.length <=1){
            return;
        }
        int len = 1;
        int[] arr = new int[data.length];
        while (len < data.length){
            int left = 0,mid=left+len-1,right=left + len*2 -1;
            while(right<data.length){
                merge(data,arr,left,mid,right);
                //用于归并之后的序列
                left = right+1;
                mid=left+len-1;
                right=left + len*2-1;
            }
            //归并长度不足的两个有序
            if( mid <= data.length-1){
                merge(data,arr,left,mid,data.length-1);
            }
            len = len*2;
            System.out.println("arr:"+Arrays.toString(arr));
            //交换data,arr，以保证下一趟归并时，仍从data 归并到arr
            int[] temp = data;
            data = arr;
            arr = temp;
        }
        System.out.println(Arrays.toString(data));
    }
}
