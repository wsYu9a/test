package com.ss.android.downloadlib.addownload.g;

import android.content.Context;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.y;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j implements g {

    /* renamed from: j */
    private static com.ss.android.downloadlib.addownload.j.i f24152j;

    /* renamed from: com.ss.android.downloadlib.addownload.g.j$1 */
    class AnonymousClass1 implements com.ss.android.downloadlib.addownload.j.i {

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24154j;
        final /* synthetic */ i zx;

        AnonymousClass1(com.ss.android.downloadad.api.j.zx zxVar, i iVar) {
            zxVar = zxVar;
            iVar = iVar;
        }

        @Override // com.ss.android.downloadlib.addownload.j.i
        public void j() {
            com.ss.android.downloadlib.addownload.j.i unused = j.f24152j = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "apk_size");
                jSONObject.putOpt("pause_optimise_action", "confirm");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, zxVar);
        }

        @Override // com.ss.android.downloadlib.addownload.j.i
        public void zx() {
            com.ss.android.downloadlib.addownload.j.i unused = j.f24152j = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "apk_size");
                jSONObject.putOpt("pause_optimise_action", "cancel");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, zxVar);
            iVar.j(zxVar);
        }
    }

    public static com.ss.android.downloadlib.addownload.j.i j() {
        return f24152j;
    }

    @Override // com.ss.android.downloadlib.addownload.g.g
    public boolean j(com.ss.android.downloadad.api.j.zx zxVar, int i2, i iVar) {
        DownloadInfo zx;
        if (zxVar == null || zxVar.m() || !j(zxVar) || (zx = y.j((Context) null).zx(zxVar.j())) == null) {
            return false;
        }
        long j2 = k.j(zx.getId(), zx.getCurBytes(), zx.getTotalBytes());
        long totalBytes = zx.getTotalBytes();
        if (j2 <= 0 || totalBytes <= 0 || totalBytes > j(zxVar.v())) {
            return false;
        }
        f24152j = new com.ss.android.downloadlib.addownload.j.i() { // from class: com.ss.android.downloadlib.addownload.g.j.1

            /* renamed from: j */
            final /* synthetic */ com.ss.android.downloadad.api.j.zx f24154j;
            final /* synthetic */ i zx;

            AnonymousClass1(com.ss.android.downloadad.api.j.zx zxVar2, i iVar2) {
                zxVar = zxVar2;
                iVar = iVar2;
            }

            @Override // com.ss.android.downloadlib.addownload.j.i
            public void j() {
                com.ss.android.downloadlib.addownload.j.i unused = j.f24152j = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, zxVar);
            }

            @Override // com.ss.android.downloadlib.addownload.j.i
            public void zx() {
                com.ss.android.downloadlib.addownload.j.i unused = j.f24152j = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, zxVar);
                iVar.j(zxVar);
            }
        };
        TTDelegateActivity.j(zxVar2, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", j(totalBytes - j2)), "继续", "暂停");
        zxVar2.r(true);
        return true;
    }

    private int j(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean j(com.ss.android.downloadad.api.j.j jVar) {
        return com.ss.android.downloadlib.lg.q.j(jVar).optInt("pause_optimise_apk_size_switch", 0) == 1 && jVar.ei();
    }

    private static String j(long j2) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j2 >= DownloadConstants.GB) {
            return (j2 / DownloadConstants.GB) + "G";
        }
        if (j2 >= 1048576) {
            return (j2 / 1048576) + "M";
        }
        return decimalFormat.format(j2 / 1048576.0f) + "M";
    }
}
