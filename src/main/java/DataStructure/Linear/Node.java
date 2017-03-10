package DataStructure.Linear;

/**
 * 说 明：定义链表的节点
 * Created by wuzhu on 2017/3/11.
 */
public class Node{
    private Integer value;
    private Node next;
    public Node(){
        value = null;
        next = null;
    }

    public Node(Integer value){
        this.value = value;
        next = null;
    }
    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
