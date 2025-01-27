package pe;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes3.dex */
public class a implements c {

    /* renamed from: b */
    public IBinder f29874b;

    public a(IBinder iBinder) {
        this.f29874b = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f29874b;
    }

    @Override // pe.c
    public void d(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(b.f29875b);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f29874b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th2) {
            obtain2.recycle();
            obtain.recycle();
            throw th2;
        }
    }

    public String j() {
        return b.f29875b;
    }
}
