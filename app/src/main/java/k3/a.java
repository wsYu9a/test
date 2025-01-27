package k3;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String str) throws RemoteException;

    /* renamed from: k3.a$a */
    public static abstract class AbstractBinderC0721a extends Binder implements a {

        /* renamed from: b */
        public static final String f27611b = "com.zui.deviceidservice.IDeviceidInterface";

        /* renamed from: c */
        public static final int f27612c = 1;

        /* renamed from: d */
        public static final int f27613d = 2;

        /* renamed from: e */
        public static final int f27614e = 3;

        /* renamed from: f */
        public static final int f27615f = 4;

        /* renamed from: g */
        public static final int f27616g = 5;

        /* renamed from: h */
        public static final int f27617h = 6;

        public AbstractBinderC0721a() {
            attachInterface(this, f27611b);
        }

        public static a g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f27611b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0722a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f27611b);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f27611b);
                    String a10 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a10);
                    return true;
                case 2:
                    parcel.enforceInterface(f27611b);
                    String b10 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b10);
                    return true;
                case 3:
                    parcel.enforceInterface(f27611b);
                    boolean c10 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c10 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f27611b);
                    String b11 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b11);
                    return true;
                case 5:
                    parcel.enforceInterface(f27611b);
                    String a11 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a11);
                    return true;
                case 6:
                    parcel.enforceInterface(f27611b);
                    boolean c11 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c11 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        /* renamed from: k3.a$a$a */
        public static class C0722a implements a {

            /* renamed from: b */
            public IBinder f27618b;

            public C0722a(IBinder iBinder) {
                this.f27618b = iBinder;
            }

            @Override // k3.a
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0721a.f27611b);
                    this.f27618b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27618b;
            }

            @Override // k3.a
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0721a.f27611b);
                    this.f27618b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // k3.a
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0721a.f27611b);
                    this.f27618b.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String j() {
                return AbstractBinderC0721a.f27611b;
            }

            @Override // k3.a
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0721a.f27611b);
                    obtain.writeString(str);
                    this.f27618b.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // k3.a
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0721a.f27611b);
                    obtain.writeString(str);
                    this.f27618b.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // k3.a
            public boolean c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0721a.f27611b);
                    obtain.writeString(str);
                    this.f27618b.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
