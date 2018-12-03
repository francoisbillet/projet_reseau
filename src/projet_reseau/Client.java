/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author fbillet
 */
public class Client {
    public static void main(String args[]) throws IOException {
        
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket("localhost",4444);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        }
        catch(UnknownHostException e) {
            System.out.println("Don't know about this host");
            System.exit(1);
        }
        catch(IOException e) {
            System.out.println("Couldn't get I/O for this connection");
            System.exit(1);
        }
        
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }
        
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
            
            /*Socket client = new Socket("localhost", 4444);
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String message_serveur;
            message_serveur = in.readLine();
		    System.out.println("Serveur : "+message_serveur);
		    out.println("Je suis ton client");
		    out.flush();
            out.close();
            in.close();
        } catch (Exception e) {
        }*/
    }
}
