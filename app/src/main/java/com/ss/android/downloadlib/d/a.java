package com.ss.android.downloadlib.d;

import android.os.Build;
import androidx.annotation.NonNull;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.c;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.ss.android.downloadlib.d.a$a */
    public static class C0641a {

        /* renamed from: a */
        private static a f21593a = new a();
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        return C0641a.f21593a;
    }

    public void b(long j10, int i10) {
        a(j10, i10, (DownloadInfo) null);
    }

    private a() {
    }

    public void a(long j10, int i10) {
        e e10 = f.a().e(j10);
        if (e10.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendClickEvent ModelBox notValid");
            return;
        }
        if (e10.f21218c.isEnableClickEvent()) {
            int i11 = 1;
            DownloadEventConfig downloadEventConfig = e10.f21218c;
            String clickItemTag = i10 == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String a10 = m.a(e10.f21218c.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i10));
                jSONObject.putOpt("permission_notification", Integer.valueOf(d.a() ? 1 : 2));
                if (!DownloadUtils.isNetworkConnected(k.a())) {
                    i11 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i11));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            a(clickItemTag, a10, jSONObject, e10);
            if (!"click".equals(a10) || e10.f21217b == null) {
                return;
            }
            c.a().a(j10, e10.f21217b.getLogExtra());
        }
    }

    public void b(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.a.b a10 = f.a().a(downloadInfo);
        if (a10 == null) {
            com.ss.android.downloadlib.e.c.a().a("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (a10.f21058c.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                a10.d(baseException.getErrorCode());
                a10.a(baseException.getErrorMessage());
            }
            a10.y();
            jSONObject.put("download_failed_times", a10.x());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("has_send_download_failed_finally", a10.f21059d.get() ? 1 : 2);
            com.ss.android.downloadlib.g.f.a(a10, jSONObject);
            jSONObject.put("is_update_download", a10.V() ? 1 : 2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        a(a10.j(), PointCategory.DOWNLOAD_FAILED, jSONObject, a10);
        i.a().a(a10);
    }

    public void a(long j10, int i10, DownloadInfo downloadInfo) {
        String a10;
        e e10 = f.a().e(j10);
        if (e10.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        m.a(jSONObject, "download_scene", Integer.valueOf(e10.t()));
        if (i10 == 1) {
            a10 = m.a(e10.f21218c.getStorageDenyLabel(), "storage_deny");
        } else if (i10 == 2) {
            a10 = m.a(e10.f21218c.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.g.f.a(downloadInfo, jSONObject);
        } else if (i10 == 3) {
            a10 = m.a(e10.f21218c.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.g.f.b(downloadInfo, jSONObject);
        } else if (i10 == 4) {
            a10 = m.a(e10.f21218c.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
        } else if (i10 != 5) {
            a10 = null;
        } else {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.a.b(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            a10 = m.a(e10.f21218c.getClickInstallLabel(), "click_install");
        }
        a(null, a10, jSONObject, 0L, 1, e10);
    }

    public void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, aVar);
    }

    public void b(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a((String) null, str, jSONObject, aVar);
    }

    public void a(String str, int i10, e eVar) {
        a(null, str, null, i10, 0, eVar);
    }

    public void a(long j10, boolean z10, int i10) {
        e e10 = f.a().e(j10);
        if (e10.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (e10.f21217b.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = e10.f21217b;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i10));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        b(z10 ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, e10);
    }

    public void a(long j10, BaseException baseException) {
        e e10 = f.a().e(j10);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_TIME, 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        b(PointCategory.DOWNLOAD_FAILED, jSONObject, e10);
    }

    public void a(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.a.b a10 = f.a().a(downloadInfo);
        if (a10 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            a10.a(System.currentTimeMillis());
            a(a10.j(), "download_resume", jSONObject, a10);
            i.a().a(a10);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        a(bVar.j(), com.sigmob.sdk.base.common.a.J, jSONObject, bVar);
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.a.b a10;
        if (downloadInfo == null || (a10 = f.a().a(downloadInfo)) == null || a10.f21058c.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(a10.E()));
            jSONObject.putOpt("fail_msg", a10.F());
            jSONObject.put("download_failed_times", a10.x());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (a10.H() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - a10.H());
            }
            if (a10.B() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - a10.B());
            }
            jSONObject.put("is_update_download", a10.V() ? 1 : 2);
            jSONObject.put("can_show_notification", d.a() ? 1 : 2);
            jSONObject.put("has_send_download_failed_finally", a10.f21059d.get() ? 1 : 2);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        a(a10.j(), "download_cancel", jSONObject, a10);
    }

    public void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        a(str, (JSONObject) null, aVar);
    }

    public void a(String str, JSONObject jSONObject, long j10) {
        com.ss.android.downloadad.api.a.a d10 = f.a().d(j10);
        if (d10 != null) {
            a(str, jSONObject, d10);
            return;
        }
        e e10 = f.a().e(j10);
        if (e10.x()) {
            com.ss.android.downloadlib.e.c.a().a("sendUnityEvent ModelBox notValid");
        } else {
            a(str, jSONObject, e10);
        }
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        m.a(jSONObject2, "unity_label", str);
        a("embeded_ad", "ttdownloader_unity", m.a(jSONObject, jSONObject2), aVar);
    }

    public void a(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        b(str, new e(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void a(String str, long j10) {
        com.ss.android.downloadad.api.a.b d10 = f.a().d(j10);
        if (d10 != null) {
            b(str, d10);
        } else {
            b(str, f.a().e(j10));
        }
    }

    public void a(String str, String str2, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, (JSONObject) null, aVar);
    }

    public void a(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        a(str, str2, jSONObject, 0L, 0, aVar);
    }

    private void a(String str, String str2, JSONObject jSONObject, long j10, int i10, com.ss.android.downloadad.api.a.a aVar) {
        if (aVar == null) {
            com.ss.android.downloadlib.e.c.a().a("onEvent data null");
            return;
        }
        if ((aVar instanceof e) && ((e) aVar).x()) {
            com.ss.android.downloadlib.e.c.a().a("onEvent ModelBox notValid");
            return;
        }
        try {
            c.a c10 = new c.a().a(m.a(str, aVar.j(), "embeded_ad")).b(str2).b(aVar.c()).a(aVar.b()).c(aVar.d());
            if (j10 <= 0) {
                j10 = aVar.l();
            }
            c.a a10 = c10.b(j10).d(aVar.i()).a(aVar.n()).a(m.a(a(aVar), jSONObject)).b(aVar.k()).a(aVar.o());
            if (i10 <= 0) {
                i10 = 2;
            }
            a(a10.a(i10).a(aVar.m()).a());
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "onEvent");
        }
    }

    private JSONObject a(com.ss.android.downloadad.api.a.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            m.a(aVar.g(), jSONObject);
            m.a(aVar.p(), jSONObject);
            jSONObject.putOpt("download_url", aVar.a());
            jSONObject.putOpt("package_name", aVar.e());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.f.e.h());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.f.e.i());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.h()));
            if (aVar.h() == 2) {
                com.ss.android.downloadlib.g.f.b(jSONObject, aVar);
            }
            if (com.ss.android.socialbase.appdownloader.f.e.p()) {
                com.ss.android.downloadlib.g.f.a(jSONObject);
            }
        } catch (Exception e10) {
            k.u().a(e10, "getBaseJson");
        }
        return jSONObject;
    }

    private void a(com.ss.android.download.api.model.c cVar) {
        if (k.b() == null) {
            return;
        }
        if (cVar.m()) {
            k.b().a(cVar);
        } else {
            k.b().b(cVar);
        }
    }
}
