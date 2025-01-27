package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface d extends IInterface {

    public static class a implements d {
        @Override // com.umeng.analytics.pro.d
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.d
        public String b(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.d
        public String a(String str) throws RemoteException {
            return null;
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    public static abstract class b extends Binder implements d {

        /* renamed from: a */
        static final int f23791a = 1;

        /* renamed from: b */
        static final int f23792b = 2;

        /* renamed from: c */
        static final int f23793c = 3;

        /* renamed from: d */
        private static final String f23794d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public static class a implements d {

            /* renamed from: a */
            public static d f23795a;

            /* renamed from: b */
            private IBinder f23796b;

            public a(IBinder iBinder) {
                this.f23796b = iBinder;
            }

            @Override // com.umeng.analytics.pro.d
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.f23796b.transact(1, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23796b;
            }

            public String b() {
                return "com.samsung.android.deviceidservice.IDeviceIdService";
            }

            @Override // com.umeng.analytics.pro.d
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.f23796b.transact(3, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.d
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.f23796b.transact(2, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new a(iBinder) : (d) queryLocalInterface;
        }

        public static d b() {
            return a.f23795a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a10 = a();
                parcel2.writeNoException();
                parcel2.writeString(a10);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a11 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a11);
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            }
            parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            String b10 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b10);
            return true;
        }

        public static boolean a(d dVar) {
            if (a.f23795a != null || dVar == null) {
                return false;
            }
            a.f23795a = dVar;
            return true;
        }
    }
}
