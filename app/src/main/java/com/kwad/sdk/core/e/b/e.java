package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import k3.a;

/* loaded from: classes3.dex */
public interface e extends IInterface {

    public static final class a implements e {
        private IBinder aBs;

        public a(IBinder iBinder) {
            this.aBs = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aBs;
        }

        @Override // com.kwad.sdk.core.e.b.e
        public final String getOaid() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(a.AbstractBinderC0721a.f27611b);
                this.aBs.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Exception unused) {
                obtain2.recycle();
                obtain.recycle();
                return null;
            } catch (Throwable th2) {
                obtain2.recycle();
                obtain.recycle();
                throw th2;
            }
        }
    }

    String getOaid();
}
