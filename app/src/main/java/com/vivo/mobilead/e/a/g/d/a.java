package com.vivo.mobilead.e.a.g.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface a extends IInterface {
    String b(String str, String str2, String str3) throws RemoteException;

    /* renamed from: com.vivo.mobilead.e.a.g.d.a$a */
    public static abstract class AbstractBinderC0587a extends Binder implements a {

        /* renamed from: com.vivo.mobilead.e.a.g.d.a$a$a */
        private static class C0588a implements a {

            /* renamed from: b */
            public static a f28778b;

            /* renamed from: a */
            private IBinder f28779a;

            C0588a(IBinder iBinder) {
                this.f28779a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28779a;
            }

            @Override // com.vivo.mobilead.e.a.g.d.a
            public String b(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.f28779a.transact(1, obtain, obtain2, 0) && AbstractBinderC0587a.a() != null) {
                        return AbstractBinderC0587a.a().b(str, str2, str3);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0588a(iBinder) : (a) queryLocalInterface;
        }

        public static a a() {
            return C0588a.f28778b;
        }
    }
}
