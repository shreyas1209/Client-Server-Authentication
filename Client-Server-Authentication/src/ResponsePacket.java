import java.io.*;


public class ResponsePacket implements Packet{

    private String source;
    private String destination;
    private String protocol;
    private String message;


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
