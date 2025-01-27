package com.vivo.mobilead.e.a.g.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface a extends IInterface {
    String getOAID() throws RemoteException;

    /* renamed from: com.vivo.mobilead.e.a.g.c.a$a */
    public static abstract class AbstractBinderC0584a extends Binder implements a {

        /* renamed from: com.vivo.mobilead.e.a.g.c.a$a$a */
        private static class C0585a implements a {

            /* renamed from: b */
            public static a f28774b;

            /* renamed from: a */
            private IBinder f28775a;

            C0585a(IBinder iBinder) {
                this.f28775a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28775a;
            }

            @Override // com.vivo.mobilead.e.a.g.c.a
            public String getOAID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.f28775a.transact(1, obtain, obtain2, 0) && AbstractBinderC0584a.a() != null) {
                        return AbstractBinderC0584a.a().getOAID();
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
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0585a(iBinder) : (a) queryLocalInterface;
        }

        public static a a() {
            return C0585a.f28774b;
        }
    }
}
