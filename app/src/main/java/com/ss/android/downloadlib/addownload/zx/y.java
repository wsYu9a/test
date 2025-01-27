package com.ss.android.downloadlib.addownload.zx;

import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class y {

    /* renamed from: j */
    private static volatile y f24241j;

    private y() {
    }

    public static y j() {
        if (f24241j == null) {
            synchronized (g.class) {
                if (f24241j == null) {
                    f24241j = new y();
                }
            }
        }
        return f24241j;
    }

    public void j(int i2, int i3, com.ss.android.downloadad.api.j.zx zxVar) {
        if (zxVar == null) {
            return;
        }
        DownloadSetting obtain = DownloadSetting.obtain(zxVar.v());
        if (obtain.optInt("report_api_hijack", 0) == 0) {
            return;
        }
        int i4 = i3 - i2;
        if (i2 <= 0 || i4 <= obtain.optInt("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i4);
            jSONObject.put("installed_version_code", i3);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().zx("api_hijack", jSONObject, zxVar);
    }
}
