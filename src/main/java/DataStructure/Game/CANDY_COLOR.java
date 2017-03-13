package DataStructure.Game;

import java.util.Random;

/**
 * 说 明：
 * Created by wuzhu on 2017/3/13.
 */
public enum CANDY_COLOR {
    MCOLOR(0,"多色"), //主要用于多彩
    RED(1,"红色"),
    GREEN(2,"绿色"),
    YELLOW(3,"黄色"),
    BLUE(4,"蓝色"),
    ORANGE(5,"橘色"),
    PINK(6,"粉色");
    int index; //索引
    String color; //糖果颜色
    CANDY_COLOR(int index,String color){
        this.index = index;
        this.color = color;
    }

    public static CANDY_COLOR randomColor(){
        int index = new Random(5).nextInt()+1;//排除掉多色
        switch (index){
            case 1:
                return RED;
            case 2:
                return GREEN;
            case 3:
                return YELLOW;
            case 4:
                return BLUE;
            case 5:
                return ORANGE;
            case 6:
                return PINK;
            default:
                return RED;
        }
    }
}
