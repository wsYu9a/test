package com.ss.android.downloadlib.a.a;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.a.a.d;
import com.ss.android.downloadlib.addownload.k;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        /* renamed from: a */
        private static String f21120a = "";

        /* renamed from: com.ss.android.downloadlib.a.a.c$a$a */
        public static class C0634a implements c {

            /* renamed from: a */
            private IBinder f21121a;

            public C0634a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.f21120a)) {
                    JSONObject j10 = k.j();
                    String unused = a.f21120a = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString(t.f11211k), j10.optString("s"));
                }
                this.f21121a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.a.c
            public void a(b bVar, d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f21120a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f21121a.transact(1, obtain, obtain2, 0);
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
                return this.f21121a;
            }
        }

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f21120a);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface(f21120a);
            a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null, d.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f21120a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0634a(iBinder);
        }
    }

    void a(b bVar, d dVar) throws RemoteException;
}
