package com.longder.car;

import com.longder.car.util.EncryptionUtil;
import org.junit.Test;

public class EncryptionTest extends BaseTest{

    @Test
    public void testEncode(){
        String result = EncryptionUtil.encrypt("1234");

        System.out.println(result);
    }
}
