package Algorithm;

import DataStructure.Linear.MLinkList;
import DataStructure.Linear.Node;
import org.testng.annotations.Test;
/**
 * 说 明：
 * Created by wuzhu on 2017/3/10.
 */
public class MLinkListTest {
    MLinkList genenrate(){
        MLinkList link = new MLinkList();
        link.addNode(1);
        link.addNode(2);
        link.addNode(3);
        link.addNode(4);
        link.addNode(5);
        link.addNode(6);
        return link;
    }

    @Test
    public void testGetTail() throws Exception {
        MLinkList link = genenrate();
        link.printNode(link.getTail());
    }

    @Test
    public void testDeleteTail() throws Exception {
        MLinkList link = genenrate();
        link.print();
        link.deleteTail();
        link.print();
    }

    @Test
    public void testAddNode() throws Exception {
        MLinkList link = genenrate();
        link.print();
        link.addNode(7);
        link.print();
    }

    @Test
    public void testPrint() throws Exception {
        MLinkList link = new MLinkList();
        link.print();
    }

    @Test
    public void testReverse() throws Exception {
        MLinkList link = genenrate();
        link.print();
        MLinkList link2= link.twoReverse(2);
        link2.print();
        link2.twoReverse(3).print();
    }

    @Test
    public void testDeleteNode(){
        MLinkList link = genenrate();
        link.print();
        link.deleteNode(2);
        link.print();
        link.deleteNode(5);
        link.print();
    }

    @Test
    public void testCheckCircleLink()throws Exception{
        MLinkList link = genenrate();
        link.checkCircleLink();
        link.getTail().setNext(link.getHead().getNext());
        link.checkCircleLink();
    }

    @Test
    public void testCheckCross()throws Exception{
        MLinkList link = genenrate();
        link.addNode(7);
        link.addNode(8);
        Node node = new Node(11);
        Node node1 = new Node(12);
        Node node2 = new Node(13);
        link.addNode(node);
        link.addNode(node1);
        link.addNode(node2);
        MLinkList link2 = genenrate();
        System.out.println(link.checkCross(link2));
        link2.addNode(node);
        link2.addNode(node1);
        link2.addNode(node2);
        link.print();
        link2.print();
        System.out.println(link.checkCross(link2));
    }
}