package multicommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReaderThread extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private ServerWriterManager writerManager;

    public ServerReaderThread(Socket socket, ServerWriterManager writerManager) {
        this.socket = socket;
        this.writerManager = writerManager;
        reader = null;
        try {
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        boolean ccontinue = true;
        while(ccontinue) {
            try {
                String input = reader.readLine();
                System.out.println(input);
                String[] parts = input.split(":");
                switch (parts[0]) {
                    case "Connected":
                        writerManager.addUser(parts[1], input, socket);
                        System.out.println("Connected" + parts[1]);
                        break;
                    case "Disconnected":
                        writerManager.removeUser(parts[1], input);
                        socket.close();
                        ccontinue = false;
                        break;
                    default:
                        System.out.println("Invalid message format" + input);
                        break;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
