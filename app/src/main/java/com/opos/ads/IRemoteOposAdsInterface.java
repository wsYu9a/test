package com.opos.ads;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface IRemoteOposAdsInterface extends IInterface {

    public static class Default implements IRemoteOposAdsInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.opos.ads.IRemoteOposAdsInterface
        public void setShowSplashFlag(boolean aShowSplashFlag) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRemoteOposAdsInterface {
        private static final String DESCRIPTOR = "com.opos.ads.IRemoteOposAdsInterface";
        static final int TRANSACTION_setShowSplashFlag = 1;

        private static class Proxy implements IRemoteOposAdsInterface {
            public static IRemoteOposAdsInterface sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.opos.ads.IRemoteOposAdsInterface
            public void setShowSplashFlag(boolean aShowSplashFlag) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(aShowSplashFlag ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().setShowSplashFlag(aShowSplashFlag);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteOposAdsInterface asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface queryLocalInterface = obj.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteOposAdsInterface)) ? new Proxy(obj) : (IRemoteOposAdsInterface) queryLocalInterface;
        }

        public static IRemoteOposAdsInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteOposAdsInterface impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl == null) {
                return false;
            }
            Proxy.sDefaultImpl = impl;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) {
                if (code != 1598968902) {
                    return super.onTransact(code, data, reply, flags);
                }
                reply.writeString(DESCRIPTOR);
                return true;
            }
            data.enforceInterface(DESCRIPTOR);
            setShowSplashFlag(data.readInt() != 0);
            reply.writeNoException();
            return true;
        }
    }

    void setShowSplashFlag(boolean aShowSplashFlag) throws RemoteException;
}
