package io.shibd.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * (146)LRU缓存
 * @author baozi
 */
public class LRUCache {


    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    // 虚拟头和尾节点
    Node head, tail;
    // 链表长度
    int linkedSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 移动node到链表的头部
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            // 缓存满了，移除尾节点
            if (linkedSize >= capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            } else {
                linkedSize++;
            }
            map.put(key, node);
        } else {
            // 更新value值
            node.value = value;
            // 移除现在的位置
            removeNode(node);
        }
        // 添加到尾部
        addToHead(node);
    }


    // 移除节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 添加到头节点
    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // 添加到尾节点
    private void addToTail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);

        System.out.println(lruCache.get(1));

    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
