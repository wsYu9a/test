package h.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes5.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: h.a.a.b$a$a */
        public static class C0828a implements b {

            /* renamed from: a */
            public IBinder f35309a;

            public C0828a(IBinder iBinder) {
                this.f35309a = iBinder;
            }

            @Override // h.a.a.b
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.stdid.IStdID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f35309a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35309a;
            }
        }

        public static b b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.stdid.IStdID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0828a(iBinder) : (b) queryLocalInterface;
        }
    }

    String a(String str, String str2, String str3);
}
