package projet_reseau;

import javax.crypto.*;
import java.security.*;

/**
 *
 * @author fbillet
 */
public class TestEASKey {
    public static void main(String[] args) {
        byte[] data;
        byte[] result;
        byte[] original;
        
        try {
            KeyGenerator kg = KeyGenerator.getInstance("DES");
            Key key = kg.generateKey();
            Cipher cipher = Cipher.getInstance("DES");
            
            cipher.init(Cipher.ENCRYPT_MODE, key);
            data = "Hello World!".getBytes();
            result = cipher.doFinal(data);
            cipher.init(Cipher.DECRYPT_MODE, key);
            original = cipher.doFinal(result);
            System.out.println("Decrypted data : " + new String(original));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
