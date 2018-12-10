package projet_reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author fbillet
 */
public class Client {
    public static void main(String args[]) throws IOException {

        Socket client;
        BufferedReader in;
        PrintWriter out;

        try {
            
            client = new Socket("localhost", 4444);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Scanner s = new Scanner(System.in);
            boolean etat = true;

            while (true) {
                if (etat) { // envoi du message
                    String message=s.nextLine();
                    out.println(message);
                    out.flush();
                    etat = false;
                } 
                
                else { // écoute du message
                    String message_reçu = in.readLine();
                    try {
                        System.out.println("message reçu: " + message_reçu);
                        if (message_reçu.equals("bye")) {
                            break;
                        }
                    } catch (NullPointerException e) {
                        break;
                    }
                    etat = true;
                }
            }
            out.close();
            in.close();
            client.close();
            
        } catch (IOException e) {
            System.out.println("On ne peut pas écouter le port 4444");
            System.exit(-1);
        }
    }
}
