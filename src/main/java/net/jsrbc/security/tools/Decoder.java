package net.jsrbc.security.tools;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 解码器
 * @author ZZZ on 2021/3/6 15:54
 * @version 1.0
 */
public final class Decoder {

    /**
     * 解密
     * @param secretKey 秘钥
     * @param content 待解密内容
     * @return 解密后的文字
     */
    public static String decodeOfAES(String secretKey, String content) {
        try {
            Cipher cipher = Cipher.getInstance(Algorithm.PKCS5Padding.getValue());
            cipher.init(Cipher.DECRYPT_MODE, Encoder.encodeSecretKey(secretKey));
            return new String(cipher.doFinal(Hex.decodeHex(content)), StandardCharsets.UTF_8);
        } catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | InvalidKeyException | DecoderException e) {
            throw new IllegalArgumentException("无法识别的密码", e);
        }
    }

    private Decoder() {}
}
