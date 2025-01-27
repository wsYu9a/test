package com.ss.android.downloadlib.q;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.appdownloader.gv.gv;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i implements com.ss.android.download.api.zx.j {

    private static class j {

        /* renamed from: j */
        private static i f24351j = new i();
    }

    public static i j() {
        return j.f24351j;
    }

    public void zx(String str) {
        zx(true, str);
    }

    @Override // com.ss.android.download.api.zx.j
    public void j(Throwable th, String str) {
        j(true, th, str);
    }

    public void zx(boolean z, String str) {
        if (zx()) {
            return;
        }
        if (z) {
            zx(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        nt.j(jSONObject, "msg", str);
        nt.j(jSONObject, "stack", j(new Throwable()));
        pa.y().j("service_ttdownloader", 3, jSONObject);
    }

    public void j(boolean z, Throwable th, String str) {
        if (zx()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            zx(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        nt.j(jSONObject, "msg", str);
        nt.j(jSONObject, "stack", Log.getStackTraceString(th));
        pa.y().j("service_ttdownloader", 1, jSONObject);
    }

    private void zx(Throwable th) {
        if (gv.zx(pa.getContext())) {
            throw new com.ss.android.downloadlib.q.j(th);
        }
    }

    private boolean zx() {
        return pa.k().optInt("enable_monitor", 1) != 1;
    }

    public void j(String str) {
        j(true, str);
    }

    public void j(boolean z, String str) {
        if (zx()) {
            return;
        }
        if (z) {
            zx(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        nt.j(jSONObject, "msg", str);
        nt.j(jSONObject, "stack", j(new Throwable()));
        pa.y().j("service_ttdownloader", 2, jSONObject);
    }

    public static String j(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }
}
