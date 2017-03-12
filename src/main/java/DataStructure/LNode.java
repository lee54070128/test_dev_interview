package DataStructure;

/**
 * 说 明：定义链表的节点
 * Created by wuzhu on 2017/3/11.
 */
public class LNode {
    private Integer value;
    private LNode next;
    public LNode(){
        value = null;
        next = null;
    }

    public LNode(Integer value){
        this.value = value;
        next = null;
    }
    public int getValue() {
        return value;
    }

    public LNode getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(LNode next) {
        this.next = next;
    }
}
