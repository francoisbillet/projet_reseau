/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_reseau;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author fbillet
 */
public class ResolutionAdresse {
    
    public static void main (String [] args) {
        
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());
        }
        catch(UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
