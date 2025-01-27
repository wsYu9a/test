package com.ss.android.downloadlib.c;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e implements InnerEventListener {
    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onEvent(int i10, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b a10;
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i10);
        if (downloadInfo == null || (a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        if (MonitorConstants.EventLabel.INSTALL_VIEW_RESULT.equals(str)) {
            jSONObject = m.a(jSONObject);
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            m.a(jSONObject, "model_id", Long.valueOf(a10.b()));
        }
        com.ss.android.downloadlib.d.a.a().b(str, jSONObject, a10);
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onUnityEvent(int i10, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b a10;
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(i10);
        if (downloadInfo == null || (a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a(str, jSONObject, a10);
    }
}
