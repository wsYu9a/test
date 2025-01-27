package com.ss.android.downloadlib.j.zx;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.pa;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface g extends IInterface {

    public static abstract class j extends Binder implements g {

        /* renamed from: j */
        private static String f24303j = "";

        /* renamed from: com.ss.android.downloadlib.j.zx.g$j$j */
        private static class C0498j implements g {

            /* renamed from: j */
            private IBinder f24304j;

            C0498j(IBinder iBinder) {
                if (TextUtils.isEmpty(j.f24303j)) {
                    JSONObject k = pa.k();
                    String unused = j.f24303j = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("t"), k.optString("s"));
                }
                this.f24304j = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24304j;
            }

            @Override // com.ss.android.downloadlib.j.zx.g
            public void j(zx zxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f24303j);
                    if (zxVar != null) {
                        obtain.writeInt(1);
                        zxVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24304j.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f24303j);
                j(parcel.readInt() != 0 ? zx.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString(f24303j);
            return true;
        }

        public static g j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f24303j);
            if (queryLocalInterface != null && (queryLocalInterface instanceof g)) {
                return (g) queryLocalInterface;
            }
            return new C0498j(iBinder);
        }
    }

    void j(zx zxVar) throws RemoteException;
}
