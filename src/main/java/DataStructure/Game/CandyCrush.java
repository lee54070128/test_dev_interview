package DataStructure.Game;

import DataStructure.TwoDinenArray;
import Util.POS;

import java.util.HashMap;
import java.util.Map;

/**
 * 说 明：模拟《糖果传奇》里的数据存储，从左下开始为原点，坐标为（0,0），类似x-y坐标系
 * Created by wuzhu on 2017/3/13.
 */
public class CandyCrush implements TwoDinenArray {

    public final static int WITTH = 9;   //列数
    public final static int HEIGTH = 9;  //行数
    private Object[][] units = new Object[WITTH][HEIGTH];
    private Candy[][] candys = new Candy[WITTH][HEIGTH];

    /**
     * 说 明：打印数组，从顶部开始打印，类似倒着打印
     * */
    public void print(){
        for (int i = HEIGTH-1; i >= 0; i--) {
            StringBuffer line = new StringBuffer();
            for (int j = 0; j < WITTH; j++) {
                line.append(units[j][i]);
                if(j != WITTH-1)line.append("\t");
            }
            //打印一行
            System.out.println(line);
        }
    }
    /**
     * 说 明：获取某个位置的值
     * */
    public Object getValue(POS pos){
        return units[pos.x][pos.y];
    }

    /**
     * 说 明：设置某个位置的值
     * */
    public void setValue(POS pos, Object value){
        units[pos.x][pos.y] = value;
    }

    /**
     * 说 明：交换相邻的两个元素
     * */
    public boolean exchangeValue(POS a,POS b){
        try{
            Object first = getValue(a);
            setValue(a,getValue(b));
            setValue(b,first);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 说 明：判断某位置元素x,-x,y,-y等方向的至多两个元素值是否与其相同
     * 举例：3 3 2 2 2 则有
     * @return POS[],返回相同元素的坐标地址
     * */
    public Map<String,Integer> check(POS pos){
        //先和该位置紧邻的元素对比，只有元素一样的时候，才继续往前或往后对比
        //----X轴方向
        int startX = pos.x; //横向x轴方向相同元素序列起始位置
        int endX = pos.x;//横向x轴方向相同元素序列终止位置
        //判断左边两个
        while(startX-1>=0 && startX >= pos.x-2){
//            System.out.println(units[startX][pos.y]);
            if(!units[startX][pos.y].equals(units[startX-1][pos.y])){ //当判断两个元素值不等，记录起始位置不变
                break;
            }
            startX--; //更新起始位置
        }
        //判断右边两个
        while(endX+1<WITTH && endX+1 <= pos.x+2){
//            System.out.println(units[endX][pos.y]);
            if(!units[endX][pos.y].equals(units[endX+1][pos.y])){ //判断两个元素值不等，记录的相同的元素序列元素个数和起点序号不变
                break;
            }
            endX++; //更新重点为知
        }

        //----Y轴方向
        int startY = pos.y; //横向x轴方向相同元素序列起始位置
        int endY = pos.y;//横向x轴方向相同元素序列终止位置
        //判断下边两个
        while(startY-1>=0 && startY >= pos.y-2){
//            System.out.println(units[pos.x][startY]);
            if(!units[pos.x][startY].equals(units[pos.x][startY-1])){ //当判断两个元素值不等，记录起始位置不变
                break;
            }
            startY--; //更新起始位置
        }
        //判断上边两个
        while(endY+1<HEIGTH && endY+1 <= pos.y+2){
//            System.out.println(units[pos.x][endY]);
            if(!units[pos.x][endY].equals(units[pos.x][endY+1])){ //判断两个元素值不等，记录的相同的元素序列元素个数和起点序号不变
                break;
            }
            endY++; //更新重点为知
        }

        Map<String,Integer> result = new HashMap<String, Integer>();
        result.put("startX",startX);
        result.put("endX",endX);
        result.put("startY",startY);
        result.put("endY",endY);
        return result;
    }

    /**
     * 说 明：相邻的两个元素是否可以交换位置，交换位置后，在同一方向至少有三个连续元素是相同的
     * */
    public boolean canExchange(POS a,POS b){
        try{
            //先尝试交换两个元素的位置
            exchangeValue(a,b);
            Map<String,Integer> mapA = check(a);
            Map<String,Integer> mapB = check(b);
            if((Integer)mapA.get("endX")-(Integer)mapA.get("startX")>2
                    || (Integer)mapA.get("endY")-(Integer)mapA.get("startY")>2
                    || (Integer)mapB.get("endX")-(Integer)mapB.get("startX")>2
                    || (Integer)mapB.get("endY")-(Integer)mapB.get("startY")>2)
                return true;
            else {
                exchangeValue(a,b);  //回复检查前的情况
                return false;
            }

        }catch (Exception e){
            return false;
        }
    }

    /**
     * 说 明：判断某一个点位置周围八个元素加起自身，可以生成一个什么样的方块
     * 比如：3个->消除；4个->条纹；5个->彩球；直角5个->方块
     * */
    public Candy generateCandyType(Map<String,Integer> stat,Candy candy){
        POS pos = candy.getPos();
        try {
            if(stat == null || stat.size() != 4)
                throw new Exception("元素周围统计不对，请确认！");
            int startX = (Integer) stat.get("startX");
            int endX = (Integer)stat.get("endX");
            int startY = (Integer)stat.get("startY");
            int endY = (Integer)stat.get("endY");

            //如果有五个连续一样的，则原位置生成彩球，其他4个位置设置为null,优先级最高
            //获取统计信息的时候，已经判断过周围元素的坐标范围了，这里就不再判断了
            if((endX - startX == 4) || (endY-startY==4)) {
                candy = new Candy(candy.color,CANDY_TYPE.MUTIL,pos);
                if (endX - startX == 4) {
                    for (int i = startX; i <= endX; i++) {
                        candyExploded((Candy) getValue(new POS(i, pos.y)));
                        if (i == pos.x) {
                            setValue(pos,candy) ;
                        }
                    }
                }
                if (endY - startY == 4) {  //和上面不可能同时出现
                    for (int i = startY; i <= endY; i++) {
                        candyExploded((Candy) getValue(new POS(pos.x, i)));
                        if (i == pos.y) {
                            setValue(pos, candy);
                        }
                    }
                }
                return candy;
            }

            //如果x,y方向都有超过3个连续颜色一样的元素，则生成方块，优先级第二
            if((endX - startX >=2 && endX - startX <= 3) &&
                    (endY-startY>=2 && endY-startY<=3)){
                candy = new Candy(candy.color,CANDY_TYPE.BOX,pos);
                if(pos.x-startX == 2){  //其左侧元素被消除（该元素两侧最多有4个是一样的）
                    candyExploded((Candy) getValue(new POS(startX, pos.y)));
                    candyExploded((Candy) getValue(new POS(startX+1, pos.y)));
                }else{  //其右侧元素被消除，总有一侧会被消除两个元素
                    candyExploded((Candy) getValue(new POS(pos.x+1, pos.y)));
                    candyExploded((Candy) getValue(new POS(pos.x+2, pos.y)));
                }

                if(pos.y-startY == 2){  //其下方元素被消除
                    candyExploded((Candy) getValue(new POS(pos.x, startY+1)));
                    candyExploded((Candy) getValue(new POS(pos.x, startY)));
                }else{  //其上方元素被消除，总有一侧会被消除两个元素
                    candyExploded((Candy) getValue(new POS(pos.x, pos.y+1)));
                    candyExploded((Candy) getValue(new POS(pos.x, pos.y+2)));
                }
                //设置其自身为方块
                setValue(pos,candy);
                return candy;
            }

            //如果x,y方向有一个有4个连续颜色一样的元素但另一个方向没有，则生成条纹，优先级第三
            if((endX - startX == 3 && endY - startY < 2) || (endY - startY == 3 && endX - startX < 2)) {
                candy = new Candy(candy.color,CANDY_TYPE.STRIPE,pos);
                if (endX - startX == 3 && endY - startY < 2) {
                    if (pos.x - startX == 2) {  //其左侧元素被消除（该元素两侧最多有4个是一样的）
                        candyExploded((Candy) getValue(new POS(startX, pos.y)));
                        candyExploded((Candy) getValue(new POS(startX + 1, pos.y)));
                        candyExploded((Candy) getValue(new POS(pos.x + 1, pos.y)));
                    } else {  //其右侧元素被消除，总有一侧会被消除两个元素
                        candyExploded((Candy) getValue(new POS(pos.x+1, pos.y)));
                        candyExploded((Candy) getValue(new POS(pos.x+2, pos.y)));
                        candyExploded((Candy) getValue(new POS(pos.x-1, pos.y)));
                    }
                }else{
                    if (pos.y - startY == 2) {  //其下方元素被消除
                        candyExploded((Candy) getValue(new POS(pos.x, startY + 1)));
                        candyExploded((Candy) getValue(new POS(pos.x, startY)));
                        candyExploded((Candy) getValue(new POS(pos.x, pos.y + 1)));
                    } else {  //其上方元素被消除，总有一侧会被消除两个元素
                        candyExploded((Candy) getValue(new POS(pos.x, pos.y+1)));
                        candyExploded((Candy) getValue(new POS(pos.x, pos.y+2)));
                        candyExploded((Candy) getValue(new POS(pos.x, pos.y-1)));
                    }
                }
                //设置其自身为方块
                setValue(pos, candy);
                return candy;
            }

            //只能消除3个元素，优先级最低
            if(endX - startX == 2 || endY - startY == 2){
                if(endX - startX == 2){ //由于无法确定元素在中间还是再一次，直接通过边界来消除元素
                    candyExploded((Candy) getValue(new POS(endX, pos.y)));
                    candyExploded((Candy) getValue(new POS(startX, pos.y)));
                    candyExploded((Candy) getValue(new POS(startX+1, pos.y)));
                }else{
                    candyExploded((Candy) getValue(new POS(pos.x, endY)));
                    candyExploded((Candy) getValue(new POS(pos.x, startY)));
                    candyExploded((Candy) getValue(new POS(pos.x, startY+1)));
                }
                return null;
            }
            //不能消除元素
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 说 明：糖果爆炸，不同类型的糖果爆炸影响的范围不一样
     * */
    public void candyExploded(Candy candy){
        switch (candy.type){
            case MONO:
                //是简单的元素，只消除自身
                setValue(candy.pos, null);
                break;
            case MUTIL:
                break;
            case BOX:
                break;
            case STRIPE:
                break;
            default:
                break;
        }
    }
}
