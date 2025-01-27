package com.czhj.devicehelper.oaId.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import com.czhj.sdk.logger.SigmobLog;
import com.shu.priory.config.AdKeys;

/* loaded from: classes2.dex */
public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        /* renamed from: com.czhj.devicehelper.oaId.interfaces.d$a$a */
        public static class C0248a implements d {

            /* renamed from: a */
            public IBinder f8362a;

            public C0248a(IBinder iBinder) {
                this.f8362a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                String str4 = null;
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.f8362a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        str4 = obtain2.readString();
                        Log.d(AdKeys.OAID, "getSerID() called with: res = [" + str4 + "]");
                    } catch (Exception e10) {
                        Log.d(AdKeys.OAID, "getSerID() called with: Exception = [" + e10.getMessage() + "]");
                        SigmobLog.e(e10.getMessage());
                    }
                    return str4;
                } finally {
                    obtain.recycle();
                    obtain2.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8362a;
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new C0248a(iBinder) : (d) queryLocalInterface;
        }
    }
}
