package com.itdom.doublylinckedlistsentinel;

import java.util.Iterator;

/**
 * 环形链表
 */
public class DoublyLinckedListSentinel implements Iterable<Integer> {
    //哨兵节点
    private Node sentinel = new Node(null, -1, null);

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    public static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }


    public DoublyLinckedListSentinel() {
        //初始化的环形链表自己指向自己
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * 添加首节点
     *
     * @param value
     */
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 添加到尾节点
     *
     * @param value
     */
    public void addLast(int value) {
        Node b = sentinel;
        Node a = sentinel.prev;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    /**
     * 删除首节点
     */
    public void removeFirst() {
        Node a = sentinel; //哨兵节点
        Node removed = sentinel.next;//首节点
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法删除!!");
        }
        Node b = removed.next; //首节点后面的一个节点
        a.next = b;
        b.prev = a;
    }

    /**
     * 删除最后一个节点
     */
    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法删除!!");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    /**
     * 根据值删除节点
     * @param value
     */
    public void removedByValue(int value) {
        Node removed = findByValue(value);
        if (removed == null) {
            return;
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    /**
     * 根据值查找节点
     * @param value
     * @return
     */
    private Node findByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
