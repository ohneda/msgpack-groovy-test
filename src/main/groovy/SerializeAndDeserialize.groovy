import org.msgpack.MessagePack

Message src = new Message(str: "msgpack", num: 0.4)
MessagePack.register(Message.class)

// Serialize
byte[] raw = MessagePack.pack(src)
println raw

// Deserialize
Message dst = MessagePack.unpack(raw, Message.class)
println dst.str
println dst.num