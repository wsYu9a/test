package com.ss.android.downloadlib.addownload.compliance;

import org.json.JSONObject;

/* loaded from: classes4.dex */
class g {
    public static void a(String str, long j10) {
        com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(j10);
        if (e10.x()) {
            return;
        }
        e10.f21218c.setRefer(str);
        com.ss.android.downloadlib.d.a.a().b("lp_app_dialog_click", e10);
    }

    public static void b(String str, long j10) {
        a(str, null, j10);
    }

    public static void a(String str, JSONObject jSONObject, long j10) {
        com.ss.android.downloadlib.d.a.a().b(str, jSONObject, com.ss.android.downloadlib.addownload.b.f.a().e(j10));
    }

    public static void a(String str, com.ss.android.downloadlib.addownload.b.e eVar) {
        com.ss.android.downloadlib.d.a.a().b(str, eVar);
    }

    public static void a(int i10, com.ss.android.downloadlib.addownload.b.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, eVar);
    }

    public static void a(int i10, long j10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.b.f.a().e(j10));
    }
}
