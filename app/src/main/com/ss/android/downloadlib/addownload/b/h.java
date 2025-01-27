package com.ss.android.downloadlib.addownload.b;

import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    private static volatile h f21231a;

    private h() {
    }

    public static h a() {
        if (f21231a == null) {
            synchronized (d.class) {
                try {
                    if (f21231a == null) {
                        f21231a = new h();
                    }
                } finally {
                }
            }
        }
        return f21231a;
    }

    public void a(int i10, int i11, com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return;
        }
        DownloadSetting obtain = DownloadSetting.obtain(bVar.s());
        if (obtain.optInt("report_api_hijack", 0) == 0) {
            return;
        }
        int i12 = i11 - i10;
        if (i10 <= 0 || i12 <= obtain.optInt("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i12);
            jSONObject.put("installed_version_code", i11);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("api_hijack", jSONObject, bVar);
    }
}
