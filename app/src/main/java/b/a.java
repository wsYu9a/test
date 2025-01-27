package b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import k3.a;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0011a extends Binder implements a {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f1088b = 0;

        /* renamed from: b.a$a$a, reason: collision with other inner class name */
        public static class C0012a implements a {

            /* renamed from: b, reason: collision with root package name */
            public IBinder f1089b;

            public C0012a(IBinder iBinder) {
                this.f1089b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f1089b;
            }

            @Override // b.a
            public final String getAAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                    obtain.writeString(str);
                    this.f1089b.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b.a
            public final String getOAID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                    this.f1089b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b.a
            public final String getUDID() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                    this.f1089b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b.a
            public final String getVAID(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                    obtain.writeString(str);
                    this.f1089b.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // b.a
            public final boolean l() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                    this.f1089b.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    String getAAID(String str);

    String getOAID();

    String getUDID();

    String getVAID(String str);

    boolean l();
}
