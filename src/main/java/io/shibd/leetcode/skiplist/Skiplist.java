package io.shibd.leetcode.skiplist;

/**
 * 1206. 设计跳表
 *
 * @author baozi
 */
public class Skiplist {


    // 每个节点有第i层指针的概率
    private final static double P = 0.8;
    // 整个跳表的最大层数
    private final static int maxLevel = 32;

    // 跳表目前的层数
    private int currentLevel;

    // 跳表当前最大层数的那个头节点
    private Node head;

    public Skiplist() {
        head = new Node(-1, maxLevel);
    }


    public boolean search(int target) {
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, target);
            if (searchNode.next[i] != null && searchNode.next[i].value == target) {
                return true;
            }
        }
        return false;
    }

    public void add(int num) {

        // new Node
        int level = randomLevel();
        Node newNode = new Node(num, level);
        Node startNode = head;

        // 计算出当前num 索引的实际层数，从该层开始添加索引
        // 逐层添加索引
        for (int i = currentLevel - 1; i >= 0; i--) {
            // 找到本层离num最近的节点
            startNode = findClosest(startNode, i, num);
            // 上面要不断的找才能找到更新startNode
            // 如果已经在当下的层数了,则更新指针
            if (i < level) {
                if (startNode.next[i] == null) {
                    startNode.next[i] = newNode;
                } else {
                    Node tmp = startNode.next[i];
                    startNode.next[i] = newNode;
                    newNode.next[i] = tmp;
                }
            }
        }

        // 如果新节点的层数大于当前最大的层数,那么则更新head.next为新节点
        if (level > currentLevel) {
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            currentLevel = level;
        }
    }

    public boolean erase(int num) {
        Node searchNode = head;
        boolean flag = false;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, num);
            // 准确节点的上一个节点了
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 自己写的额外新增的方法
     * @param num
     * @return
     */
    public Node find(int num) {
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, num);
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                return searchNode.next[i];
            }
        }
        return null;
    }

    /**
     * 找到level层中: value刚好大于node的节点 (两个节点中间)
     *
     * @param node  从哪一层节点开始找
     * @param level 要插入节点所在的层
     * @param value 要插入节点的值
     * @return
     */
    private Node findClosest(Node node, int level, int value) {
        while (node.next[level] != null && node.next[level].value < value) {
            node = node.next[level];
        }
        return node;
    }

    /**
     * 每个节点可能有多少层
     *
     * @return
     */
    private int randomLevel() {
        int level = 1;
        while (Math.random() < 0.25 && level < maxLevel) {
            level++;
        }
        return level;
    }

    public static void main(String[] args) {

        Skiplist skiplist = new Skiplist();
        skiplist.add(10);
        skiplist.add(9);
        skiplist.add(13);
        skiplist.add(20);
        skiplist.add(3);
        skiplist.add(4);

        Node node = skiplist.find(4);
        System.out.println(node);
        System.out.println(skiplist.search(3));

    }


    static class Node {
        // 节点的值
        int value;
        // 节点在不同层的下一个节点
        // 同样也代表了这个节点有几层索引
        Node[] next;

        public Node(int value, int level) {
            this.value = value;
            this.next = new Node[level];
        }
    }
}
