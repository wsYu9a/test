package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface c extends IInterface {
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
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0068a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int b2 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b2);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.bytedance.pangle.IPackageManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
            boolean a3 = a(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(a3 ? 1 : 0);
            return true;
        }

        public static c a() {
            return C0068a.f6004a;
        }

        /* renamed from: com.bytedance.pangle.c$a$a, reason: collision with other inner class name */
        static class C0068a implements c {

            /* renamed from: a, reason: collision with root package name */
            public static c f6004a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f6005b;

            C0068a(IBinder iBinder) {
                this.f6005b = iBinder;
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f6005b.transact(1, obtain, obtain2, 0) && a.a() != null) {
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
                return this.f6005b;
            }

            @Override // com.bytedance.pangle.c
            public final int b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.f6005b.transact(2, obtain, obtain2, 0) && a.a() != null) {
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
                    if (!this.f6005b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str, str2);
                    }
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
