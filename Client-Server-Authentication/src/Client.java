import java.io.*;
import java.net.*;



public class Client {
    
    private Socket socket;
    private String ip_address;
    
    

    private Client(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
    }


    private void start() throws Exception {
        
        this.sendRequest();
    }

    public void listen() throws Exception{
        String data = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String serverAddress = this.socket.getInetAddress().getHostAddress();
        data = in.readLine();
        System.out.println("\r\nMessage from Server at  " + serverAddress + ": " + data);
        

    }

    public void sendRequest() throws Exception{
        String currentIP = this.getIPAddress();

        RequestPacket request = new RequestPacket(currentIP, this.socket.getInetAddress().getHostAddress(), "TCP/IP");
        request.setMessage("Request!");
        PrintWriter out =  new PrintWriter(this.socket.getOutputStream(), true);
        out.println(request.getRequestMessage());
        System.out.println("Message from Client to Server at "+this.socket.getInetAddress().getHostAddress()+": "+ request.getRequestMessage() );
        
        out.flush();
        
    }

    public void getResponse() throws IOException{

        String response = null;
        BufferedReader responseReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        String serverAddress = this.socket.getInetAddress().getHostAddress();
        response = responseReader.readLine();
        if (response != null){
            System.out.println("SUCCESS: Response received!!!");
            System.out.println("Packet Information:\n");
            System.out.println(response);
        }
        else{
            System.out.println("ERROR: Authentication failure!!!");
        }
        responseReader.close();



        

    }

    public void authenticate(String validate) throws Exception{
        
        PrintWriter out =  new PrintWriter(this.socket.getOutputStream(), true);
        if((validate == "yes") || (validate == "no")){
            out.println(validate);
            System.out.println("Message from Client to Server at "+this.socket.getInetAddress().getHostAddress()+": "+ validate );
            out.flush();
        }

        

    }

    public String getIPAddress(){
        return this.ip_address;

    }




    public static void main(String[] args) throws NumberFormatException, UnknownHostException, Exception {
        try{BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Server IP Address: ");
        String serverIP = br.readLine();
        System.out.println("Enter the Server port to connect: ");
        String serverPort = br.readLine();
        System.out.println("Press Enter to authenticate!");
        String enter = br.readLine();
        if(enter != null){
            Client myClient = new Client(
            InetAddress.getByName(serverIP), 
            Integer.parseInt(serverPort));

        System.out.println("\r\nConnected to Server: " +myClient.socket.getInetAddress());
        myClient.start();
        myClient.listen();
        //System.out.println("Have you sent the request packet?");
        String ans = br.readLine().toLowerCase();
        System.out.println(ans);
        myClient.authenticate(ans);
        myClient.getResponse();

        }
    }catch(java.net.ConnectException e){
        System.out.println(e);

        }



        
    }
}