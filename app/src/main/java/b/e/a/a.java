package b.e.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes4.dex */
class a implements c {

    /* renamed from: a */
    private IBinder f4790a;

    a(IBinder iBinder) {
        this.f4790a = iBinder;
    }

    @Override // b.e.a.c
    public void a(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.mcs.aidl.IMcsSdkService");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4790a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f4790a;
    }

    public String d() {
        return "com.mcs.aidl.IMcsSdkService";
    }
}
