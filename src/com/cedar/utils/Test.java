package com.cedar.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    Test(){
        Object o1=new ArrayList().iterator();
        System.out.println(o1 instanceof List);
        System.out.println(o1 instanceof Iterator);
    }
    public static void main(String[] args) {
        new Test();

    }
}
