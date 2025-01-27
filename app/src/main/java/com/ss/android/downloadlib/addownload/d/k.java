package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private static k f21407a;

    /* renamed from: b */
    private List<i> f21408b;

    private k() {
        ArrayList arrayList = new ArrayList();
        this.f21408b = arrayList;
        arrayList.add(new j());
        this.f21408b.add(new l());
        this.f21408b.add(new f());
        this.f21408b.add(new a());
    }

    public static k a() {
        if (f21407a == null) {
            synchronized (k.class) {
                try {
                    if (f21407a == null) {
                        f21407a = new k();
                    }
                } finally {
                }
            }
        }
        return f21407a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar, int i10, h hVar) {
        DownloadInfo b10;
        List<i> list = this.f21408b;
        if (list != null && list.size() != 0 && bVar != null) {
            if (!TextUtils.isEmpty(bVar.af())) {
                b10 = com.ss.android.downloadlib.i.a((Context) null).a(bVar.af(), null, true);
            } else {
                b10 = com.ss.android.downloadlib.i.a((Context) null).b(bVar.a());
            }
            if (b10 != null && "application/vnd.android.package-archive".equals(b10.getMimeType())) {
                boolean z10 = DownloadSetting.obtain(bVar.s()).optInt("pause_optimise_switch", 0) == 1;
                for (i iVar : this.f21408b) {
                    if (z10 || (iVar instanceof l)) {
                        if (iVar.a(bVar, i10, hVar)) {
                            return;
                        }
                    }
                }
                hVar.a(bVar);
                return;
            }
            hVar.a(bVar);
            return;
        }
        hVar.a(bVar);
    }
}
