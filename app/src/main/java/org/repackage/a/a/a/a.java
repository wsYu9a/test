package org.repackage.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes5.dex */
public interface a extends IInterface {

    /* renamed from: org.repackage.a.a.a.a$a */
    public static abstract class AbstractBinderC0831a extends Binder implements a {

        /* renamed from: org.repackage.a.a.a.a$a$a */
        public static class C0832a implements a {

            /* renamed from: a */
            public IBinder f35549a;

            public C0832a(IBinder iBinder) {
                this.f35549a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f35549a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35549a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0832a(iBinder) : (a) queryLocalInterface;
        }
    }
}
