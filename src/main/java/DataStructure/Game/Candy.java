package DataStructure.Game;

import Util.POS;

import java.util.Random;

/**
 * 说 明：糖果的定义
 * Created by wuzhu on 2017/3/13.
 */
public class Candy {
    //糖果颜色
    CANDY_COLOR color;
    //糖果的类型
    CANDY_TYPE type;
    //糖果的状态:0.稳定；1：待爆炸
    int status;
    //糖果的位置
    POS pos;
    //方向，只适用于条纹类型的糖果
    int direct;

    public Candy(CANDY_COLOR color,CANDY_TYPE type,int status,POS pos){
        this.color = color;
        this.type = type;
        this.status = status;
        this.pos = pos;
        if(type==CANDY_TYPE.STRIPE){
            this.direct= new Random(1).nextInt();  //随机一个方向
        }
    }

    public Candy(CANDY_COLOR color,CANDY_TYPE type,POS pos){
        this.color = color;
        this.type = type;
        this.status = 0;
        this.pos = pos;
    }

    public Candy(POS pos){
        this.color = CANDY_COLOR.randomColor();
        this.type = CANDY_TYPE.MONO;
        this.status = 0;
        this.pos = pos;
    }

    public CANDY_TYPE getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public POS getPos() {
        return pos;
    }

    public int getDirect() {
        return direct;
    }

    public void setType(CANDY_TYPE type) {
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPos(POS pos) {
        this.pos = pos;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}
