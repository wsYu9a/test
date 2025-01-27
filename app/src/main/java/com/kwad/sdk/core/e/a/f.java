package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface f extends IInterface {

    public static final class a implements f {
        private IBinder ahM;

        public a(IBinder iBinder) {
            this.ahM = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.ahM;
        }

        @Override // com.kwad.sdk.core.e.a.f
        public final String getOAID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                this.ahM.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception unused) {
                obtain.recycle();
                obtain2.recycle();
                return null;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }
    }

    String getOAID();
}
