
public class RequestPacket extends ActionPacket{


    RequestPacket(){

        super("Request");
    }


    RequestPacket(String source,String destination){

        super("Request", source, destination);
    }

    RequestPacket(String source,String destination,String protocol){

        super("Request", source, destination, protocol);
    }

    public void setMessage(String message){
        super.setMessage(message);
    }

    public String getRequestMessage(){
        return super.displayMessage();
    }    
    @Override
    public String toString(){
        return this.getRequestMessage();
    }
}
