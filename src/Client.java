import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner console;

    public Client() {
        openConnection();
        startSendMessages();
        startGetMessages();
    }

    private void openConnection() {
        try {
            socket = new Socket("localhost", 8889);
            System.out.println("Вы подключены к серверу");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            console = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnections() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Вы отключены от сервера");
    }

    private void startSendMessages() {
        new Thread(() ->{
            try {
                while (socket.isConnected()){
                    String toServer = console.nextLine();
                    out.writeUTF(toServer);
                    out.flush();
                    if (toServer.equalsIgnoreCase("/end")) {
                        closeConnections();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void startGetMessages() {
        new Thread(() ->{
            try {
                while (socket.isConnected()) {
                    String fromServer = in.readUTF();
                    if (fromServer.equalsIgnoreCase("/end")){
                        closeConnections();
                        break;
                    }
                    System.out.println("Сообщение от сервера: " + fromServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        new Client();
    }
}
