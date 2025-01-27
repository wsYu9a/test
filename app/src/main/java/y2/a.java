package y2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* renamed from: y2.a$a */
    public static abstract class AbstractBinderC0847a extends Binder implements a {

        /* renamed from: b */
        public static final String f32952b = "com.samsung.android.deviceidservice.IDeviceIdService";

        /* renamed from: c */
        public static final int f32953c = 1;

        /* renamed from: d */
        public static final int f32954d = 2;

        /* renamed from: e */
        public static final int f32955e = 3;

        public AbstractBinderC0847a() {
            attachInterface(this, f32952b);
        }

        public static a g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f32952b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0848a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f32952b);
                String a10 = a();
                parcel2.writeNoException();
                parcel2.writeString(a10);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f32952b);
                String b10 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b10);
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f32952b);
                return true;
            }
            parcel.enforceInterface(f32952b);
            String a11 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a11);
            return true;
        }

        /* renamed from: y2.a$a$a */
        public static class C0848a implements a {

            /* renamed from: b */
            public IBinder f32956b;

            public C0848a(IBinder iBinder) {
                this.f32956b = iBinder;
            }

            @Override // y2.a
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0847a.f32952b);
                    this.f32956b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f32956b;
            }

            @Override // y2.a
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0847a.f32952b);
                    obtain.writeString(str);
                    this.f32956b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String j() {
                return AbstractBinderC0847a.f32952b;
            }

            @Override // y2.a
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0847a.f32952b);
                    obtain.writeString(str);
                    this.f32956b.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
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
