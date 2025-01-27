package com.ss.android.downloadlib.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import com.umeng.analytics.pro.bt;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* renamed from: a */
        private static String f21122a = "";

        /* renamed from: com.ss.android.downloadlib.a.a.d$a$a */
        public static class C0635a implements d {

            /* renamed from: a */
            private IBinder f21123a;

            public C0635a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.f21122a)) {
                    JSONObject j10 = k.j();
                    String unused = a.f21122a = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString(bt.aO), j10.optString("s"));
                }
                this.f21123a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.a.d
            public void a(b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f21122a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21123a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21123a;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f21122a);
                a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f21122a);
            return true;
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f21122a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0635a(iBinder);
        }
    }

    void a(b bVar) throws RemoteException;
}
