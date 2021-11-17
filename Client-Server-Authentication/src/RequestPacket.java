
public class RequestPacket extends ActionPacket{
    private String source;
    private String destination;
    private String protocol;
    private String message;
    private boolean actionComplete;

    RequestPacket(){
        this.source = "127.0.0.1";
        this.destination = "8000";
        this.protocol = "TCP/IP";
    }

    RequestPacket(String source,String destination){
        this.source = source;
        this.destination = destination;
        this.protocol = "TCP/IP";

    }

    RequestPacket(String source,String destination,String protocol){
        this.source = source;
        this.destination = destination;
        this.protocol = protocol;
        

    }

    

    
    
}
