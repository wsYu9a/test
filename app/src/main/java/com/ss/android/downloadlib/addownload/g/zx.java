package com.ss.android.downloadlib.addownload.g;

import android.content.Context;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.y;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class zx implements g {

    /* renamed from: j */
    private static com.ss.android.downloadlib.addownload.j.i f24155j;

    /* renamed from: com.ss.android.downloadlib.addownload.g.zx$1 */
    class AnonymousClass1 implements com.ss.android.downloadlib.addownload.j.i {

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24157j;
        final /* synthetic */ i zx;

        AnonymousClass1(com.ss.android.downloadad.api.j.zx zxVar, i iVar) {
            zxVar = zxVar;
            iVar = iVar;
        }

        @Override // com.ss.android.downloadlib.addownload.j.i
        public void j() {
            com.ss.android.downloadlib.addownload.j.i unused = zx.f24155j = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "download_percent");
                jSONObject.putOpt("pause_optimise_action", "confirm");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, zxVar);
        }

        @Override // com.ss.android.downloadlib.addownload.j.i
        public void zx() {
            com.ss.android.downloadlib.addownload.j.i unused = zx.f24155j = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pause_optimise_type", "download_percent");
                jSONObject.putOpt("pause_optimise_action", "cancel");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, zxVar);
            iVar.j(zxVar);
        }
    }

    public static com.ss.android.downloadlib.addownload.j.i j() {
        return f24155j;
    }

    @Override // com.ss.android.downloadlib.addownload.g.g
    public boolean j(com.ss.android.downloadad.api.j.zx zxVar, int i2, i iVar) {
        DownloadInfo zx;
        if (zxVar == null || zxVar.yq() || !j(zxVar) || (zx = y.j((Context) null).zx(zxVar.j())) == null) {
            return false;
        }
        long curBytes = zx.getCurBytes();
        long totalBytes = zx.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int j2 = k.j(zx.getId(), (int) ((curBytes * 100) / totalBytes));
            if (j2 > j(zxVar.v())) {
                f24155j = new com.ss.android.downloadlib.addownload.j.i() { // from class: com.ss.android.downloadlib.addownload.g.zx.1

                    /* renamed from: j */
                    final /* synthetic */ com.ss.android.downloadad.api.j.zx f24157j;
                    final /* synthetic */ i zx;

                    AnonymousClass1(com.ss.android.downloadad.api.j.zx zxVar2, i iVar2) {
                        zxVar = zxVar2;
                        iVar = iVar2;
                    }

                    @Override // com.ss.android.downloadlib.addownload.j.i
                    public void j() {
                        com.ss.android.downloadlib.addownload.j.i unused = zx.f24155j = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, zxVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.j.i
                    public void zx() {
                        com.ss.android.downloadlib.addownload.j.i unused = zx.f24155j = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.g.j.j().j("pause_optimise", jSONObject, zxVar);
                        iVar.j(zxVar);
                    }
                };
                TTDelegateActivity.zx(zxVar2, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(j2)), "继续", "暂停");
                zxVar2.w(true);
                return true;
            }
        }
        return false;
    }

    private int j(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_download_percent", 50);
    }

    private boolean j(com.ss.android.downloadad.api.j.j jVar) {
        return com.ss.android.downloadlib.lg.q.j(jVar).optInt("pause_optimise_download_percent_switch", 0) == 1 && jVar.ei();
    }
}
