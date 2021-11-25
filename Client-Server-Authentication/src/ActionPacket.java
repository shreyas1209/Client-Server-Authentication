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
        this.destination = "127.0.0.1";
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

    public String getSource(){
        return this.source;
    }

    public String getDestination(){
        return this.destination;
    }

    public String getProtocol(){
        return this.protocol;
    }
}