public class ActionPacket implements Packet {

    private String source;
    private String destination;
    private String protocol;
    private String message;
    private boolean actionComplete;
    private String packetType;


    ActionPacket(String packetType){
        
        this.packetType = packetType;
        this.source = "127.0.0.1";
        this.destination = "8000";
        this.protocol = "TCP/IP";
    }


  


    ActionPacket(String packetType,String source,String destination){
        
        this.packetType = packetType;
        this.source = source;
        this.destination = destination;
        this.protocol = "TCP/IP";

    }


    ActionPacket(String packetType,String source,String destination,String protocol){

        this.packetType = packetType;
        this.source = source;
        this.destination = destination;
        this.protocol = protocol;
    }



    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String displayMessage(){
        return this.message;

    }
    

    
    @Override
    public boolean actionComplete(){
        return this.actionComplete;

    }
}