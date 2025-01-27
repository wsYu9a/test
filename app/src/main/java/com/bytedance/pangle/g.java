package com.bytedance.pangle;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface g extends IInterface {
    int a();

    void a(ComponentName componentName, IBinder iBinder);

    public static abstract class a extends Binder implements g {
        public a() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof g)) ? new C0230a(iBinder) : (g) queryLocalInterface;
        }

        public static g b() {
            return C0230a.f7624a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                a(parcel.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
            int a10 = a();
            parcel2.writeNoException();
            parcel2.writeInt(a10);
            return true;
        }

        /* renamed from: com.bytedance.pangle.g$a$a, reason: collision with other inner class name */
        public static class C0230a implements g {

            /* renamed from: a, reason: collision with root package name */
            public static g f7624a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f7625b;

            public C0230a(IBinder iBinder) {
                this.f7625b = iBinder;
            }

            @Override // com.bytedance.pangle.g
            public final void a(ComponentName componentName, IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f7625b.transact(1, obtain, obtain2, 0) || a.b() == null) {
                        obtain2.readException();
                    } else {
                        a.b().a(componentName, iBinder);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f7625b;
            }

            @Override // com.bytedance.pangle.g
            public final int a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (!this.f7625b.transact(2, obtain, obtain2, 0) && a.b() != null) {
                        return a.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
