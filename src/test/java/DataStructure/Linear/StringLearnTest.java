package DataStructure.Linear;

import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/3/4.
 */
public class StringLearnTest {
    @Test
    public void testRotateString2() throws Exception {
        String str = "abcdefg";
        Assert.assertEquals(StringLearn.RotateString2(str,3),"defgabc");
        Assert.assertEquals(StringLearn.RotateString2(str,-1),"gfedcba");
        Assert.assertEquals(StringLearn.RotateString2(str,0),"abcdefg");
        Assert.assertEquals(StringLearn.RotateString2(str,7),"gfedcba");
    }

    @Test
    public void testReverseString() throws Exception {
        char[] char1 = {'1','2','3','4','5','6'};
        char[] char2 = StringLearn.reverseString(char1,2);
        String str = String.valueOf(char2);
        Assert.assertEquals(str,"216543");
    }

    @Test
    public void testRotateString1() throws Exception {
        String str = "abcdefg";
        Assert.assertEquals(StringLearn.RotateString1(str,3),"defgabc");
    }

}