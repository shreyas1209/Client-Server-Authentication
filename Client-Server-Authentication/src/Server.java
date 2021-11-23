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
            this.socket = new ServerSocket(this.port, 1, InetAddress.getByName(this.ipAddress));
        }
        else{
            this.socket = new ServerSocket(this.port, 1, InetAddress.getLocalHost());
        }
    }

    public void listen() throws Exception{
        String data = null;
        Socket client = this.socket.accept();
        String clientAddress = client.getInetAddress().getHostAddress();
        System.out.println("\nNew connection from : "+ clientAddress);
        inputStream = client.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        data = in.readLine();
        
        System.out.println("\r\nMessage from  Client at " + clientAddress + ": " + data);

        if(data != null){
            this.sendPromptMessage(client);

        }
    }

    
    public InetAddress getSocket(){
        return this.socket.getInetAddress();
    }

    public int getPort(){
        return this.socket.getLocalPort();
    }

    public void sendPromptMessage(Socket client) throws IOException{

        PrintWriter serverOut = new PrintWriter(client.getOutputStream(),true);
        serverOut.println("Have you sent the request packet? ");
        serverOut.flush();
        //serverOut.close();     
    }
    
    public static void main(String[] args) throws Exception {
        Server myServer = new Server ("127.0.0.1", 8000); //(args[0],Integer.parseInt(args[1]));

        System.out.println("\nRunning Server:"+
        "\nHost : "+ myServer.getSocket().getHostAddress()
        +"\nPort :"+ myServer.getPort());

        try{
            myServer.listen();
        }catch(java.net.SocketException e){
            System.out.println(e);
        }
    }   
}
