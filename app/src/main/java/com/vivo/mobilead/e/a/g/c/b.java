package com.vivo.mobilead.e.a.g.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface b extends IInterface {
    String getOAID() throws RemoteException;

    boolean isSupport() throws RemoteException;

    public static abstract class a extends Binder implements b {

        /* renamed from: com.vivo.mobilead.e.a.g.c.b$a$a */
        private static class C0586a implements b {

            /* renamed from: b */
            public static b f28776b;

            /* renamed from: a */
            private IBinder f28777a;

            C0586a(IBinder iBinder) {
                this.f28777a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28777a;
            }

            @Override // com.vivo.mobilead.e.a.g.c.b
            public String getOAID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.f28777a.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.vivo.mobilead.e.a.g.c.b
            public boolean isSupport() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    if (!this.f28777a.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().isSupport();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0586a(iBinder) : (b) queryLocalInterface;
        }

        public static b a() {
            return C0586a.f28776b;
        }
    }
}
