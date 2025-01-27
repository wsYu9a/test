package com.czhj.devicehelper.oaId.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.czhj.sdk.logger.SigmobLog;
import k3.a;

/* loaded from: classes2.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* renamed from: com.czhj.devicehelper.oaId.interfaces.c$a$a */
        public static class C0247a implements c {

            /* renamed from: a */
            public IBinder f8361a;

            public C0247a(IBinder iBinder) {
                this.f8361a = iBinder;
            }

            @Override // com.czhj.devicehelper.oaId.interfaces.c
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                        this.f8361a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e10) {
                        SigmobLog.e(e10.getMessage());
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return null;
            }

            @Override // com.czhj.devicehelper.oaId.interfaces.c
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                        this.f8361a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e10) {
                        SigmobLog.e(e10.getMessage());
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.czhj.devicehelper.oaId.interfaces.c
            public String f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                        this.f8361a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e10) {
                        SigmobLog.e(e10.getMessage());
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.czhj.devicehelper.oaId.interfaces.c
            public String g() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                        this.f8361a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e10) {
                        SigmobLog.e(e10.getMessage());
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.czhj.devicehelper.oaId.interfaces.c
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                    this.f8361a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    r2 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                }
                return r2;
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0721a.f27611b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0247a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(a.AbstractBinderC0721a.f27611b);
                return true;
            }
            if (i10 == 1) {
                parcel.enforceInterface(a.AbstractBinderC0721a.f27611b);
                String g10 = g();
                parcel2.writeNoException();
                parcel2.writeString(g10);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(a.AbstractBinderC0721a.f27611b);
                String f10 = f();
                parcel2.writeNoException();
                parcel2.writeString(f10);
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface(a.AbstractBinderC0721a.f27611b);
                boolean b10 = b();
                parcel2.writeNoException();
                parcel2.writeInt(b10 ? 1 : 0);
                return true;
            }
            if (i10 == 4) {
                parcel.enforceInterface(a.AbstractBinderC0721a.f27611b);
                String a10 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a10);
                return true;
            }
            if (i10 != 5) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface(a.AbstractBinderC0721a.f27611b);
            String b11 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b11);
            return true;
        }
    }

    String a(String str);

    String b(String str);

    boolean b();

    String f();

    String g();
}
