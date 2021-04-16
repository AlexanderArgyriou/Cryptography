package driver;

import hash.GuavaHashing;

public class DriverHash {
    public static void main(String[] args) {
        GuavaHashing guavaHashing = new GuavaHashing();
        System.out.println(guavaHashing.Hash("I want to be hashed :D"));
    }
}
