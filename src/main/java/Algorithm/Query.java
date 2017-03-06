package Algorithm;

/**
 * Created by lianqiang on 2017/3/4.
 */
public class Query {
    /**
     * 说 明：二分查找
     * */
    public static int BinarySearch(int[] data,int start,int end,int num){
        if(data.length==0 || data == null ){
            System.out.println("待查询数组为空！");
            return -1;
        }
        if(start>end || start<0 || end>=data.length){
            System.out.println("参数错误：start:"+start+",end:"+end);
            return -1;
        }
        int index = (end-start)*(num-data[start])/(data[end] -data[start])+start;
        if(num == data[index]){
            System.out.println("找到了，该数字索引为："+index);
        }
        if(index>end || index<start ){
            System.out.println("Error:index="+index);
            return -1;
        }
        if(num<data[index]){
            return BinarySearch(data,start,index-1,num);
        }
        if(num>data[index]){
            return BinarySearch(data,index+1,end,num);
        }
        return index;
    }
}
