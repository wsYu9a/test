package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import y2.a;

/* loaded from: classes3.dex */
public interface g extends IInterface {

    public static class a implements g {
        private IBinder aBt;

        public a(IBinder iBinder) {
            this.aBt = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aBt;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(a.AbstractBinderC0847a.f32952b);
                this.aBt.transact(1, obtain, obtain2, 0);
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
}
