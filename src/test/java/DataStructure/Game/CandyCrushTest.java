package DataStructure.Game;

import Util.POS;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.*;

/**
 * 说 明：
 * Created by wuzhu on 2017/3/13.
 */
public class CandyCrushTest {
    CandyCrush candy = new CandyCrush();
    @BeforeMethod
    public void setUp() throws Exception {
        for (int i = 0; i < CandyCrush.HEIGTH; i++) {
            for (int j = 0; j < CandyCrush.WITTH; j++) {
                candy.setValue(new POS(i,j),Integer.valueOf((i+j+1))%9);
            }
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testPrint() throws Exception {
        candy.print();
    }

    @Test
    public void testGetValue() throws Exception {

    }

    @Test
    public void testExchangeValue() throws Exception {
        candy.print();
        System.out.println("--------------");
        candy.exchangeValue(new POS(0,0),new POS(1,0));
        candy.print();
    }

    @Test
    public void testCheck() throws Exception {
        candy.print();
        System.out.println("--------------");
        candy.exchangeValue(new POS(0,0),new POS(1,0));
        candy.print();
        System.out.println("检查是否可消除：");
        Map rt = candy.check(new POS(0,0));
        System.out.println(rt.toString());
    }

    @Test
    public void testCanExchange() throws Exception {
        System.out.println(candy.canExchange(new POS(0,0),new POS(1,0)));
    }

}