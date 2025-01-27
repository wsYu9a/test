package com.czhj.devicehelper.oaId.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import com.czhj.sdk.logger.SigmobLog;
import com.shu.priory.config.AdKeys;

/* loaded from: classes2.dex */
public interface e extends IInterface {

    public static abstract class a extends Binder implements e {

        /* renamed from: com.czhj.devicehelper.oaId.interfaces.e$a$a */
        public static class C0249a implements e {

            /* renamed from: a */
            public IBinder f8363a;

            public C0249a(IBinder iBinder) {
                this.f8363a = iBinder;
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
                        this.f8363a.transact(1, obtain, obtain2, 0);
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
                return this.f8363a;
            }
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C0249a(iBinder) : (e) queryLocalInterface;
        }
    }
}
