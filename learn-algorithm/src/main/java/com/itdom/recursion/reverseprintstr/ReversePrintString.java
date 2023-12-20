package com.itdom.recursion.reverseprintstr;

/**
 * 反向打印字符串
 */
public class ReversePrintString {


    public void reversePrintStr(int index, String content) {
        if (index == content.length()) {
            return;
        }
        reversePrintStr(index + 1, content);
        System.out.print(content.charAt(index));
    }

}
