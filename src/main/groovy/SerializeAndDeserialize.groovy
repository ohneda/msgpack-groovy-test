import org.msgpack.MessagePack
import org.msgpack.template.FieldList
import org.msgpack.template.FieldOption

MessagePack.register(Message.class)

Date today = new Date()
Message src = new Message(str: "msgpack", num: 0.4, date: today)

// Serialize
byte[] raw = MessagePack.pack(src)
println raw

// Deserialize
Message dst = MessagePack.unpack(raw, Message.class)
assert dst.str == 'msgpack'
assert dst.num == 0.4
assert dst.date == today

// with field list
FieldList fl = new FieldList()
fl.add( "str" )
fl.add( "date", FieldOption.IGNORE)
fl.add( "num" )
// this register method with field list doesn't work if target class doens't have @MessagePackMessage annotation.
MessagePack.register(Message.class, fl)
raw = MessagePack.pack(src)
dst = MessagePack.unpack(raw, Message.class)

assert dst.str == 'msgpack'
assert dst.num == 0.4
assert dst.date == null
