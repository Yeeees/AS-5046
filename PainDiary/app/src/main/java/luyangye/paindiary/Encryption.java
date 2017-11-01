package luyangye.paindiary;

/**
 * Created by YLY on 25/04/2016.
 */
import java.security.*;
import java.math.*;

public class Encryption {
    public Encryption(){

    }
    public String md5(String plaintext) {
    try{
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(plaintext.getBytes(), 0, plaintext.length());
        return new BigInteger(1,m.digest()).toString(16);}
    catch (Exception e){
        System.out.println(e);
        return null;
    }
    }
}
