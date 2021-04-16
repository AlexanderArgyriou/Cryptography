package assymetric;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

public class Asymmetric {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public void RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        if(privateKey == null && publicKey == null) {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            KeyPair pair = keyGen.generateKeyPair();

            this.privateKey = pair.getPrivate();
            this.publicKey = pair.getPublic();

            System.out.println(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
            System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        }
    }

    public String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64
                .getEncoder()
                .encodeToString(cipherText);
    }

    public String dencrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plainText = Base64.getDecoder().decode(input.getBytes());
        return new String(cipher.doFinal(plainText));
    }
}
