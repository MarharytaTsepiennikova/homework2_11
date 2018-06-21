package Task3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port;
    Thread thread;

    public Server (int port){
        this.port = port;
    }

    public void stop(){
        thread.interrupt();
    }

    public void start() throws IOException {
        thread = new Thread(){
            public void run(){
                try {
                    ServerSocket serverSocket = new ServerSocket(port);

                    while (!isInterrupted()){
                        Socket c = serverSocket.accept();
                        try {
                            String msg = "Hello!\r\n";
                            c.getOutputStream().write(msg.getBytes());
                        } finally {
                            c.close();
                        }
                    }
                    serverSocket.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
}
