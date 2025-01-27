package com.ss.android.downloadlib.gv;

import com.ss.android.downloadlib.addownload.zx.gv;
import com.ss.android.socialbase.appdownloader.i.k;
import com.ss.android.socialbase.appdownloader.i.pa;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public class zx implements pa {
    @Override // com.ss.android.socialbase.appdownloader.i.pa
    public void j(DownloadInfo downloadInfo, k kVar) {
        com.ss.android.downloadad.api.j.zx j2;
        if (downloadInfo != null && (j2 = gv.j().j(downloadInfo)) != null) {
            downloadInfo.setLinkMode(j2.bl());
        }
        if (kVar != null) {
            kVar.j();
        }
    }
}
