package com.czhj.devicehelper.oaId.interfaces;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public interface b extends IInterface {

    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public IBinder f8359a;

        /* renamed from: b, reason: collision with root package name */
        public Context f8360b;

        public a(IBinder iBinder, Context context) {
            this.f8359a = iBinder;
            this.f8360b = context;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f8359a;
        }

        @Override // com.czhj.devicehelper.oaId.interfaces.b
        public boolean c() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z10 = true;
            try {
                obtain.writeInterfaceToken(h2.b.f26378a);
                this.f8359a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z10 = false;
                }
            } catch (Throwable unused) {
                obtain.recycle();
                obtain2.recycle();
            }
            obtain.recycle();
            obtain2.recycle();
            return z10;
        }

        @Override // com.czhj.devicehelper.oaId.interfaces.b
        public String i() {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(h2.b.f26378a);
                this.f8359a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th2) {
                obtain.recycle();
                obtain2.recycle();
                th2.printStackTrace();
                str = null;
            }
            obtain.recycle();
            obtain2.recycle();
            return str;
        }

        public String j() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                String string = Settings.Global.getString(this.f8360b.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(this.f8360b.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    if (!TextUtils.isEmpty(string2)) {
                        return "get oaid failed";
                    }
                }
                return string;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return "get oaid failed";
            }
        }
    }

    boolean c();

    String i();
}
