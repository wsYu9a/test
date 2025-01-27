package com.ss.android.downloadlib.e;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.appdownloader.f.f;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements com.ss.android.download.api.b.a {

    public static class a {

        /* renamed from: a */
        private static c f21602a = new c();
    }

    public static c a() {
        return a.f21602a;
    }

    public void b(String str) {
        b(true, str);
    }

    @Override // com.ss.android.download.api.b.a
    public void a(Throwable th2, String str) {
        a(true, th2, str);
    }

    public void b(boolean z10, String str) {
        if (b()) {
            return;
        }
        if (z10) {
            b(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "msg", str);
        m.a(jSONObject, "stack", a(new Throwable()));
        k.i().a("service_ttdownloader", 3, jSONObject);
    }

    public void a(boolean z10, Throwable th2, String str) {
        if (b()) {
            return;
        }
        if (th2 == null) {
            th2 = new Throwable();
        }
        if (z10) {
            b(th2);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th2.getMessage();
        }
        m.a(jSONObject, "msg", str);
        m.a(jSONObject, "stack", Log.getStackTraceString(th2));
        k.i().a("service_ttdownloader", 1, jSONObject);
    }

    private void b(Throwable th2) {
        if (f.b(k.a())) {
            throw new com.ss.android.downloadlib.e.a(th2);
        }
    }

    private boolean b() {
        return k.j().optInt("enable_monitor", 1) != 1;
    }

    public void a(String str) {
        a(true, str);
    }

    public void a(boolean z10, String str) {
        if (b()) {
            return;
        }
        if (z10) {
            b(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "msg", str);
        m.a(jSONObject, "stack", a(new Throwable()));
        k.i().a("service_ttdownloader", 2, jSONObject);
    }

    public static String a(Throwable th2) {
        try {
            return Log.getStackTraceString(th2);
        } catch (Exception unused) {
            return null;
        }
    }
}
