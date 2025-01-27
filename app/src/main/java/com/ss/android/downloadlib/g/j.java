package com.ss.android.downloadlib.g;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.i;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.addownload.zx.gv;
import com.ss.android.downloadlib.addownload.zx.k;
import com.ss.android.downloadlib.addownload.zx.q;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.appdownloader.q.g;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: com.ss.android.downloadlib.g.j$j */
    private static class C0495j {

        /* renamed from: j */
        private static j f24250j = new j();
    }

    /* synthetic */ j(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static j j() {
        return C0495j.f24250j;
    }

    public void zx(long j2, int i2) {
        j(j2, i2, (DownloadInfo) null);
    }

    private j() {
    }

    public void j(long j2, int i2) {
        q q = gv.j().q(j2);
        if (q.mx()) {
            com.ss.android.downloadlib.q.i.j().j("sendClickEvent ModelBox notValid");
            return;
        }
        if (q.f24239i.isEnableClickEvent()) {
            int i3 = 1;
            DownloadEventConfig downloadEventConfig = q.f24239i;
            String clickItemTag = i2 == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String j3 = nt.j(q.f24239i.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
                jSONObject.putOpt("permission_notification", Integer.valueOf(g.j() ? 1 : 2));
                if (!DownloadUtils.isNetworkConnected(pa.getContext())) {
                    i3 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i3));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            j(clickItemTag, j3, jSONObject, q);
            if (!"click".equals(j3) || q.zx == null) {
                return;
            }
            i.j().j(j2, q.zx.getLogExtra());
        }
    }

    public void zx(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.j.zx j2 = gv.j().j(downloadInfo);
        if (j2 == null) {
            com.ss.android.downloadlib.q.i.j().j("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (j2.f24094i.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
            com.ss.android.downloadlib.j.j(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                j2.g(baseException.getErrorCode());
                j2.j(baseException.getErrorMessage());
            }
            j2.tf();
            jSONObject.put("download_failed_times", j2.mx());
            if (downloadInfo.getTotalBytes() > 0) {
                double curBytes = downloadInfo.getCurBytes();
                double totalBytes = downloadInfo.getTotalBytes();
                Double.isNaN(curBytes);
                Double.isNaN(totalBytes);
                jSONObject.put("download_percent", curBytes / totalBytes);
            }
            int i2 = 1;
            jSONObject.put("has_send_download_failed_finally", j2.f24093g.get() ? 1 : 2);
            com.ss.android.downloadlib.lg.gv.j(j2, jSONObject);
            if (!j2.ty()) {
                i2 = 2;
            }
            jSONObject.put("is_update_download", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        j(j2.pa(), "download_failed", jSONObject, j2);
        k.j().j(j2);
    }

    public void j(long j2, int i2, DownloadInfo downloadInfo) {
        q q = gv.j().q(j2);
        if (q.mx()) {
            com.ss.android.downloadlib.q.i.j().j("sendEvent ModelBox notValid");
            return;
        }
        String str = null;
        JSONObject jSONObject = new JSONObject();
        nt.j(jSONObject, "download_scene", Integer.valueOf(q.gm()));
        if (i2 == 1) {
            str = nt.j(q.f24239i.getStorageDenyLabel(), "storage_deny");
        } else if (i2 == 2) {
            str = nt.j(q.f24239i.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.lg.gv.j(downloadInfo, jSONObject);
        } else if (i2 == 3) {
            str = nt.j(q.f24239i.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.lg.gv.zx(downloadInfo, jSONObject);
        } else if (i2 == 4) {
            str = nt.j(q.f24239i.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
        } else if (i2 == 5) {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.lg.gv.j(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.j.zx(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            str = nt.j(q.f24239i.getClickInstallLabel(), "click_install");
        }
        j(null, str, jSONObject, 0L, 1, q);
    }

    public void zx(String str, com.ss.android.downloadad.api.j.j jVar) {
        j((String) null, str, jVar);
    }

    public void zx(String str, JSONObject jSONObject, com.ss.android.downloadad.api.j.j jVar) {
        j((String) null, str, jSONObject, jVar);
    }

    public void j(String str, int i2, q qVar) {
        j(null, str, null, i2, 0, qVar);
    }

    public void j(long j2, boolean z, int i2) {
        q q = gv.j().q(j2);
        if (q.mx()) {
            com.ss.android.downloadlib.q.i.j().j("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (q.zx.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = q.zx;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zx(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, q);
    }

    public void j(long j2, BaseException baseException) {
        q q = gv.j().q(j2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_TIME, 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zx("download_failed", jSONObject, q);
    }

    public void j(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.j.zx j2 = gv.j().j(downloadInfo);
        if (j2 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.lg.gv.i(downloadInfo, jSONObject);
            j2.j(System.currentTimeMillis());
            j(j2.pa(), "download_resume", jSONObject, j2);
            k.j().j(j2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void j(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.j.zx zxVar) {
        j(zxVar.pa(), "install_finish", jSONObject, zxVar);
    }

    public void j(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.j.zx j2;
        if (downloadInfo == null || (j2 = gv.j().j(downloadInfo)) == null || j2.f24094i.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.j.j(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(j2.l()));
            jSONObject.putOpt("fail_msg", j2.vs());
            jSONObject.put("download_failed_times", j2.mx());
            if (downloadInfo.getTotalBytes() > 0) {
                double curBytes = downloadInfo.getCurBytes();
                double totalBytes = downloadInfo.getTotalBytes();
                Double.isNaN(curBytes);
                Double.isNaN(totalBytes);
                jSONObject.put("download_percent", curBytes / totalBytes);
            }
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (j2.me() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - j2.me());
            }
            if (j2.gg() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - j2.gg());
            }
            int i2 = 1;
            jSONObject.put("is_update_download", j2.ty() ? 1 : 2);
            jSONObject.put("can_show_notification", g.j() ? 1 : 2);
            if (!j2.f24093g.get()) {
                i2 = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        j(j2.pa(), "download_cancel", jSONObject, j2);
    }

    public void j(String str, com.ss.android.downloadad.api.j.j jVar) {
        j(str, (JSONObject) null, jVar);
    }

    public void j(String str, JSONObject jSONObject, long j2) {
        com.ss.android.downloadad.api.j.j g2 = gv.j().g(j2);
        if (g2 != null) {
            j(str, jSONObject, g2);
            return;
        }
        q q = gv.j().q(j2);
        if (q.mx()) {
            com.ss.android.downloadlib.q.i.j().j("sendUnityEvent ModelBox notValid");
        } else {
            j(str, jSONObject, q);
        }
    }

    public void j(String str, JSONObject jSONObject, com.ss.android.downloadad.api.j.j jVar) {
        JSONObject jSONObject2 = new JSONObject();
        nt.j(jSONObject2, "unity_label", str);
        j("embeded_ad", "ttdownloader_unity", nt.j(jSONObject, jSONObject2), jVar);
    }

    public void j(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        zx(str, new q(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void j(String str, long j2) {
        com.ss.android.downloadad.api.j.zx g2 = gv.j().g(j2);
        if (g2 != null) {
            zx(str, g2);
        } else {
            zx(str, gv.j().q(j2));
        }
    }

    public void j(String str, String str2, com.ss.android.downloadad.api.j.j jVar) {
        j(str, str2, (JSONObject) null, jVar);
    }

    public void j(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.j.j jVar) {
        j(str, str2, jSONObject, 0L, 0, jVar);
    }

    private void j(String str, String str2, JSONObject jSONObject, long j2, int i2, com.ss.android.downloadad.api.j.j jVar) {
        if (jVar == null) {
            com.ss.android.downloadlib.q.i.j().j("onEvent data null");
            return;
        }
        if ((jVar instanceof q) && ((q) jVar).mx()) {
            com.ss.android.downloadlib.q.i.j().j("onEvent ModelBox notValid");
            return;
        }
        try {
            i.j i3 = new i.j().j(nt.j(str, jVar.pa(), "embeded_ad")).zx(str2).zx(jVar.i()).j(jVar.zx()).i(jVar.g());
            if (j2 <= 0) {
                j2 = jVar.nt();
            }
            i.j j3 = i3.zx(j2).g(jVar.k()).j(jVar.r()).j(nt.j(j(jVar), jSONObject)).zx(jVar.t()).j(jVar.w());
            if (i2 <= 0) {
                i2 = 2;
            }
            j(j3.j(i2).j(jVar.p()).j());
        } catch (Exception e2) {
            com.ss.android.downloadlib.q.i.j().j(e2, "onEvent");
        }
    }

    private JSONObject j(com.ss.android.downloadad.api.j.j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            nt.j(jVar.lg(), jSONObject);
            nt.j(jVar.s(), jSONObject);
            jSONObject.putOpt("download_url", jVar.j());
            jSONObject.putOpt("package_name", jVar.q());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.gv.q.lg());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.gv.q.y());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(jVar.y()));
            if (jVar.y() == 2) {
                com.ss.android.downloadlib.lg.gv.zx(jSONObject, jVar);
            }
            if (com.ss.android.socialbase.appdownloader.gv.q.w()) {
                com.ss.android.downloadlib.lg.gv.j(jSONObject);
            }
        } catch (Exception e2) {
            pa.v().j(e2, "getBaseJson");
        }
        return jSONObject;
    }

    private void j(com.ss.android.download.api.model.i iVar) {
        if (pa.j() == null) {
            return;
        }
        if (iVar.p()) {
            pa.j().j(iVar);
        } else {
            pa.j().zx(iVar);
        }
    }
}
