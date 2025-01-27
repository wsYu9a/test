package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface IRetryDelayTimeAidlCalculator extends IInterface {

    public static class Default implements IRetryDelayTimeAidlCalculator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator
        public long calculateRetryDelayTime(int i2, int i3) throws RemoteException {
            return 0L;
        }
    }

    public static abstract class Stub extends Binder implements IRetryDelayTimeAidlCalculator {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator";
        static final int TRANSACTION_calculateRetryDelayTime = 1;

        private static class Proxy implements IRetryDelayTimeAidlCalculator {
            public static IRetryDelayTimeAidlCalculator sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator
            public long calculateRetryDelayTime(int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().calculateRetryDelayTime(i2, i3);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRetryDelayTimeAidlCalculator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRetryDelayTimeAidlCalculator)) ? new Proxy(iBinder) : (IRetryDelayTimeAidlCalculator) queryLocalInterface;
        }

        public static IRetryDelayTimeAidlCalculator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRetryDelayTimeAidlCalculator iRetryDelayTimeAidlCalculator) {
            if (Proxy.sDefaultImpl != null || iRetryDelayTimeAidlCalculator == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRetryDelayTimeAidlCalculator;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            long calculateRetryDelayTime = calculateRetryDelayTime(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(calculateRetryDelayTime);
            return true;
        }
    }

    long calculateRetryDelayTime(int i2, int i3) throws RemoteException;
}
