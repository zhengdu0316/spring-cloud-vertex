package org.vertex.springcloudvertexclientb;

import org.junit.Test;

/**
 * @author zhengdu
 * @date 2019/5/18 13:09
 */

public class SelfTest {

    @Test
    public void fun1(){
        String str="20010000";
        String newStr = str.replaceAll("0*$", "");
        System.out.println(newStr);
    }
}