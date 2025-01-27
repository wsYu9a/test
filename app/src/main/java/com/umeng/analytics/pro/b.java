package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface b extends IInterface {

    public static class a implements b {
        @Override // com.umeng.analytics.pro.b
        public void a(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public void a(int i10, Bundle bundle) throws RemoteException {
        }
    }

    void a(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException;

    void a(int i10, Bundle bundle) throws RemoteException;

    /* renamed from: com.umeng.analytics.pro.b$b */
    public static abstract class AbstractBinderC0666b extends Binder implements b {

        /* renamed from: a */
        static final int f23495a = 1;

        /* renamed from: b */
        static final int f23496b = 2;

        /* renamed from: c */
        private static final String f23497c = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        /* renamed from: com.umeng.analytics.pro.b$b$a */
        public static class a implements b {

            /* renamed from: a */
            public static b f23498a;

            /* renamed from: b */
            private IBinder f23499b;

            public a(IBinder iBinder) {
                this.f23499b = iBinder;
            }

            public String a() {
                return "com.hihonor.cloudservice.oaid.IOAIDCallBack";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23499b;
            }

            @Override // com.umeng.analytics.pro.b
            public void a(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    obtain.writeInt(i10);
                    obtain.writeLong(j10);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeFloat(f10);
                    obtain.writeDouble(d10);
                    obtain.writeString(str);
                    try {
                        if (this.f23499b.transact(1, obtain, obtain2, 0) || AbstractBinderC0666b.a() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                        } else {
                            AbstractBinderC0666b.a().a(i10, j10, z10, f10, d10, str);
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

            @Override // com.umeng.analytics.pro.b
            public void a(int i10, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f23499b.transact(2, obtain, obtain2, 0) && AbstractBinderC0666b.a() != null) {
                        AbstractBinderC0666b.a().a(i10, bundle);
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public AbstractBinderC0666b() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                return true;
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
            a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        public static boolean a(b bVar) {
            if (a.f23498a != null || bVar == null) {
                return false;
            }
            a.f23498a = bVar;
            return true;
        }

        public static b a() {
            return a.f23498a;
        }
    }
}
