package com.itdom.linkedlist;

import java.util.Iterator;

public class SingleLinkedList implements Iterable<Integer> {
    private Node head = new Node(0, null);//哨兵节点(哑元节点)

    @Override
    public Iterator<Integer> iterator() {
        return new IntegerIterator();
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表添加节点
     *
     * @param value 节点值
     */
    public void addFirst(int value) {
//        head = new Node(value, head);
        insert(0,value);
    }

    public void loop() {
        Node p = head.next;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }

    }


    private class IntegerIterator implements Iterator<Integer> {
        Node p = head.next;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public Integer next() {
            Integer v = head.value;
            head = head.next;
            return v;
        }
    }


    public void addLast(int value) {
        Node last = findLast();
//        if (last == null) {
//            addFirst(value);
//            return;
//        }
        last.next = new Node(value, null);
    }

    public Node findLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /**
     * 根据索引查找节点
     *
     * @param index 节点的索引
     * @return 返回节点
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (index == i) {
                return p;
            }
        }
        return null;
    }


    public int get(int index) {
        Node node = this.findNode(index);
        if (node == null) {
            throw new IllegalArgumentException("非法参数！");
        }
        return node.value;
    }

    public void insert(int index, int value) {
        //如果时第一个就相当于向第头部插入节点
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException("非法参数！");
        }
        prev.next = new Node(value, prev.next);
    }

    /**
     * 删除第一个节点
     */
    public void removeFirst() {
//        if (head == null) {
//            throw new IllegalArgumentException("没有节点可以删除");
//        }
//        head = head.next;
        remove(0);
    }

    /**
     * 删除指定的节点
     *
     * @param index
     */
    public void remove(int index) {
        //只删除头节点
//        if (index == 0) {
//            removeFirst();
//            return;
//        }
        //没有找到前驱节点
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException("没有找到节点");
        }
        Node removed = prev.next;
        //当前删除的节点不存在
        if (removed == null) {
            throw new IllegalArgumentException("没有找到节点");
        }
        prev.next = removed.next;
    }
}
