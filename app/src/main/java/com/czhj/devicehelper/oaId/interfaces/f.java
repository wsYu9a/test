package com.czhj.devicehelper.oaId.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import y2.a;

/* loaded from: classes2.dex */
public interface f extends IInterface {

    public static class a implements f {

        /* renamed from: a, reason: collision with root package name */
        public IBinder f8364a;

        public a(IBinder iBinder) {
            this.f8364a = iBinder;
        }

        @Override // com.czhj.devicehelper.oaId.interfaces.f
        public String a() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(a.AbstractBinderC0847a.f32952b);
                this.f8364a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th2) {
                obtain2.recycle();
                obtain.recycle();
                th2.printStackTrace();
                str = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return str;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f8364a;
        }
    }

    public static abstract class b extends Binder implements f {
        public b() {
            attachInterface(this, a.AbstractBinderC0847a.f32952b);
        }

        public f a(IBinder iBinder) {
            if (iBinder == null || iBinder.queryLocalInterface(a.AbstractBinderC0847a.f32952b) == null) {
                return null;
            }
            return new a(iBinder);
        }
    }

    String a();
}
