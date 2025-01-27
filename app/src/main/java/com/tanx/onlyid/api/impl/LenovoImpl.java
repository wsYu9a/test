package com.tanx.onlyid.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.api.impl.b;
import com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
class LenovoImpl implements d {

    /* renamed from: a */
    public final Context f22018a;

    public class a implements b.a {
        public a() {
        }

        @Override // com.tanx.onlyid.api.impl.b.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceidInterface asInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (asInterface == null) {
                throw new OAIDException("IDeviceidInterface is null");
            }
            if (asInterface.isSupport()) {
                return asInterface.getOAID();
            }
            throw new OAIDException("IDeviceidInterface#isSupport return false");
        }
    }

    public LenovoImpl(Context context) {
        this.f22018a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f22018a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        b.a(this.f22018a, intent, cVar, new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f22018a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }
}
