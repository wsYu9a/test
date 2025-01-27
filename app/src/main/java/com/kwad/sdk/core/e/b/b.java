package com.kwad.sdk.core.e.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.core.e.b.c;
import d7.b;
import java.util.Objects;

/* loaded from: classes3.dex */
public interface b extends IInterface {

    public static class a extends Binder implements b {
        private IBinder aBs;

        public a(IBinder iBinder) {
            this.aBs = iBinder;
        }

        public final void a(c cVar) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(b.AbstractBinderC0688b.f25284b);
                obtain.writeStrongBinder(cVar != null ? (c.a) cVar : null);
                this.aBs.transact(2, obtain, obtain2, 0);
                Objects.toString(this.aBs);
                obtain2.readException();
            } catch (Throwable unused) {
            }
            obtain.recycle();
            obtain2.recycle();
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aBs;
        }

        public final void b(c cVar) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(b.AbstractBinderC0688b.f25284b);
                obtain.writeStrongBinder(cVar != null ? (c.a) cVar : null);
                this.aBs.transact(3, obtain, obtain2, 0);
                obtain2.readException();
            } catch (Throwable unused) {
            }
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
