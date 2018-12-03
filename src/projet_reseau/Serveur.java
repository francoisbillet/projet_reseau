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

/**
 *
 * @author fbillet
 */
public class Serveur {
    
    public static void main(String[] args) {
        
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            Socket client= serverSocket.accept();
            BufferedReader in = new BufferedReader (new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            
            while (true) {
            out.flush();
            String message_client=in.readLine();
            System.out.println("Client : "+message_client);
            }
        }
        catch(IOException e) {
            System.out.println("Could not listen on port 4444");
            System.exit(-1);
        }
        
//        Socket clientSocket = null;
//        try {
//            clientSocket = serverSocket.accept();
//        }
//        catch(IOException e) {
//            System.out.println("Accept failed on port 4444");
//            System.exit(-1);
//        }
        
        
		/*ServerSocket server;
		Socket client;
		try{
			server= new ServerSocket(4444);
			client= server.accept();
			BufferedReader in = new BufferedReader (new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			out.println("Je suis ton serveur");
		    out.flush();
		    String message_client ;
		    message_client = in.readLine();
		    System.out.println("Client : "+message_client); 
		}
		catch(IOException i){
			i.printStackTrace();
			System.out.println("Impossible d'écouter sur le port 4444: serait-il occupé?");
		}*/
	}
}
