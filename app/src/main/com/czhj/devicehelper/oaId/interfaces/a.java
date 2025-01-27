package com.czhj.devicehelper.oaId.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: com.czhj.devicehelper.oaId.interfaces.a$a */
    public static final class C0246a implements a {

        /* renamed from: a */
        public IBinder f8358a;

        public C0246a(IBinder iBinder) {
            this.f8358a = iBinder;
        }

        @Override // com.czhj.devicehelper.oaId.interfaces.a
        public String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f8358a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th2) {
                obtain.recycle();
                obtain2.recycle();
                SigmobLog.e(th2.getMessage());
                str = null;
            }
            obtain.recycle();
            obtain2.recycle();
            return str;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f8358a;
        }

        public boolean j() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f8358a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } catch (Exception unused) {
                obtain2.recycle();
                obtain.recycle();
                return false;
            }
        }
    }

    String a();
}
