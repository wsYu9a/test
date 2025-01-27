package com.vivo.mobilead.e.a.h;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.vivo.mobilead.e.a.g.c.b;
import com.vivo.mobilead.e.a.h.g;

/* loaded from: classes4.dex */
class c implements com.vivo.mobilead.e.a.c {

    /* renamed from: a */
    private final Context f28783a;

    class a implements g.a {
        a(c cVar) {
        }

        @Override // com.vivo.mobilead.e.a.h.g.a
        public String a(IBinder iBinder) throws com.vivo.mobilead.e.a.d, RemoteException {
            com.vivo.mobilead.e.a.g.c.b a2 = b.a.a(iBinder);
            return (a2 != null && a2.isSupport()) ? a2.getOAID() : "";
        }
    }

    public c(Context context) {
        this.f28783a = context;
    }

    @Override // com.vivo.mobilead.e.a.c
    public boolean a() {
        Context context = this.f28783a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            return false;
        }
    }

    @Override // com.vivo.mobilead.e.a.c
    public void a(com.vivo.mobilead.e.a.b bVar) {
        if (this.f28783a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        g.a(this.f28783a, intent, bVar, new a(this));
    }
}
