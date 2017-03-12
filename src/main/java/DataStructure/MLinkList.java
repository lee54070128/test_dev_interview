package DataStructure;

/**
 * 说 明：实现链表
 * Created by wuzhu on 2017/3/10.
 */
public class MLinkList {
    private LNode head; //head只是表示链表的头，并没有特定的值
    private int size;
    public MLinkList(){
        head = new LNode();
        size = 0;
    }

    public LNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void setHead(LNode head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 说 明：获取第N节点
     * */
    public LNode getNode(int n){
        if (size <= 0)return head;
        if(size < n || n < 1){
            System.out.println("节点的索引应该在[" + 1 + "," + size + "]范围内，入参不在该范围！");
            return head;
        }
        LNode LNode = head;
        for (int i = 0; i < n; i++) {
            LNode = LNode.getNext();
        }
        return LNode;
    }

    /**
     * 说 明：获取尾节点
     * */
    public LNode getTail(){

        return getNode(size);
    }

    /**
     * 说 明：删除第N个节点
     * */
    public LNode deleteNode(int n){
        if(size == 0){
            System.out.println("链表长度为0，无法删除第"+n+"节点！");
            return head;
        }
        if(size < n || n < 1){
            System.out.println("节点的索引应该在[" + 1 + "," + size + "]范围内，入参不在该范围！");
            return head;
        }

        LNode pre = head;  //为了记录待删除节点前个节点
        LNode LNode = pre.getNext();
        int i=0;
        while(i<n-1 && LNode.getNext()!= null){
            pre = LNode;
            LNode = LNode.getNext();
            i++;
        }

        //倒数第二个节点的下一个节点为null
        if(LNode.getNext()!= null) {
            pre.setNext(LNode.getNext());
        }else{
            pre.setNext(null);
        }
        size--;
        return LNode;
    }

    /**
     * 说 明：删除最后一个节点
     * */
    public LNode deleteTail(){
        if(size == 0){
            return head;
        }

        LNode pre = head;  //为了记录倒数第二个节点
        LNode tail = pre.getNext();
        while( tail.getNext()!= null){
            pre = tail;
            tail = tail.getNext();
        }

        //倒数第二个节点的下一个节点为null
        pre.setNext(null);
        size--;
        return tail;
    }

    /**
     * 新增一个节点
     */
    public void addNode(Integer value){
        LNode tail = getTail();
        tail.setNext(new LNode(value));
        size++;
    }
    public void addNode(Integer value,LNode next){
        LNode tail = getTail();
        tail.setNext(next);
        size++;
    }

    public void addNode(LNode LNode){
        getTail().setNext(LNode);
        size++;
    }

    /**
     * 说 明：打印一个节点
     * */
    public void printNode(LNode LNode){
        System.out.println("节点值为："+ LNode.getValue());
    }

    /**
     * 说 明：反转列表
     * */
    public MLinkList reverse(){
        MLinkList newLink = new MLinkList();
        while (size>0){
            newLink.addNode( deleteTail());
        }
        size = newLink.getSize();
        head = newLink.getHead();
        return newLink;
    }

    /**
     * 说 明：链表删除前n个节点,返回原head节点
     * */
    public LNode deletePreNodes(int n){
        if(n<=0 ){
            return head;
        }
        LNode LNode =head;
        LNode point = head;
        for (int i = 0; i < n+1; i++) {
            if(point == null){
                break;
            }
            LNode temp = point;  //记录第n-1个节点
            point = point.getNext();
            if(i==n){
                temp.setNext(null);
            }
            if(point==null)break;
        }
        //这里需要注意：不能直接用point来赋值head，因为head并不是一个节点
        head = new LNode();
        head.setNext(point);
        size -= n;
        return LNode;
    }

    /**
     * 说 明：链接两个链表
     * */
    public void concatLink(MLinkList link){
        getTail().setNext(link.getHead().getNext());
        setSize(getSize() + link.getSize());
        link = null;
    }

    /**
     * 说 明：链表两两节点反转，比如1->2->3->4->5->6反转为2->1->4->3->6->5
     * */
    public MLinkList twoReverse(int len){
        MLinkList newLink = new MLinkList();
        //设置一个本链表的浅拷贝
        MLinkList copyLink = new MLinkList();
        copyLink.setHead(head);
        copyLink.setSize(size);

        while(copyLink.getSize()>0){
            //获取前两个节点组成的子链表
            MLinkList tempLink = new MLinkList();
            tempLink.setHead(copyLink.deletePreNodes(len));
            tempLink.setSize(len);
            newLink.concatLink(tempLink.reverse());
        }

        //重新更新下链表信息
        head = newLink.getHead();
        size = newLink.getSize();
        return newLink;
    }

    /**
     * 说 明：打印链表的值
     * */
    public void print(){
        StringBuffer log = new StringBuffer("");
        LNode LNode = head;
        if(size == 0){
            System.out.println("链表为空！");
            return;
        }
        while(LNode.getNext() != null){
            LNode = LNode.getNext();
            log.append(LNode.getValue());
            if(LNode.getNext() != null)log.append("->");
        }
        System.out.println("链表为："+log);
    }

    /**
     * 说 明：判断一个链表是否是一个环
     * */
    public boolean checkCircleLink(){
        LNode slow = head;
        LNode fast = head;
        while(fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(fast.equals(slow)) {
                System.out.println("该链表是一个环！");
                return true;
            }
        }
        System.out.println("该链表不是一个环！");
        return false;
    }

    /**
     * 说 明：判断链表是否和另一个链表相交，是否可以找出交叉点
     * 原理：
     * 方法一：计算各节点的hash值，然后判断出相同的节点
     * 方法二：暴力对比各节点
     * 方法三：把第一个链表的尾节点的next接到第二个链表的首节点，然后判断是否有环，但是不能判断交叉点
     * 方法四：如果两个链表交叉的话，他们的尾节点一定是一样的；找交叉点：可以先把长链表的游标移动（len1-len2），然后两个游标同时移动，对比节点
     * @return :链表位置，没找到返回-1
     * */
    public int checkCross(MLinkList link){
        LNode tail1 = getTail();
        LNode tail2 = link.getTail();
        if(tail1 != tail2){
            return -1;
        }

        int size1 = link.getSize();
        LNode longL ;
        LNode shortL ;
        int index = 0;  //本链表的索引号
        if(size > size1){
            index = size-size1;
            longL = head;
            shortL = link.head;
        }else{
            index = 0;
            longL = link.head;
            shortL = this.head;
        }
        for (int i = 0; i < Math.abs(size-size1); i++) {
            longL = longL.getNext();
        }
        //当剩余两个链表长度一致时，同时往后遍历
        while (longL != shortL){
            longL = longL.getNext();
            shortL = shortL.getNext();
            index++;
        }
        return index;
    }
}


