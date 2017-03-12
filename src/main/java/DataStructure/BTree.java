package DataStructure;

/**
 * 说 明：二叉树
 * Created by wuzhu on 2017/3/11.
 */
public class BTree implements Tree {
    BTNode root;

    //获取根节点
    public BTNode getRoot(){
        return root;
    }
    //获取树高
    public int getTreeHigh(){
        return 0;
    }
    //查询节点
    public BTNode queryNode(BTNode node){
        return node;
    }
    //增加节点
    public BTNode addNode(BTNode node){
        return node;
    }
    //删除节点
    public BTNode deleteNode(BTNode node){
        return node;
    }
}
