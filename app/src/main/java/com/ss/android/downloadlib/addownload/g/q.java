package com.ss.android.downloadlib.addownload.g;

import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class q implements g {
    private boolean zx(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.ss.android.downloadlib.addownload.g.g
    public boolean j(com.ss.android.downloadad.api.j.zx zxVar, int i2, i iVar) {
        if (zxVar == null || !zx(zxVar.v())) {
            return false;
        }
        if (System.currentTimeMillis() - zxVar.az() > j(zxVar.v())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, zxVar);
        return true;
    }

    private long j(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_mistake_click_interval", 300);
    }
}
