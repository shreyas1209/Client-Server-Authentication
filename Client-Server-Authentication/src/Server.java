import java.io.*;
import java.net.*;

public class Server {
    private String ipAddress;
    private ServerSocket socket;
    private int port;
    private InputStream inputStream;
    private DataInputStream dataInputStream;
    
    public Server(String ipAddress,int port) throws IOException{
        this.ipAddress = ipAddress;
        this.port = port;
        if(ipAddress != null && !ipAddress.isEmpty()){
            this.socket = new ServerSocket(this.port,1,InetAddress.getByName(this.ipAddress));
        }
        else{
            this.socket = new ServerSocket(this.port,1,InetAddress.getLocalHost());
        }
    }

    public void listen() throws Exception{
        String data = null;
        Socket client = this.socket.accept();
        String clientAddress = client.getInetAddress().getHostAddress();
        System.out.println("\nNew connection from : "+ clientAddress);
        inputStream = client.getInputStream();
        dataInputStream = new DataInputStream(inputStream);
        String msg = dataInputStream.readUTF();
        System.out.println("The message sent from the socket was: "+ msg);
        
    }

    public InetAddress getSocket(){
        return this.socket.getInetAddress();
    }

    public int getPort(){
        return this.socket.getLocalPort();
    }

    public void sendResponse(){
        //need to implement it
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        Server myServer = new Server ("127.0.0.1x",8000);//(args[0],Integer.parseInt(args[1]));

        System.out.println("\nRunning Server:"+
        "\nHost : "+ myServer.getSocket().getHostAddress()
        +"\nPort :"+ myServer.getPort());
        
    }
    
    
}
