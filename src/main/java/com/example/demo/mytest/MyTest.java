package com.example.demo.mytest;

import com.alibaba.fastjson.JSONObject;
import javafx.util.Pair;
import lombok.val;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.util.DigestUtils;
import sun.security.rsa.RSASignature;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2 * @Author: sigy
 * 3 * @Date: 2020/8/17 11:02
 * 4
 */
public class MyTest {
    public static void main(String[] args) {


        //测试git

        String[] words = {"Hello", "World","ceshi","测试2","测试3"};
        //数组转换流
        //去掉“”并获取到两个String[]
        //方法调用将两个String[]扁平化为一个stream
        //去重
        List<String> collect = new ArrayList<>();
        Set<String> uniqueValues = new HashSet<>();
        for (String w : words) {
            String[] split = w.split("");
            for (String s : split) {
                if (uniqueValues.add(s)) {
                    collect.add(s);
                }
            }
        }
        //collect = [H, e, l, o, W, r, d]
        System.out.println("collect = " + collect);

       /* Map<String,String> map = new HashMap<>(16);
        map.put("1","1");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        entries.forEach((k)-> System.out.println(k.getKey()+k.getValue()));
        map.forEach((k,v)->{
            System.out.println(k+v);
        });*/

     /*   List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String s = iterator.next();
            if ("3".equals(s)) {
                iterator.remove();
            }
        }
        System.out.println(list);*/

    /*    List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(new Pair<>("a", 1));
        list.add(new Pair<>("a", 2));
        list.add(new Pair<>("b", 3));
        list.add(new Pair<>("b", 4));
        list.add(new Pair<>("b", 5));
        list.add(new Pair<>("b", 6));
        Pair<String,Integer>[] pairs = list.toArray(new Pair[0]);
        Arrays.stream(pairs).forEach(System.out::println);*/
      /*  List<Pair<String, Integer>> pairs = list.subList(2, 4);
        pairs.add(new Pair<>("e", 7));
        System.out.println(pairs);
        System.out.println(list);
        String[] s = {"1"};
        System.out.println(s.length);
        System.out.println(list.toString());
        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Pair::getKey, Pair::getValue,(a,b)->b));
        ArrayList<Pair<String, Integer>> collect1 = list.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
        Collection<Integer> values = collect.values();
        for (Integer value : values) {
            System.out.println(value);
        }
*/
    }
}
