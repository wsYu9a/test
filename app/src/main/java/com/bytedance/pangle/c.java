package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.d;

/* loaded from: classes2.dex */
public interface c extends IInterface {
    void a(int i10);

    void a(int i10, d dVar);

    boolean a(String str);

    boolean a(String str, String str2);

    int b(String str);

    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0227a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            d c0228a;
            if (i10 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a10 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a10 ? 1 : 0);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int b10 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b10);
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a11 = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a11 ? 1 : 0);
                return true;
            }
            if (i10 != 4) {
                if (i10 != 5) {
                    if (i10 != 1598968902) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel2.writeString("com.bytedance.pangle.IPackageManager");
                    return true;
                }
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            int readInt = parcel.readInt();
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                c0228a = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.bytedance.pangle.IPluginInstallListener");
                c0228a = (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new d.a.C0228a(readStrongBinder) : (d) queryLocalInterface;
            }
            a(readInt, c0228a);
            parcel2.writeNoException();
            return true;
        }

        public static c a() {
            return C0227a.f7481a;
        }

        /* renamed from: com.bytedance.pangle.c$a$a */
        public static class C0227a implements c {

            /* renamed from: a */
            public static c f7481a;

            /* renamed from: b */
            private IBinder f7482b;

            public C0227a(IBinder iBinder) {
                this.f7482b = iBinder;
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f7482b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f7482b;
            }

            @Override // com.bytedance.pangle.c
            public final int b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f7482b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f7482b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final void a(int i10, d dVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i10);
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (!this.f7482b.transact(4, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(i10, dVar);
                    } else {
                        obtain2.readException();
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // com.bytedance.pangle.c
            public final void a(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeInt(i10);
                    if (!this.f7482b.transact(5, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(i10);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
