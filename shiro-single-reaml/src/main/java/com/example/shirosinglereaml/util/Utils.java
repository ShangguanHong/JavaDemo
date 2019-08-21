package com.example.shirosinglereaml.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author sgh
 * @date 2019/8/21 下午1:24
 */
public class Utils {

    /**
     * 加密算法MD5
     *
     * @param username username
     * @param password password
     * @param salt     salt
     * @return String
     */
    public static String encryption(String username, String password, String salt) {
        // 加密算法 MD5
        // salt = username + salt
        // 迭代次数 2
        return new SimpleHash("MD5", password,
                ByteSource.Util.bytes(username + salt), 2).toHex();
    }
}
