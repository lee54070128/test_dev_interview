package DataStructure.Game;

/**
 * 说 明：
 * Created by wuzhu on 2017/3/13.
 */
public enum CANDY_TYPE {
    MONO(0,"单色"),
    MUTIL(1,"多色"),
    STRIPE(2,"条纹"),
    BOX(3,"方块");

    int index; //索引
    String color; //糖果颜色
    CANDY_TYPE(int index,String color){
        this.index = index;
        this.color = color;
    }
}
