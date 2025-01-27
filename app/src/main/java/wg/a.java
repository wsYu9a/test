package wg;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface a extends IInterface {

    /* renamed from: wg.a$a */
    public static class C0800a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // wg.a
        public boolean e(boolean z10) throws RemoteException {
            return false;
        }

        @Override // wg.a
        public String getId() throws RemoteException {
            return null;
        }
    }

    boolean e(boolean z10) throws RemoteException;

    String getId() throws RemoteException;

    public static abstract class b extends Binder implements a {

        /* renamed from: b */
        public static final String f31713b = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

        /* renamed from: c */
        public static final int f31714c = 1;

        /* renamed from: d */
        public static final int f31715d = 2;

        /* renamed from: wg.a$b$a */
        public static class C0801a implements a {

            /* renamed from: c */
            public static a f31716c;

            /* renamed from: b */
            public IBinder f31717b;

            public C0801a(IBinder iBinder) {
                this.f31717b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f31717b;
            }

            @Override // wg.a
            public boolean e(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f31713b);
                    obtain.writeInt(z10 ? 1 : 0);
                    if (!this.f31717b.transact(2, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().e(z10);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // wg.a
            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f31713b);
                    if (!this.f31717b.transact(1, obtain, obtain2, 0) && b.j() != null) {
                        return b.j().getId();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String j() {
                return b.f31713b;
            }
        }

        public b() {
            attachInterface(this, f31713b);
        }

        public static a g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f31713b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0801a(iBinder) : (a) queryLocalInterface;
        }

        public static a j() {
            return C0801a.f31716c;
        }

        public static boolean k(a aVar) {
            if (C0801a.f31716c != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0801a.f31716c = aVar;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f31713b);
                String id2 = getId();
                parcel2.writeNoException();
                parcel2.writeString(id2);
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f31713b);
                return true;
            }
            parcel.enforceInterface(f31713b);
            boolean e10 = e(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(e10 ? 1 : 0);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
