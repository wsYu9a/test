package d2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: d2.a$a */
    public static abstract class AbstractBinderC0684a extends Binder implements a {

        /* renamed from: d2.a$a$a */
        public static class C0685a implements a {

            /* renamed from: b */
            public IBinder f25227b;

            public C0685a(IBinder iBinder) {
                this.f25227b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25227b;
            }

            public String g(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f25227b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0685a(iBinder) : (a) queryLocalInterface;
        }
    }
}
