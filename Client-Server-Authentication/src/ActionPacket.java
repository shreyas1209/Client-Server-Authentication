public class ActionPacket implements Packet {

    private String source;
    private String destination;
    private String protocol;
    private String message;
    private boolean actionComplete;


    ActionPacket(){
        
        this.source = "127.0.0.1";
        this.destination = "8000";
        this.protocol = "TCP/IP";
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    ActionPacket(String source,String destination){
        
        this.source = source;
        this.destination = destination;
        this.protocol = "TCP/IP";

    }


    ActionPacket(String source,String destination,String protocol){

        this.source = source;
        this.destination = destination;
        this.protocol = protocol;
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