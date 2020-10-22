package com.provider.core.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.api.core.Test;


/**
 * @Author: sigy
 * @Date: 2020/9/15 17:24
 */
@Service
public class TestImpl  implements Test {
    @Override
    public String test(String str) {
        System.out.println(str);
        return str;
    }

    private String haha = "haha";

    public String getHaha() {
        return haha;
    }

    public void setHaha(String haha) {
        this.haha = haha;
    }

    public String suHaoRan(){
        return "haha";
    }
}
