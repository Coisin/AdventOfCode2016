package day5;

import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * Created by oisin on 12/6/16.
 */
public abstract class Part {
    static ArrayList<String> hashes = new ArrayList<>();
    static int inc;
    static String MD5Hash(String original) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    abstract String process(String input);
}
