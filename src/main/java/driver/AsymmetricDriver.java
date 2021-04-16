package driver;

import assymetric.Asymmetric;

public class AsymmetricDriver {
    public static void main(String[] args) throws Exception {
        Asymmetric asymmetric = new Asymmetric();
        asymmetric.RSAKeyPairGenerator();

        String encryptedWithPublicKey = asymmetric.encrypt("Encrypt me please :D ");
        System.out.println(encryptedWithPublicKey);

        String decryptedWithPrivateKey = asymmetric.dencrypt(encryptedWithPublicKey);
        System.out.println(decryptedWithPrivateKey);
    }
}
