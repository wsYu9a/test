package com.vivo.mobilead.e.a.h;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.vivo.mobilead.e.a.g.c.a;
import com.vivo.mobilead.e.a.h.g;

/* loaded from: classes4.dex */
class i implements com.vivo.mobilead.e.a.c {

    /* renamed from: a */
    private final Context f28793a;

    class a implements g.a {
        a(i iVar) {
        }

        @Override // com.vivo.mobilead.e.a.h.g.a
        public String a(IBinder iBinder) throws com.vivo.mobilead.e.a.d, RemoteException {
            com.vivo.mobilead.e.a.g.c.a a2 = a.AbstractBinderC0584a.a(iBinder);
            return a2 == null ? "" : a2.getOAID();
        }
    }

    public i(Context context) {
        this.f28793a = context;
    }

    @Override // com.vivo.mobilead.e.a.c
    public boolean a() {
        Context context = this.f28793a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            return false;
        }
    }

    @Override // com.vivo.mobilead.e.a.c
    public void a(com.vivo.mobilead.e.a.b bVar) {
        if (this.f28793a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        g.a(this.f28793a, intent, bVar, new a(this));
    }
}
