package com.tanx.onlyid.api.impl;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tanx.onlyid.api.OAIDException;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
class NubiaImpl implements d {

    /* renamed from: a */
    public final Context f22023a;

    public NubiaImpl(Context context) {
        this.f22023a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f22023a == null || cVar == null) {
            return;
        }
        if (!b()) {
            e.b("Only supports Android 10.0 and above for Nubia");
            cVar.oaidError(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f22023a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (acquireContentProviderClient == null) {
                return;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                acquireContentProviderClient.release();
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                throw new OAIDException("OAID query failed: bundle is null");
            }
            String string = call.getInt("code", -1) == 0 ? call.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException("OAID query failed: " + call.getString(b7.d.f1362o));
            }
            e.b("OAID query success: " + string);
            cVar.oaidSucc(string);
        } catch (Exception e10) {
            e.b(e10);
            cVar.oaidError(e10);
        }
    }

    @Override // ug.d
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean b() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
