import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner console;

    public Server(){
        openConnections();
        startGetMessenger();
        startSendMessages();
    }

    private void openConnections() {
        try {
            serverSocket = new ServerSocket(8889);
            System.out.println("Сервер запущен. Ожидание подключения клиента...");
            clientSocket = serverSocket.accept();
            System.out.println("Клиент подключен");
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            console = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnections() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        System.out.println("Клиент отключен");
    }

    private void startSendMessages() {
        new Thread(() -> {
            try {
                while (clientSocket.isConnected()){
                    String toClient = console.nextLine();
                    out.writeUTF(toClient);
                    out.flush();
                    if (toClient.equalsIgnoreCase("/end")){
                        closeConnections();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void startGetMessenger() {
        new Thread(() -> {
            try {
                while (clientSocket.isConnected()){
                    String fromClient = in.readUTF();
                    if (fromClient.equalsIgnoreCase("/end")){
                        closeConnections();
                        break;
                    }
                    System.out.println("Сообщение от клиента: " + fromClient);
                }
            } catch (EOFException e){
                //closeConnections();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        new Server();
    }
}
