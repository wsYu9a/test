package com.vivo.mobilead.e.a.g.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public interface a extends IInterface {
    String getOAID() throws RemoteException;

    boolean isSupport() throws RemoteException;

    /* renamed from: com.vivo.mobilead.e.a.g.a.a$a */
    public static abstract class AbstractBinderC0580a extends Binder implements a {

        /* renamed from: com.vivo.mobilead.e.a.g.a.a$a$a */
        private static class C0581a implements a {

            /* renamed from: b */
            public static a f28770b;

            /* renamed from: a */
            private IBinder f28771a;

            C0581a(IBinder iBinder) {
                this.f28771a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f28771a;
            }

            @Override // com.vivo.mobilead.e.a.g.a.a
            public String getOAID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f28771a.transact(3, obtain, obtain2, 0) && AbstractBinderC0580a.a() != null) {
                        return AbstractBinderC0580a.a().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.vivo.mobilead.e.a.g.a.a
            public boolean isSupport() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (!this.f28771a.transact(1, obtain, obtain2, 0) && AbstractBinderC0580a.a() != null) {
                        return AbstractBinderC0580a.a().isSupport();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0581a(iBinder) : (a) queryLocalInterface;
        }

        public static a a() {
            return C0581a.f28770b;
        }
    }
}
