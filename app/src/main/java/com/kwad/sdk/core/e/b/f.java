package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface f extends IInterface {

    public static final class a implements f {
        private IBinder aBs;

        public a(IBinder iBinder) {
            this.aBs = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aBs;
        }

        @Override // com.kwad.sdk.core.e.b.f
        public final String getSerID(String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                this.aBs.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception unused) {
                obtain.recycle();
                obtain2.recycle();
                return null;
            } catch (Throwable th2) {
                obtain.recycle();
                obtain2.recycle();
                throw th2;
            }
        }
    }

    String getSerID(String str, String str2, String str3);
}
