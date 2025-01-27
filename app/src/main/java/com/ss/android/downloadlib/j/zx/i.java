package com.ss.android.downloadlib.j.zx;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.j.zx.g;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface i extends IInterface {

    public static abstract class j extends Binder implements i {

        /* renamed from: j */
        private static String f24305j = "";

        /* renamed from: com.ss.android.downloadlib.j.zx.i$j$j */
        private static class C0499j implements i {

            /* renamed from: j */
            private IBinder f24306j;

            C0499j(IBinder iBinder) {
                if (TextUtils.isEmpty(j.f24305j)) {
                    JSONObject k = pa.k();
                    String unused = j.f24305j = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString(t.k), k.optString("s"));
                }
                this.f24306j = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24306j;
            }

            @Override // com.ss.android.downloadlib.j.zx.i
            public void j(zx zxVar, g gVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(j.f24305j);
                    if (zxVar != null) {
                        obtain.writeInt(1);
                        zxVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.f24306j.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f24305j);
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface(f24305j);
            j(parcel.readInt() != 0 ? zx.CREATOR.createFromParcel(parcel) : null, g.j.j(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static i j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f24305j);
            if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                return (i) queryLocalInterface;
            }
            return new C0499j(iBinder);
        }
    }

    void j(zx zxVar, g gVar) throws RemoteException;
}
