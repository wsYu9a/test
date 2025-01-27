package com.ss.android.downloadlib.lg;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class t {
    public static void i(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.t s = com.ss.android.downloadlib.addownload.pa.s();
        if (s != null) {
            s.j(6, str, str2, jSONObject);
        }
    }

    public static void j(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.t s = com.ss.android.downloadlib.addownload.pa.s();
        if (s != null) {
            s.j(2, str, str2, jSONObject);
        }
    }

    public static void zx(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.t s = com.ss.android.downloadlib.addownload.pa.s();
        if (s != null) {
            s.j(3, str, str2, jSONObject);
        }
    }

    public static void j(String str, String str2) {
        i(str, str2, null);
    }

    public static void j(String str) {
        i(null, str, null);
    }
}
