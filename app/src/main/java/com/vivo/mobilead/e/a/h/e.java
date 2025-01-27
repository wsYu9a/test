package com.vivo.mobilead.e.a.h;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes4.dex */
class e implements com.vivo.mobilead.e.a.c {

    /* renamed from: a */
    private final Context f28785a;

    public e(Context context) {
        this.f28785a = context;
    }

    @Override // com.vivo.mobilead.e.a.c
    public boolean a() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @Override // com.vivo.mobilead.e.a.c
    public void a(com.vivo.mobilead.e.a.b bVar) {
        if (this.f28785a == null || bVar == null) {
            return;
        }
        if (!a()) {
            com.vivo.mobilead.e.a.e.a("Only supports Android 10.0 and above for Nubia");
            bVar.a(new com.vivo.mobilead.e.a.d("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f28785a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                acquireContentProviderClient.close();
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                throw new com.vivo.mobilead.e.a.d("OAID query failed: bundle is null");
            }
            String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new com.vivo.mobilead.e.a.d("OAID query failed: " + call.getString(com.heytap.mcssdk.n.d.l));
            }
            com.vivo.mobilead.e.a.e.a("OAID query success: " + string);
            bVar.a(string);
        } catch (Exception e2) {
            com.vivo.mobilead.e.a.e.a(e2);
            bVar.a(e2);
        }
    }
}
