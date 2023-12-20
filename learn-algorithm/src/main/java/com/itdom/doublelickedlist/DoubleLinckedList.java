package com.itdom.doublelickedlist;

import java.util.Iterator;

public class DoubleLinckedList implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    static class Node {
        Node prev;//前驱节点
        int value;//节点值
        Node next;//后继节点

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;//头节点
    private Node tail;//尾节点

    public DoubleLinckedList() {
        head = new Node(null, 0, null);
        tail = new Node(null, -1, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index) {
        int i = -1;//因为存在头节点和尾节点，所以需要脚标从-1开始
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void removeFirst() {

    }

    public void addLast(int value) {
        Node lastNode = tail.prev;//取得链表的尾元素节点
        Node addNode = new Node(lastNode, value, tail);//需要添加的元素
        lastNode.next = addNode;//将最后一个元素节点的下一个节点执行新节点
        tail.prev = addNode;//将尾节点的前驱节点指向新曾的节点。
    }

    public void removeLast() {
        Node removed = tail.prev;//获取尾元素节点
        if (removed == head) {//如果时哨兵节点就异常提示
            throw illegalArgumentException(0);
        }
        Node prev = removed.prev;//尾元素节点的前驱节点
        prev.next = tail;//让上一个节点的
        tail.prev = prev;

    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);//上一个节点
        if (prev == null) {
            throw illegalArgumentException(index);
        }
        Node next = prev.next;
        Node insertNode = new Node(prev, value, next);
        prev.next = insertNode;
        next.prev = insertNode;

    }

    public void remove(int index) {
        Node prev = findNode(index - 1);//找到上一个节点
        Node removedNode = prev.next;//被删除节点
        Node next = removedNode.next;//被删除节点的下一个节点

        prev.next = next;//将被删除节点的上一个节点的后继节点指向下一个节点
        next.prev = prev;//将被删除的下一个节点的前驱节点指向前驱节点.

    }

    private IllegalArgumentException illegalArgumentException(int index) {
        return new IllegalArgumentException(String.format("脚标[%1$s]非法", index));
    }


    public static void main(String[] args) {
        System.out.println(new DoubleLinckedList().illegalArgumentException(1));
    }


}
