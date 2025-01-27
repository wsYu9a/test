package com.opos.ads;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IRemoteOposAdsInterface extends IInterface {
    public static final String DESCRIPTOR = "com.opos.ads.IRemoteOposAdsInterface";

    public static class Default implements IRemoteOposAdsInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.opos.ads.IRemoteOposAdsInterface
        public void setShowSplashFlag(boolean z10) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRemoteOposAdsInterface {
        static final int TRANSACTION_setShowSplashFlag = 1;

        public static class Proxy implements IRemoteOposAdsInterface {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IRemoteOposAdsInterface.DESCRIPTOR;
            }

            @Override // com.opos.ads.IRemoteOposAdsInterface
            public void setShowSplashFlag(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IRemoteOposAdsInterface.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IRemoteOposAdsInterface.DESCRIPTOR);
        }

        public static IRemoteOposAdsInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IRemoteOposAdsInterface.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteOposAdsInterface)) ? new Proxy(iBinder) : (IRemoteOposAdsInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(IRemoteOposAdsInterface.DESCRIPTOR);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(IRemoteOposAdsInterface.DESCRIPTOR);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            setShowSplashFlag(parcel.readInt() != 0);
            parcel2.writeNoException();
            return true;
        }
    }

    void setShowSplashFlag(boolean z10) throws RemoteException;
}
