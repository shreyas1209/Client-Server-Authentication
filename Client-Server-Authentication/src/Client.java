import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {
    
    private Socket socket;
    private String ip_address;
    private OutputStream outputStream;
    private DataOutputStream dataOutputStream;
    private Scanner scanner;
    

    private Client(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
        this.scanner = new Scanner(System.in);
    }


    private void start() throws IOException {
        String input;

        while (true) {
            input = scanner.nextLine();

            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            out.println(input);
            out.flush();
        }
    }

    public void sendRequest(){}

    public void getRequest(){

        //Should this return request???
    }

    public boolean authenticate(){

        return false;
    }


    public static void main(String[] args) throws NumberFormatException, UnknownHostException, Exception {
        Client client = new Client(
            InetAddress.getByName(args[0]), 
            Integer.parseInt(args[1]));

        System.out.println("\r\nConnected to Server: " +client.socket.getInetAddress());
        client.start();
    }
}