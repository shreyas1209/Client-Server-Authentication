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


    private void start() throws Exception {
        
        this.sendRequest();
    }

    public void listen() throws Exception{
        String data = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String serverAddress = this.socket.getInetAddress().getHostAddress();
        data = in.readLine();
        {
            System.out.println("\r\nMessage from Server at  " + serverAddress + ": " + data);
        }
        //in.close();
    }

    public void sendRequest() throws Exception{
        String currentIP = this.getIPAddress();

        RequestPacket request = new RequestPacket(currentIP, this.socket.getInetAddress().getHostAddress(), "TCP/IP");
        request.setMessage("Request!");
        PrintWriter out =  new PrintWriter(this.socket.getOutputStream(), true);
        out.println(request.getRequestMessage());
        out.flush();
        //out.close();
    }

    public void getRequest(){

        

        //Should this return request???
    }

    public void authenticate(String validate) throws Exception{
        
        PrintWriter out =  new PrintWriter(this.socket.getOutputStream(), true);
        if((validate == "yes") || (validate == "no")){
            out.println(validate);
            out.flush();
        }

        else{
            out.println("Inavlid Entry");
        }

    }

    public String getIPAddress(){
        return this.ip_address;

    }




    public static void main(String[] args) throws NumberFormatException, UnknownHostException, Exception {
        
        Client myClient = new Client(
            InetAddress.getByName("127.0.0.1"), 
            Integer.parseInt("8000"));

        System.out.println("\r\nConnected to Server: " +myClient.socket.getInetAddress());
        myClient.start();
        myClient.listen();
        
    }
}