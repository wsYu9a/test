package com.czhj.devicehelper.oaId.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        /* renamed from: com.czhj.devicehelper.oaId.interfaces.g$a$a, reason: collision with other inner class name */
        public static class C0250a implements g {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f8365a;

            public C0250a(IBinder iBinder) {
                this.f8365a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8365a;
            }

            @Override // com.czhj.devicehelper.oaId.interfaces.g
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f8365a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        return false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return true;
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    th2.printStackTrace();
                    return false;
                }
            }

            @Override // com.czhj.devicehelper.oaId.interfaces.g
            public void d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f8365a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } catch (Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                }
                obtain2.recycle();
                obtain.recycle();
            }

            @Override // com.czhj.devicehelper.oaId.interfaces.g
            public boolean e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f8365a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } catch (Exception unused) {
                    obtain2.recycle();
                    obtain.recycle();
                    return false;
                }
            }

            @Override // com.czhj.devicehelper.oaId.interfaces.g
            public String h() {
                String str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f8365a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused) {
                    obtain.recycle();
                    obtain2.recycle();
                    str = null;
                }
                obtain.recycle();
                obtain2.recycle();
                return str;
            }
        }
    }

    boolean b();

    void d();

    boolean e();

    String h();
}
