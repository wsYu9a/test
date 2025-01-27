package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface h extends IInterface {

    public static final class a implements h {
        private IBinder aBs;

        public a(IBinder iBinder) {
            this.aBs = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aBs;
        }

        @Override // com.kwad.sdk.core.e.b.h
        public final String getOAID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
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

    String getOAID();
}
