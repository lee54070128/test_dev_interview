package DataStructure;

/**
 * 说 明：
 * Created by wuzhu on 2017/3/11.
 */
public interface Tree {
    //获取根节点
    public BTNode getRoot();
    //获取树高
    public int getTreeHigh();
    //查询节点
    public BTNode queryNode(BTNode node);
    //增加节点
    public BTNode addNode(BTNode node);
    //删除节点
    public BTNode deleteNode(BTNode node);
}
