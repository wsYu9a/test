package com.tanx.onlyid.api.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.api.impl.b;
import com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
public class CoolpadImpl implements d {

    /* renamed from: a */
    public final Context f21990a;

    public class a implements b.a {
        public a() {
        }

        @Override // com.tanx.onlyid.api.impl.b.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceIdManager asInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID(CoolpadImpl.this.f21990a.getPackageName());
            }
            throw new OAIDException("IDeviceIdManager is null");
        }
    }

    public CoolpadImpl(Context context) {
        if (context instanceof Application) {
            this.f21990a = context;
        } else {
            this.f21990a = context.getApplicationContext();
        }
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f21990a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        b.a(this.f21990a, intent, cVar, new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f21990a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }
}
