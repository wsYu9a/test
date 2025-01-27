package com.vivo.mobilead.e.a.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.vivo.mobilead.e.a.g.a.a;
import com.vivo.mobilead.e.a.h.g;

/* loaded from: classes4.dex */
class a implements com.vivo.mobilead.e.a.c {

    /* renamed from: a */
    private final Context f28780a;

    /* renamed from: com.vivo.mobilead.e.a.h.a$a */
    class C0589a implements g.a {
        C0589a(a aVar) {
        }

        @Override // com.vivo.mobilead.e.a.h.g.a
        public String a(IBinder iBinder) throws com.vivo.mobilead.e.a.d, RemoteException {
            com.vivo.mobilead.e.a.g.a.a a2 = a.AbstractBinderC0580a.a(iBinder);
            return (a2 != null && a2.isSupport()) ? a2.getOAID() : "";
        }
    }

    public a(Context context) {
        this.f28780a = context;
    }

    @Override // com.vivo.mobilead.e.a.c
    public boolean a() {
        Context context = this.f28780a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            return false;
        }
    }

    @Override // com.vivo.mobilead.e.a.c
    public void a(com.vivo.mobilead.e.a.b bVar) {
        if (this.f28780a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        g.a(this.f28780a, intent, bVar, new C0589a(this));
    }
}
