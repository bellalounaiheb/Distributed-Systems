package wordguessing;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordGuessingThread extends Thread {

    private Wordguessing wordGuessing;
    private Socket socket;

    @Override
    public void run() {
        try {
            while (true) {
            }
//        } catch (IOException e) {
//            Logger.getLogger(WordGuessingThread.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            System.out.println("Thread finished");
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(WordGuessingThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
