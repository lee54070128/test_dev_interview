package DataStructure;

/**
 * 说 明：二叉树的节点
 * Created by wuzhu on 2017/3/11.
 */
public class BTNode {
    private Integer value;  //节点值
    private BTNode left;    //左子节点
    private BTNode right;   //右子节点

    public Integer getValue() {
        return value;
    }

    public BTNode getLeft() {
        return left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }
}
