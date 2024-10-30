package multicommunication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCommunication {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            ServerWriterManager serverWriterManager = new ServerWriterManager();
            while(true) {
                Socket socket = serverSocket.accept();
                new ServerReaderThread(socket, serverWriterManager).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
