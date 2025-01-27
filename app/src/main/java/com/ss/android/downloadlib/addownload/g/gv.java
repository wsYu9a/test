package com.ss.android.downloadlib.addownload.g;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.y;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class gv {

    /* renamed from: j */
    private static gv f24151j;
    private List<g> zx;

    private gv() {
        ArrayList arrayList = new ArrayList();
        this.zx = arrayList;
        arrayList.add(new q());
        this.zx.add(new lg());
        this.zx.add(new zx());
        this.zx.add(new j());
    }

    public static gv j() {
        if (f24151j == null) {
            synchronized (gv.class) {
                if (f24151j == null) {
                    f24151j = new gv();
                }
            }
        }
        return f24151j;
    }

    public void j(com.ss.android.downloadad.api.j.zx zxVar, int i2, i iVar) {
        List<g> list = this.zx;
        if (list != null && list.size() != 0 && zxVar != null) {
            DownloadInfo zx = y.j((Context) null).zx(zxVar.j());
            if (zx != null && AdBaseConstants.MIME_APK.equals(zx.getMimeType())) {
                boolean z = DownloadSetting.obtain(zxVar.v()).optInt("pause_optimise_switch", 0) == 1;
                for (g gVar : this.zx) {
                    if (z || (gVar instanceof lg)) {
                        if (gVar.j(zxVar, i2, iVar)) {
                            return;
                        }
                    }
                }
                iVar.j(zxVar);
                return;
            }
            iVar.j(zxVar);
            return;
        }
        iVar.j(zxVar);
    }
}
