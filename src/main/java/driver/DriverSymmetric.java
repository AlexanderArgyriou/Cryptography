package driver;

import symmetric.Symmetric;


public class DriverSymmetric {
    public static void main(String[] args) throws Exception{
        Symmetric symmetric = new Symmetric();
        String text = "Hello, i want to transmit this message with safety";

        String cipher = symmetric.encrypt(text);
        System.out.println(cipher);

        String backToPlain = symmetric.decrypt(cipher);
        System.out.println(backToPlain);
    }
}
