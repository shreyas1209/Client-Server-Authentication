import java.io.*;


public class ResponsePacket extends ActionPacket{

    private String source;
    private String destination;
    private String protocol;
    private String message;


    ResponsePacket(){

        super("Response");
    }


    ResponsePacket(String source,String destination){

        super("Response",source,destination);

    }

    ResponsePacket(String source,String destination,String protocol){

        super("Response",source,destination,protocol);
    
    }


    public String getResponseMessage() {
        return super.displayMessage();
    }


    public void setResponseMessage(String message) {
        super.setMessage(message);
    }


    @Override
    public boolean actionComplete() {
        // TODO Auto-generated method stub
        return false;
    }

 
    @Override
    public String displayMessage() {
        // TODO Auto-generated method stub
        return null;
    }
}
