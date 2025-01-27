package org.repackage.com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IDeviceidInterface extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* renamed from: a */
        static final int f35619a = 1;

        /* renamed from: b */
        static final int f35620b = 2;

        /* renamed from: c */
        static final int f35621c = 3;

        /* renamed from: d */
        static final int f35622d = 4;

        /* renamed from: e */
        static final int f35623e = 5;

        /* renamed from: f */
        static final int f35624f = 6;

        /* renamed from: g */
        private static final String f35625g = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        public Stub() {
            attachInterface(this, f35625g);
        }

        public static IDeviceidInterface a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f35625g);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceidInterface)) ? new Proxy(iBinder) : (IDeviceidInterface) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f35625g);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f35625g);
                    String a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface(f35625g);
                    String b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 3:
                    parcel.enforceInterface(f35625g);
                    boolean c2 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c2 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f35625g);
                    String a3 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a3);
                    return true;
                case 5:
                    parcel.enforceInterface(f35625g);
                    String b3 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b3);
                    return true;
                case 6:
                    parcel.enforceInterface(f35625g);
                    boolean c3 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c3 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        private static class Proxy implements IDeviceidInterface {

            /* renamed from: a */
            private IBinder f35626a;

            Proxy(IBinder iBinder) {
                this.f35626a = iBinder;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f35625g);
                    this.f35626a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35626a;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f35625g);
                    this.f35626a.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(Stub.f35625g);
                    this.f35626a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String d() {
                return Stub.f35625g;
            }

            @Override // org.repackage.com.zui.deviceidservice.IDeviceidInterface
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.f35625g);
                    obtain.writeString(str);
                    this.f35626a.transact(4, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(Stub.f35625g);
                    obtain.writeString(str);
                    this.f35626a.transact(5, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(Stub.f35625g);
                    obtain.writeString(str);
                    this.f35626a.transact(6, obtain, obtain2, 0);
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
