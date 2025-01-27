package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface d extends IInterface {

    public static final class a implements d {
        private IBinder aBs;

        public a(IBinder iBinder) {
            this.aBs = iBinder;
        }

        public final String Ge() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(h2.b.f26378a);
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

        public final boolean Gf() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z10 = false;
            try {
                obtain.writeInterfaceToken(h2.b.f26378a);
                this.aBs.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z10 = true;
                }
            } catch (Exception unused) {
            } catch (Throwable th2) {
                obtain.recycle();
                obtain2.recycle();
                throw th2;
            }
            obtain.recycle();
            obtain2.recycle();
            return z10;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aBs;
        }
    }
}
