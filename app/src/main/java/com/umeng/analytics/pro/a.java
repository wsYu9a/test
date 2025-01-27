package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface a extends IInterface {

    /* renamed from: com.umeng.analytics.pro.a$a */
    public static class C0664a implements a {
        @Override // com.umeng.analytics.pro.a
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String b() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String c(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String d(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String e(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public boolean a() throws RemoteException {
            return false;
        }

        @Override // com.umeng.analytics.pro.a
        public String b(String str) throws RemoteException {
            return null;
        }
    }

    String a(String str) throws RemoteException;

    boolean a() throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    String c(String str) throws RemoteException;

    String d(String str) throws RemoteException;

    String e(String str) throws RemoteException;

    public static abstract class b extends Binder implements a {

        /* renamed from: a */
        static final int f23371a = 1;

        /* renamed from: b */
        static final int f23372b = 2;

        /* renamed from: c */
        static final int f23373c = 3;

        /* renamed from: d */
        static final int f23374d = 4;

        /* renamed from: e */
        static final int f23375e = 5;

        /* renamed from: f */
        static final int f23376f = 6;

        /* renamed from: g */
        static final int f23377g = 7;

        /* renamed from: h */
        private static final String f23378h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        /* renamed from: com.umeng.analytics.pro.a$b$a */
        public static class C0665a implements a {

            /* renamed from: a */
            public static a f23379a;

            /* renamed from: b */
            private IBinder f23380b;

            public C0665a(IBinder iBinder) {
                this.f23380b = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f23378h);
                    obtain.writeString(str);
                    if (!this.f23380b.transact(1, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a(str);
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
                return this.f23380b;
            }

            @Override // com.umeng.analytics.pro.a
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f23378h);
                    obtain.writeString(str);
                    if (!this.f23380b.transact(2, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return b.f23378h;
            }

            @Override // com.umeng.analytics.pro.a
            public String d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f23378h);
                    obtain.writeString(str);
                    if (!this.f23380b.transact(4, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().d(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f23378h);
                    obtain.writeString(str);
                    if (!this.f23380b.transact(5, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().e(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f23378h);
                    obtain.writeString(str);
                    if (!this.f23380b.transact(3, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f23378h);
                    if (!this.f23380b.transact(6, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f23378h);
                    if (!this.f23380b.transact(7, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b();
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
            attachInterface(this, f23378h);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f23378h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0665a(iBinder) : (a) queryLocalInterface;
        }

        public static a c() {
            return C0665a.f23379a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f23378h);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f23378h);
                    String a10 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a10);
                    return true;
                case 2:
                    parcel.enforceInterface(f23378h);
                    String b10 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b10);
                    return true;
                case 3:
                    parcel.enforceInterface(f23378h);
                    String c10 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(c10);
                    return true;
                case 4:
                    parcel.enforceInterface(f23378h);
                    String d10 = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(d10);
                    return true;
                case 5:
                    parcel.enforceInterface(f23378h);
                    String e10 = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(e10);
                    return true;
                case 6:
                    parcel.enforceInterface(f23378h);
                    boolean a11 = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a11 ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(f23378h);
                    String b11 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b11);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        public static boolean a(a aVar) {
            if (C0665a.f23379a != null || aVar == null) {
                return false;
            }
            C0665a.f23379a = aVar;
            return true;
        }
    }
}
