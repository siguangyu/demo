package com.example.demo.server;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

/**
 * @Description:
 * @Author: ChengKai
 * @Date: 2020/8/3 10:48
 * @version: 1.0
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        List list = null;
        System.out.println(map.isEmpty());
        System.out.println(list.isEmpty());
        System.out.println(CollectionUtils.isEmpty(list));
    }



}
