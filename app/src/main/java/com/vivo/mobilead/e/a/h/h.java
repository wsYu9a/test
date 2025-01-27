package com.vivo.mobilead.e.a.h;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.vivo.mobilead.e.a.g.d.a;
import com.vivo.mobilead.e.a.h.g;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes4.dex */
class h implements com.vivo.mobilead.e.a.c {

    /* renamed from: a */
    private Context f28790a;

    /* renamed from: b */
    private String f28791b;

    class a implements g.a {
        a() {
        }

        @Override // com.vivo.mobilead.e.a.h.g.a
        public String a(IBinder iBinder) throws com.vivo.mobilead.e.a.d, RemoteException {
            try {
                return h.this.a(iBinder);
            } catch (RemoteException | com.vivo.mobilead.e.a.d | Exception unused) {
                return "";
            }
        }
    }

    public h(Context context) {
        if (context instanceof Application) {
            this.f28790a = context;
        } else if (context != null) {
            this.f28790a = context.getApplicationContext();
        }
    }

    @Override // com.vivo.mobilead.e.a.c
    public boolean a() {
        Context context = this.f28790a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            return false;
        }
    }

    @Override // com.vivo.mobilead.e.a.c
    public void a(com.vivo.mobilead.e.a.b bVar) {
        if (this.f28790a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        g.a(this.f28790a, intent, bVar, new a());
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public String a(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, com.vivo.mobilead.e.a.d {
        try {
            String packageName = this.f28790a.getPackageName();
            if (this.f28791b != null) {
                return "";
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f28790a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            String sb2 = sb.toString();
            this.f28791b = sb2;
            return a(iBinder, packageName, sb2);
        } catch (Exception unused) {
            return "";
        }
    }

    private String a(IBinder iBinder, String str, String str2) throws RemoteException, com.vivo.mobilead.e.a.d {
        com.vivo.mobilead.e.a.g.d.a a2 = a.AbstractBinderC0587a.a(iBinder);
        return a2 == null ? "" : a2.b(str, str2, "OUID");
    }
}
