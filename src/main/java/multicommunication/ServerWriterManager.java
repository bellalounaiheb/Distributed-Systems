package multicommunication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerWriterManager {
    private final Map<String, PrintWriter> writerMap = new HashMap<>();  
    
    public synchronized void addUser(String username, String message, Socket socket) {
        sendMessageToAll(message);
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writerMap.put(username, writer);
            System.out.println("Connected" + username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void removeUser(String username, String message) {
        writerMap.remove(username);
        sendMessageToAll(message);
    }

    private void sendMessageToAll(String message) {
        for(PrintWriter writer: writerMap.values()){
            writer.println(message);
        }
    }
}
