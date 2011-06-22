import org.msgpack.annotation.MessagePackMessage;

@MessagePackMessage
class Message {
    // public fields are serialized.
    public String str
    public Double num
    public Date date
}
