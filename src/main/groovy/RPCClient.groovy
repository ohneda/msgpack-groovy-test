import org.msgpack.rpc.Client
import org.msgpack.rpc.loop.EventLoop

interface RPCInterface {
    Message getMessage(String message, Double num)
}

EventLoop loop = EventLoop.defaultEventLoop()
Client cli = new Client("localhost", 1985, loop);
RPCInterface iface = cli.proxy(RPCInterface.class);
Message message = iface.getMessage("hello", 1.0)
println message.str
println message.num
cli.getEventLoop().shutdown()
cli.close()

