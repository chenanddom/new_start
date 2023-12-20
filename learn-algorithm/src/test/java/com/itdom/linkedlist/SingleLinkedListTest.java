package com.itdom.linkedlist;

import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {
    @Test
    public void loopTest(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(1);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(4);
        singleLinkedList.loop();
    }

    @Test
    public void addLastTest(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.addLast(4);
        singleLinkedList.addLast(5);
        singleLinkedList.addLast(6);
        singleLinkedList.loop();
    }
    @Test
    public void getTest(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.addLast(4);
        singleLinkedList.addLast(5);
        singleLinkedList.addLast(6);
        System.out.println(singleLinkedList.get(2));
    }

    @Test
    public void insertTest(){

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.addLast(4);
        singleLinkedList.addLast(5);
        singleLinkedList.addLast(6);
        singleLinkedList.insert(3,10);
        singleLinkedList.loop();

    }

    @Test
    public void removeFirstTest(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.addLast(4);
        singleLinkedList.removeFirst();
        singleLinkedList.loop();
        System.out.println("----------------------");
        singleLinkedList.removeFirst();
        singleLinkedList.loop();
        System.out.println("----------------------");
        singleLinkedList.removeFirst();
        singleLinkedList.loop();
        System.out.println("----------------------");
        singleLinkedList.removeFirst();
        singleLinkedList.loop();
        System.out.println("----------------------");
        singleLinkedList.removeFirst();
        singleLinkedList.loop();
        System.out.println("----------------------");
        singleLinkedList.removeFirst();
        singleLinkedList.loop();
    }
    @Test
    public void removeTest(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addLast(1);
        singleLinkedList.addLast(2);
        singleLinkedList.addLast(3);
        singleLinkedList.addLast(4);
        singleLinkedList.remove(2);
        singleLinkedList.loop();
    }

}
