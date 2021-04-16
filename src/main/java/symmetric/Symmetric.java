package symmetric;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Symmetric {
    private final String AES = "AES";
    private final String Algo = "AES/CBC/PKCS5Padding";
    private IvParameterSpec ivParameterSpec;
    private SecretKey secretKey;

    private SecretKey createAESKey() throws NoSuchAlgorithmException {
        if(secretKey == null) {
            SecureRandom securerandom = new SecureRandom(); // pseudorandom
            KeyGenerator keygenerator = KeyGenerator.getInstance(AES); // AES key
            keygenerator.init(128, securerandom); // 128bit
            secretKey = keygenerator.generateKey(); // return key
        }
        return secretKey;
    }

    private IvParameterSpec generateIv() {
        if(ivParameterSpec == null) {
            byte[] iv = new byte[16]; // 128 bit, same size as encrypted block
            new SecureRandom().nextBytes(iv); // pseudorandom value
            ivParameterSpec = new IvParameterSpec(iv);
        }
        return ivParameterSpec;
    }

    public String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(Algo);
        cipher.init(Cipher.ENCRYPT_MODE, createAESKey(), generateIv()); // init cipher object
        byte[] cipherText = cipher.doFinal(input.getBytes()); // This method gets bytes of input and returns ciphertext in bytes:
        return Base64
                .getEncoder()
                .encodeToString(cipherText);
    }

    public String decrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance(Algo);
        cipher.init(Cipher.DECRYPT_MODE, createAESKey(), generateIv());
        byte[] plainText = cipher
                .doFinal(Base64.getDecoder()
                .decode(input));
        return new String(plainText);
    }
}
