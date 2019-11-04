package com.kp1nz.test;

import com.kp1nz.utils.MD5Utils;
import org.junit.Test;

/**
 * @author kp1nz
 * @create 2019-01-04 19:39
 */
public class TestMD5 {

    @Test
    public void get(){
        System.out.println(MD5Utils.getMD5Code("admin"));
    }
}
