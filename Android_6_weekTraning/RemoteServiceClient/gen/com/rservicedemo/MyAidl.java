/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: F:\\Android 6 week\\RemoteServiceClient\\src\\com\\rservicedemo\\MyAidl.aidl
 */
package com.rservicedemo;
public interface MyAidl extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.rservicedemo.MyAidl
{
private static final java.lang.String DESCRIPTOR = "com.rservicedemo.MyAidl";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.rservicedemo.MyAidl interface,
 * generating a proxy if needed.
 */
public static com.rservicedemo.MyAidl asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.rservicedemo.MyAidl))) {
return ((com.rservicedemo.MyAidl)iin);
}
return new com.rservicedemo.MyAidl.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getCount:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCount();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.rservicedemo.MyAidl
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public int getCount() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public int getCount() throws android.os.RemoteException;
}
