package net.jsrbc.security.tools;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 编码器
 * @author ZZZ on 2021/3/6 15:54
 * @version 1.0
 */
public final class Encoder {

    /**
     * 加密
     * @param secretKey 私钥
     * @param content 待加密内容
     * @return 加密后的文字
     */
    public static String encodeOfAES(String secretKey, String content) {
        try {
            Cipher cipher = Cipher.getInstance(Algorithm.PKCS5Padding.getValue());
            byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE, encodeSecretKey(secretKey));
            return Hex.encodeHexString(cipher.doFinal(bytes));
        } catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalArgumentException("无法识别的密码", e);
        }
    }

    static SecretKeySpec encodeSecretKey(String secretKey) {
        return new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), Algorithm.AES.getValue());
    }

    private Encoder() {}
}
