package com.ss.android.downloadlib.f;

import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public class b implements j {
    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, i iVar) {
        com.ss.android.downloadad.api.a.b a10;
        if (downloadInfo != null && (a10 = f.a().a(downloadInfo)) != null) {
            downloadInfo.setLinkMode(a10.O());
        }
        if (iVar != null) {
            iVar.a();
        }
    }
}
