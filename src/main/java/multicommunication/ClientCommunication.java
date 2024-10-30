package multicommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;

public class ClientCommunication {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Thread thread;
    String username;

    public void connect(String username, JTextArea messages) {
        try{
            socket = new Socket("localhost", 5555);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            thread = new ClientReaderThread(reader, messages);
            thread.start();
            this.username = username;
            writer.println("Connected:" + username);
            System.out.println("Connected" + username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try{
            writer.println("Disconnected:" + username);
            thread.interrupt();
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}