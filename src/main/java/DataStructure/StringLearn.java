package DataStructure;

import java.util.Random;

/**
 * 说 明：主要介绍6个经典的字符串问题
 * Created by Administrator on 2017/3/4.
 */
public class StringLearn {

    /**
     * 1.旋转字符串
     * 题目：给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
     * 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
     * */
    /**
     * 说 明：暴力破解.没法按照C语言那样一个个字符来移动，java没有这种操作方法，直接使用String的方法来搞
     * 时间复杂度O(n2),空间复杂度O(1)
     * @author wuzhu
     * @date 2017/03/04
     * */
    public static String RotateString1(String str,int n)throws Exception{
        try{
            if(n==0){
                return str;
            }else if(n<0){
                System.out.println("索引的数字需要大于0，索引数字为"+n);
                throw new Exception("索引的数字需要大于0，索引数字为"+n);
            }
//            System.out.println("str:"+str);
            String temp = str.substring(n);
//            System.out.println("temp:"+temp);
//            System.out.println(str.substring(0,n));
            temp += str.substring(0,n);

            return temp;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 说 明：三步反转法，先把前后两部分字符串反转，然后拼成一个字符串，再把拼成的这字符串再次翻转
     * */
    //使用递归反转字符串
    public static String reverse1(String s) {
        int length = s.length();
        if (length <= 1)
            return s;
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverse1(right) + reverse1(left);
    }
    //一个个字符串增加
    static String  ReverseString(String str){
        if(str.length() <= 1){
            return str;
        }
        String new1 = "";
        for (int i = 0; i < str.length(); i++) {
            new1 = str.charAt(i) + new1;
        }
//        return new StringBuffer(str).reverse().toString();   /
        return new1;
    }
    public static String RotateString2(String str,int n){
        if(n<0 || n>=str.length()){
            return ReverseString(str);
        }
        String left = ReverseString(str.substring(0,n));
        String right = ReverseString(str.substring(n));

        return ReverseString(left + right);
    }

    /** 举一反三
     *  链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，若k=3，
     *  翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
     * */
    public static char[] reverseString(char[] linklist,int index){
        char[] reverse = new char[linklist.length];
        if(linklist.length<=1){
            return linklist;
        }
        int i=0;
        float a = 1.0f;
        if(index>linklist.length){
            index = linklist.length;
        }
        while(i< index){
            reverse[i] = linklist[index-i-1];
            i++;
        }

        if(index<1){
            index = 1;
        }
        i= index;
        while(i<linklist.length){
            reverse[i] = linklist[linklist.length-1-i+index];
            i++;
        }
        return reverse;
    }

}
