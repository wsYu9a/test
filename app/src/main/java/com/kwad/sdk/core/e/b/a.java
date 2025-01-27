package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.kwad.sdk.core.e.b.a$a, reason: collision with other inner class name */
    public static final class C0495a implements a {
        private final IBinder aBs;

        public C0495a(IBinder iBinder) {
            this.aBs = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aBs;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.aBs.transact(3, obtain, obtain2, 0);
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
}
