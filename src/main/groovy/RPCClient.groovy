import org.msgpack.rpc.Client
import org.msgpack.rpc.loop.EventLoop

interface RPCInterface {
    Message getMessage(String message, Double num, Date date)
    void setMessage(Message message)
}

EventLoop loop = EventLoop.defaultEventLoop()
Client cli = new Client("localhost", 1985, loop)
RPCInterface iface = cli.proxy(RPCInterface.class)

Date today = new Date()
Message message = iface.getMessage("hello", 1.0, today)

assert message.str == 'hello'
assert message.num == 1.0
assert message.date == today

iface.setMessage(message)
 
cli.getEventLoop().shutdown()
cli.close()

