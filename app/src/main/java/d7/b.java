package d7;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import d7.a;

/* loaded from: classes2.dex */
public interface b extends IInterface {
    void a(d7.a aVar) throws RemoteException;

    void b(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException;

    void f(d7.a aVar) throws RemoteException;

    /* renamed from: d7.b$b */
    public static abstract class AbstractBinderC0688b extends Binder implements b {

        /* renamed from: b */
        public static final String f25284b = "com.hihonor.cloudservice.oaid.IOAIDService";

        /* renamed from: c */
        public static final int f25285c = 1;

        /* renamed from: d */
        public static final int f25286d = 2;

        /* renamed from: e */
        public static final int f25287e = 3;

        /* renamed from: d7.b$b$a */
        public static class a implements b {

            /* renamed from: c */
            public static b f25288c;

            /* renamed from: b */
            public IBinder f25289b;

            public a(IBinder iBinder) {
                this.f25289b = iBinder;
            }

            @Override // d7.b
            public void a(d7.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0688b.f25284b);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f25289b.transact(3, obtain, obtain2, 0) || AbstractBinderC0688b.j() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        AbstractBinderC0688b.j().a(aVar);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25289b;
            }

            @Override // d7.b
            public void b(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0688b.f25284b);
                    obtain.writeInt(i10);
                    obtain.writeLong(j10);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeFloat(f10);
                    obtain.writeDouble(d10);
                    obtain.writeString(str);
                    try {
                        if (this.f25289b.transact(1, obtain, obtain2, 0) || AbstractBinderC0688b.j() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                        } else {
                            AbstractBinderC0688b.j().b(i10, j10, z10, f10, d10, str);
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

            @Override // d7.b
            public void f(d7.a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0688b.f25284b);
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f25289b.transact(2, obtain, obtain2, 0) || AbstractBinderC0688b.j() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        AbstractBinderC0688b.j().f(aVar);
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
                return AbstractBinderC0688b.f25284b;
            }
        }

        public AbstractBinderC0688b() {
            attachInterface(this, f25284b);
        }

        public static b g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f25284b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(iBinder) : (b) queryLocalInterface;
        }

        public static b j() {
            return a.f25288c;
        }

        public static boolean k(b bVar) {
            if (a.f25288c != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (bVar == null) {
                return false;
            }
            a.f25288c = bVar;
            return true;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f25284b);
                b(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(f25284b);
                f(a.b.g(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(f25284b);
                return true;
            }
            parcel.enforceInterface(f25284b);
            a(a.b.g(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class a implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // d7.b
        public void a(d7.a aVar) throws RemoteException {
        }

        @Override // d7.b
        public void f(d7.a aVar) throws RemoteException {
        }

        @Override // d7.b
        public void b(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
        }
    }
}
