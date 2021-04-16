package hash;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class GuavaHashing {
    public String Hash(String Input) {
        return Hashing.sha256()
                .hashString("I want to be hashed :)", StandardCharsets.UTF_8)
                .toString(); // sha256
    }
}
