package com.shu.priory.utils.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class d implements IInterface {

    /* renamed from: a */
    private IBinder f17281a;

    /* renamed from: b */
    private final String f17282b;

    public d(IBinder iBinder, String str) {
        this.f17281a = iBinder;
        this.f17282b = str;
    }

    public String a(int i10, String... strArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        String str = null;
        try {
            if (!TextUtils.isEmpty(this.f17282b)) {
                obtain.writeInterfaceToken(this.f17282b);
                if (strArr != null) {
                    for (String str2 : strArr) {
                        if (!TextUtils.isEmpty(str2)) {
                            obtain.writeString(str2);
                        }
                    }
                }
                this.f17281a.transact(i10, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            }
        } catch (Throwable unused) {
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f17281a;
    }
}
