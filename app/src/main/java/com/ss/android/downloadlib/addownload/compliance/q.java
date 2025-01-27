package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.downloadlib.addownload.zx.gv;
import org.json.JSONObject;

/* loaded from: classes4.dex */
class q {
    public static void j(String str, long j2) {
        com.ss.android.downloadlib.addownload.zx.q q = gv.j().q(j2);
        if (q.mx()) {
            return;
        }
        q.f24239i.setRefer(str);
        com.ss.android.downloadlib.g.j.j().zx("lp_app_dialog_click", q);
    }

    public static void zx(String str, long j2) {
        j(str, null, j2);
    }

    public static void j(String str, JSONObject jSONObject, long j2) {
        com.ss.android.downloadlib.g.j.j().zx(str, jSONObject, gv.j().q(j2));
    }

    public static void j(String str, com.ss.android.downloadlib.addownload.zx.q qVar) {
        com.ss.android.downloadlib.g.j.j().zx(str, qVar);
    }

    public static void j(int i2, com.ss.android.downloadlib.addownload.zx.q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().zx("lp_compliance_error", jSONObject, qVar);
    }

    public static void j(int i2, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().zx("lp_compliance_error", jSONObject, gv.j().q(j2));
    }
}
