package lj;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import y2.a;

/* loaded from: classes4.dex */
public interface a extends IInterface {

    /* renamed from: lj.a$a */
    public static abstract class AbstractBinderC0739a extends Binder implements a {

        /* renamed from: b */
        public static final /* synthetic */ int f28140b = 0;

        /* renamed from: lj.a$a$a */
        public static class C0740a implements a {

            /* renamed from: b */
            public IBinder f28141b;

            public C0740a(IBinder iBinder) {
                this.f28141b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f28141b;
            }

            @Override // lj.a
            public final String getAAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.AbstractBinderC0847a.f32952b);
                    obtain.writeString(str);
                    this.f28141b.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // lj.a
            public final String getOAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.AbstractBinderC0847a.f32952b);
                    this.f28141b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // lj.a
            public final String getVAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.AbstractBinderC0847a.f32952b);
                    obtain.writeString(str);
                    this.f28141b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    String getAAID(String str);

    String getOAID();

    String getVAID(String str);
}
