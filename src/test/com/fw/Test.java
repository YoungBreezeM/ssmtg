package com.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        String tmp = "/role";
//        String description = Pattern.compile("[/\\d]").matcher(tmp).replaceAll("");
//        System.out.println(description);
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("123");
        list.add("aaa");
        int index = list.indexOf("123");
        if(index != -1){
            System.out.println("找到了，我要的对象在集合中下标为：" + index);
        }else{
            System.out.println("没有要找的对象");
        }
    }
}
