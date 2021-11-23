import java.io.*;


public class ResponsePacket extends ActionPacket{



    ResponsePacket(){

        super("Response");
    }


    ResponsePacket(String source,String destination){

        super("Response", source, destination);
    }

    ResponsePacket(String source,String destination,String protocol){

        super("Response", source, destination, protocol);
    
    }


    public String getResponseMessage() {
        return super.displayMessage();
    }


    public void setResponseMessage(String message) {
        super.setMessage(message);
    }
}