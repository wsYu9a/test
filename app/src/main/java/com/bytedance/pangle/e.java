package com.bytedance.pangle;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.g;

/* loaded from: classes2.dex */
public interface e extends IInterface {
    ComponentName a(Intent intent, String str);

    void a(g gVar);

    boolean a(Intent intent, g gVar, int i10, String str);

    boolean b(Intent intent, String str);

    public static abstract class a extends Binder implements e {
        public a() {
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C0229a(iBinder) : (e) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                ComponentName a10 = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                if (a10 != null) {
                    parcel2.writeInt(1);
                    a10.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean b10 = b(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b10 ? 1 : 0);
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean a11 = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, g.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a11 ? 1 : 0);
                return true;
            }
            if (i10 != 4) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.bytedance.pangle.IServiceManager");
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
            a(g.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static e a() {
            return C0229a.f7551a;
        }

        /* renamed from: com.bytedance.pangle.e$a$a */
        public static class C0229a implements e {

            /* renamed from: a */
            public static e f7551a;

            /* renamed from: b */
            private IBinder f7552b;

            public C0229a(IBinder iBinder) {
                this.f7552b = iBinder;
            }

            @Override // com.bytedance.pangle.e
            public final ComponentName a(Intent intent, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.f7552b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        ComponentName a10 = a.a().a(intent, str);
                        obtain2.recycle();
                        obtain.recycle();
                        return a10;
                    }
                    obtain2.readException();
                    ComponentName componentName = obtain2.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return componentName;
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f7552b;
            }

            @Override // com.bytedance.pangle.e
            public final boolean b(Intent intent, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.f7552b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        boolean b10 = a.a().b(intent, str);
                        obtain2.recycle();
                        obtain.recycle();
                        return b10;
                    }
                    obtain2.readException();
                    boolean z10 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // com.bytedance.pangle.e
            public final boolean a(Intent intent, g gVar, int i10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    if (!this.f7552b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        boolean a10 = a.a().a(intent, gVar, i10, str);
                        obtain2.recycle();
                        obtain.recycle();
                        return a10;
                    }
                    obtain2.readException();
                    boolean z10 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // com.bytedance.pangle.e
            public final void a(g gVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    if (!this.f7552b.transact(4, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(gVar);
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
        }
    }
}
