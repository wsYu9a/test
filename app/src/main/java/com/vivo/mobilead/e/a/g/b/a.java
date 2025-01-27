package com.vivo.mobilead.e.a.g.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface a extends IInterface {
    boolean n() throws RemoteException;

    String o() throws RemoteException;

    /* renamed from: com.vivo.mobilead.e.a.g.b.a$a */
    public static abstract class AbstractBinderC0582a extends Binder implements a {

        /* renamed from: com.vivo.mobilead.e.a.g.b.a$a$a */
        private static class C0583a implements a {

            /* renamed from: b */
            public static a f28772b;

            /* renamed from: a */
            private IBinder f28773a;

            C0583a(IBinder iBinder) {
                this.f28773a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28773a;
            }

            @Override // com.vivo.mobilead.e.a.g.b.a
            public boolean n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.f28773a.transact(2, obtain, obtain2, 0) && AbstractBinderC0582a.a() != null) {
                        return AbstractBinderC0582a.a().n();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.vivo.mobilead.e.a.g.b.a
            public String o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    if (!this.f28773a.transact(1, obtain, obtain2, 0) && AbstractBinderC0582a.a() != null) {
                        return AbstractBinderC0582a.a().o();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0583a(iBinder) : (a) queryLocalInterface;
        }

        public static a a() {
            return C0583a.f28772b;
        }
    }
}
