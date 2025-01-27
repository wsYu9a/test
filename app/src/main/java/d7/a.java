package d7;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface a extends IInterface {
    void b(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException;

    void c(int i10, Bundle bundle) throws RemoteException;

    public static abstract class b extends Binder implements a {

        /* renamed from: b */
        public static final String f25279b = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        /* renamed from: c */
        public static final int f25280c = 1;

        /* renamed from: d */
        public static final int f25281d = 2;

        /* renamed from: d7.a$b$a */
        public static class C0687a implements a {

            /* renamed from: c */
            public static a f25282c;

            /* renamed from: b */
            public IBinder f25283b;

            public C0687a(IBinder iBinder) {
                this.f25283b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25283b;
            }

            @Override // d7.a
            public void b(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f25279b);
                    obtain.writeInt(i10);
                    obtain.writeLong(j10);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeFloat(f10);
                    obtain.writeDouble(d10);
                    obtain.writeString(str);
                    try {
                        if (this.f25283b.transact(1, obtain, obtain2, 0) || b.j() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                        } else {
                            b.j().b(i10, j10, z10, f10, d10, str);
                            obtain2.recycle();
                            obtain.recycle();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }

            @Override // d7.a
            public void c(int i10, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f25279b);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f25283b.transact(2, obtain, obtain2, 0) || b.j() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.j().c(i10, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public String j() {
                return b.f25279b;
            }
        }

        public b() {
            attachInterface(this, f25279b);
        }

        public static a g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f25279b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0687a(iBinder) : (a) queryLocalInterface;
        }

        public static a j() {
            return C0687a.f25282c;
        }

        public static boolean k(a aVar) {
            if (C0687a.f25282c != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (aVar == null) {
                return false;
            }
            C0687a.f25282c = aVar;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f25279b);
                b(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f25279b);
                return true;
            }
            parcel.enforceInterface(f25279b);
            c(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    /* renamed from: d7.a$a */
    public static class C0686a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // d7.a
        public void c(int i10, Bundle bundle) throws RemoteException {
        }

        @Override // d7.a
        public void b(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
        }
    }
}
