package com.tanx.onlyid.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.api.impl.b;
import ug.c;
import ug.d;
import ug.e;
import wg.a;

/* loaded from: classes4.dex */
class GmsImpl implements d {

    /* renamed from: a */
    public final Context f21996a;

    public class a implements b.a {
        public a() {
        }

        @Override // com.tanx.onlyid.api.impl.b.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            wg.a g10 = a.b.g(iBinder);
            if (g10.e(true)) {
                e.b("User has disabled advertising identifier");
            }
            return g10.getId();
        }
    }

    public GmsImpl(Context context) {
        this.f21996a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f21996a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        b.a(this.f21996a, intent, cVar, new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f21996a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }
}
