package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes4.dex */
public interface IDownloadForbiddenAidlCallback extends IInterface {

    public static class Default implements IDownloadForbiddenAidlCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
        public boolean hasCallback() throws RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
        public void onCallback(List<String> list) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDownloadForbiddenAidlCallback {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback";
        static final int TRANSACTION_hasCallback = 2;
        static final int TRANSACTION_onCallback = 1;

        private static class Proxy implements IDownloadForbiddenAidlCallback {
            public static IDownloadForbiddenAidlCallback sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
            public boolean hasCallback() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().hasCallback();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
            public void onCallback(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringList(list);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onCallback(list);
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

        public static IDownloadForbiddenAidlCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadForbiddenAidlCallback)) ? new Proxy(iBinder) : (IDownloadForbiddenAidlCallback) queryLocalInterface;
        }

        public static IDownloadForbiddenAidlCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) {
            if (Proxy.sDefaultImpl != null || iDownloadForbiddenAidlCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = iDownloadForbiddenAidlCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onCallback(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean hasCallback = hasCallback();
            parcel2.writeNoException();
            parcel2.writeInt(hasCallback ? 1 : 0);
            return true;
        }
    }

    boolean hasCallback() throws RemoteException;

    void onCallback(List<String> list) throws RemoteException;
}
