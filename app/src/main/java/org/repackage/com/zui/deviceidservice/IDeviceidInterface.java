package org.repackage.com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface IDeviceidInterface extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* renamed from: a */
        static final int f29459a = 1;

        /* renamed from: b */
        static final int f29460b = 2;

        /* renamed from: c */
        static final int f29461c = 3;

        /* renamed from: d */
        static final int f29462d = 4;

        /* renamed from: e */
        static final int f29463e = 5;

        /* renamed from: f */
        static final int f29464f = 6;

        /* renamed from: g */
        private static final String f29465g = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        public Stub() {
            attachInterface(this, f29465g);
        }

        public static IDeviceidInterface a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f29465g);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceidInterface)) ? new Proxy(iBinder) : (IDeviceidInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f29465g);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f29465g);
                    String a10 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a10);
                    return true;
                case 2:
                    parcel.enforceInterface(f29465g);
                    String b10 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b10);
                    return true;
                case 3:
                    parcel.enforceInterface(f29465g);
                    boolean c10 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c10 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f29465g);
                    String a11 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a11);
                    return true;
                case 5:
                    parcel.enforceInterface(f29465g);
                    String b11 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b11);
                    return true;
                case 6:
                    parcel.enforceInterface(f29465g);
                    boolean c11 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c11 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        public static class Proxy implements IDeviceidInterface {

            /* renamed from: a */
            private IBinder f29466a;

            public Proxy(IBinder iBinder) {
                this.f29466a = iBinder;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f29465g);
                    this.f29466a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f29466a;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f29465g);
                    this.f29466a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f29465g);
                    this.f29466a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String d() {
                return Stub.f29465g;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f29465g);
                    obtain.writeString(str);
                    this.f29466a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f29465g);
                    obtain.writeString(str);
                    this.f29466a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public boolean c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f29465g);
                    obtain.writeString(str);
                    this.f29466a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
