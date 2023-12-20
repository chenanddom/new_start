package com.itdom.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterator<Integer>, Iterable<Integer> {
    private int i = 0;
    private int size = 0;//逻辑大小
    private int capactity = 8;//数组的初始大小
//    private int[] array = new int[capactity];
    private int[] array = {};//使用懒惰初始化

    /**
     * 添加到数组最后
     *
     * @param element
     */
    public void addLast(int element) {
//        array[size] = element;
//        size++;
        add(size, element);
    }

    public void add(int index, int element) {
        if (index >= 0 && index < size) {
            //扩容
            checkCapcityAndGrow();
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 检查容量并且扩容
     */
    private void checkCapcityAndGrow() {
        if(size==0){
            array = new int[capactity];
        }else if (size == capactity) {
            //扩展为原来的1.5倍
            capactity += capactity >>> 1;
            int[] newArray = new int[capactity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }


    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }


    public static void main(String[] args) {

        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
//        array.foreach(e -> {
//            System.out.println(e);
//        });
//        System.out.println("-------------迭代器------------");
//        Iterator<Integer> iterator = array.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
//        System.out.println("---------------使用流--------------");
//        array.stream().forEach(e -> System.out.println(e));
//        System.out.println("----------------删除元素-------------");
//
//        System.out.println(array.delete(2));
//
//        array.stream().forEach(e -> System.out.println(e));
        int delete = array.delete(2);
        assert delete == 3;

    }

    @Override
    public boolean hasNext() {
        return i < size;
    }

    @Override
    public Integer next() {
        return array[i++];
    }


    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

    public IntStream stream() {

//        return IntStream.of(array);
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    public int delete(int index) {
        int removed = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removed;
    }

}
