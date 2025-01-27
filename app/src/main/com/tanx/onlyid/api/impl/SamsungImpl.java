package com.tanx.onlyid.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.api.impl.b;
import com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
class SamsungImpl implements d {

    /* renamed from: a */
    public final Context f22027a;

    public class a implements b.a {
        public a() {
        }

        @Override // com.tanx.onlyid.api.impl.b.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceIdService asInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public SamsungImpl(Context context) {
        this.f22027a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f22027a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        b.a(this.f22027a, intent, cVar, new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f22027a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }
}
