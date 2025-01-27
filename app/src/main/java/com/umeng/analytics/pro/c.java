package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.umeng.analytics.pro.b;

/* loaded from: classes4.dex */
public interface c extends IInterface {

    public static class a implements c {
        @Override // com.umeng.analytics.pro.c
        public void a(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.c
        public void b(com.umeng.analytics.pro.b bVar) throws RemoteException {
        }

        @Override // com.umeng.analytics.pro.c
        public void a(com.umeng.analytics.pro.b bVar) throws RemoteException {
        }
    }

    void a(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException;

    void a(com.umeng.analytics.pro.b bVar) throws RemoteException;

    void b(com.umeng.analytics.pro.b bVar) throws RemoteException;

    public static abstract class b extends Binder implements c {

        /* renamed from: a */
        static final int f23713a = 1;

        /* renamed from: b */
        static final int f23714b = 2;

        /* renamed from: c */
        static final int f23715c = 3;

        /* renamed from: d */
        private static final String f23716d = "com.hihonor.cloudservice.oaid.IOAIDService";

        public static class a implements c {

            /* renamed from: a */
            public static c f23717a;

            /* renamed from: b */
            private IBinder f23718b;

            public a(IBinder iBinder) {
                this.f23718b = iBinder;
            }

            public String a() {
                return "com.hihonor.cloudservice.oaid.IOAIDService";
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f23718b;
            }

            @Override // com.umeng.analytics.pro.c
            public void b(com.umeng.analytics.pro.b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.f23718b.transact(3, obtain, obtain2, 0) || b.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        b.a().b(bVar);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // com.umeng.analytics.pro.c
            public void a(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeInt(i10);
                    obtain.writeLong(j10);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeFloat(f10);
                    obtain.writeDouble(d10);
                    obtain.writeString(str);
                    try {
                        if (this.f23718b.transact(1, obtain, obtain2, 0) || b.a() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                        } else {
                            b.a().a(i10, j10, z10, f10, d10, str);
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

            @Override // com.umeng.analytics.pro.c
            public void a(com.umeng.analytics.pro.b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (!this.f23718b.transact(2, obtain, obtain2, 0) && b.a() != null) {
                        b.a().a(bVar);
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

        public b() {
            attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDService");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                a(b.AbstractBinderC0666b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDService");
                return true;
            }
            parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDService");
            b(b.AbstractBinderC0666b.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static boolean a(c cVar) {
            if (a.f23717a != null || cVar == null) {
                return false;
            }
            a.f23717a = cVar;
            return true;
        }

        public static c a() {
            return a.f23717a;
        }
    }
}
