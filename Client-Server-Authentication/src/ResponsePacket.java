import java.io.*;


public class ResponsePacket extends ActionPacket{

    private String data;

    ResponsePacket(String data){

        super("Response");
        this.data = data;
    }


    ResponsePacket(String source,String destination, String data){

        super("Response", source, destination);
        this.data = data;
    }

    ResponsePacket(String source,String destination,String protocol,String data){

        super("Response", source, destination, protocol);
        this.data = data;
    }


    public String getResponseMessage() {
        return super.displayMessage();
    }


    public void setResponseMessage(String message) {
        super.setMessage(message);
    }

    @Override
    public String toString(){
        String output = 
        "{ Source IP: "+ super.getSource()+", "+
        "Destination IP: " + super.getDestination()+", "+
        "Protocol: "+ super.getProtocol()+", "+
        "Data: " + this.data+"}";

        return output;
    }
}