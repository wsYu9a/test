package ih;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import h2.b;

/* loaded from: classes4.dex */
public final class a implements IInterface {

    /* renamed from: b */
    public IBinder f27007b;

    public a(IBinder iBinder) {
        this.f27007b = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f27007b;
    }

    public final String j() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(b.f26378a);
            this.f27007b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean k() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(b.f26378a);
            this.f27007b.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
