import org.msgpack.rpc.Server
import org.msgpack.rpc.loop.EventLoop
import org.msgpack.MessagePack

class RPCServerTest {
    public Message getMessage(String message, Double num){
        new Message( str: message, num: num)
    }

}


EventLoop loop = EventLoop.defaultEventLoop();
MessagePack.register(Message.class)
Server svr = new Server(loop)
svr.serve(new RPCServerTest())
svr.listen(1985)
println 'start.'
loop.join()