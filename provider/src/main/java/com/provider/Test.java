package com.provider;

import com.provider.core.bean.Animal;
import com.provider.core.bean.Dog;
import com.provider.core.impl.TestImpl;

import java.util.*;

/**
 * @Author: sigy
 * @Date: 2020/9/18 16:39
 */
public  class Test {
   static int i;
    static double d;
    static char c;
    static byte b;
    static float f;
    static long l;
    static  short s;
    static boolean bool;
    public static void main(String[] args) {
      /*  Animal animal = new Animal();;
        animal = new Dog();
        if (false) {
        }*/
        String a = "1";
       int i = Integer.parseInt(a);
     String s = "+" + i;

       System.out.println( s==null?null: s.trim());
    }
}
