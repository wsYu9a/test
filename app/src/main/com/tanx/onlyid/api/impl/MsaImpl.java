package com.tanx.onlyid.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.api.impl.b;
import com.tanx.onlyid.core.bun.lib.MsaIdInterface;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
class MsaImpl implements d {

    /* renamed from: a */
    public final Context f22021a;

    public class a implements b.a {
        public a() {
        }

        @Override // com.tanx.onlyid.api.impl.b.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            MsaIdInterface asInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (asInterface == null) {
                throw new OAIDException("MsaIdInterface is null");
            }
            if (asInterface.isSupported()) {
                return asInterface.getOAID();
            }
            throw new OAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public MsaImpl(Context context) {
        this.f22021a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f22021a == null || cVar == null) {
            return;
        }
        c();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.f22021a.getPackageName());
        b.a(this.f22021a, intent, cVar, new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f22021a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }

    public final void c() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f22021a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f22021a.startService(intent);
            } else {
                this.f22021a.startForegroundService(intent);
            }
        } catch (Exception e10) {
            e.b(e10);
        }
    }
}
