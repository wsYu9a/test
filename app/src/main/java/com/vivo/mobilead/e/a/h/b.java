package com.vivo.mobilead.e.a.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.vivo.mobilead.e.a.g.b.a;
import com.vivo.mobilead.e.a.h.g;

/* loaded from: classes4.dex */
class b implements com.vivo.mobilead.e.a.c {

    /* renamed from: a */
    private final Context f28781a;

    /* renamed from: b */
    private String f28782b;

    class a implements g.a {
        a(b bVar) {
        }

        @Override // com.vivo.mobilead.e.a.h.g.a
        public String a(IBinder iBinder) throws com.vivo.mobilead.e.a.d, RemoteException {
            com.vivo.mobilead.e.a.g.b.a a2 = a.AbstractBinderC0582a.a(iBinder);
            return a2.n() ? "" : a2.o();
        }
    }

    public b(Context context) {
        this.f28781a = context;
    }

    @Override // com.vivo.mobilead.e.a.c
    public boolean a() {
        Context context = this.f28781a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f28782b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f28782b = "com.huawei.hwid.tv";
            } else {
                this.f28782b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            return false;
        }
    }

    @Override // com.vivo.mobilead.e.a.c
    public void a(com.vivo.mobilead.e.a.b bVar) {
        Context context = this.f28781a;
        if (context == null || bVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    com.vivo.mobilead.e.a.e.a("Get oaid from global settings: " + string);
                    bVar.a(string);
                    return;
                }
            } catch (Exception e2) {
                com.vivo.mobilead.e.a.e.a(e2);
            }
        }
        if (TextUtils.isEmpty(this.f28782b) && !a()) {
            bVar.a(new com.vivo.mobilead.e.a.d("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f28782b);
        g.a(this.f28781a, intent, bVar, new a(this));
    }
}
