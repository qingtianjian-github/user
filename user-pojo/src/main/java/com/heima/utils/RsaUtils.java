package com.heima.utils;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * 加密算法实体类
 *
 * @author cjw
 */
public class RsaUtils {


    /**
     * 解密密码
     *
     * @return
     */
    public static String decryptByPrivateKey(String key1, String k2) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec5 = new PKCS8EncodedKeySpec(Base64.decodeBase64(new byte[]{Byte.parseByte(key1)}));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec5);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(Base64.decodeBase64(new byte[]{Byte.parseByte(k2)}));
        return new String(result);
    }
}
