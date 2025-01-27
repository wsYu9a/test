package com.ss.android.downloadlib.i;

import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class q implements InnerEventListener {
    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onEvent(int i2, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.j.zx j2;
        DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null || (j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo)) == null) {
            return;
        }
        if (MonitorConstants.EventLabel.INSTALL_VIEW_RESULT.equals(str)) {
            jSONObject = nt.j(jSONObject);
            com.ss.android.downloadlib.j.j(jSONObject, downloadInfo);
            nt.j(jSONObject, "model_id", Long.valueOf(j2.zx()));
        }
        com.ss.android.downloadlib.g.j.j().zx(str, jSONObject, j2);
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onUnityEvent(int i2, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.j.zx j2;
        DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(i2);
        if (downloadInfo == null || (j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.g.j.j().j(str, jSONObject, j2);
    }
}
