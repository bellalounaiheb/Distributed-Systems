package multicommunication;

import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JTextArea;

public class ClientReaderThread extends Thread {
    private BufferedReader reader;
    private JTextArea messages;

    ClientReaderThread(BufferedReader reader, JTextArea messages) {
        this.reader = reader;
        this.messages = messages;
    }

    
    @Override
    public void run() {
        while(!this.isInterrupted()){
            try {
                String input = reader.readLine();
                messages.append(input + "\n");
                System.out.println(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
