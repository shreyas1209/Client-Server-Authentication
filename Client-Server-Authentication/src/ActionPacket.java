public class ActionPacket implements Packet {

    private String source;
    private String destination;
    private String protocol;
    private String message;
    private boolean actionComplete;

    @Override
    public String displayMessage(){
        return this.message;

    }
    @Override
    public boolean actionComplete(){
        return this.actionComplete;

    }


    

    
}
