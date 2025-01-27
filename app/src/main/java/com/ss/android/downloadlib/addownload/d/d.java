package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static d f21401a;

    /* renamed from: b */
    private List<g> f21402b;

    private d() {
        ArrayList arrayList = new ArrayList();
        this.f21402b = arrayList;
        arrayList.add(new e());
        this.f21402b.add(new b());
        this.f21402b.add(new c());
    }

    public static d a() {
        if (f21401a == null) {
            synchronized (k.class) {
                try {
                    if (f21401a == null) {
                        f21401a = new d();
                    }
                } finally {
                }
            }
        }
        return f21401a;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar, int i10, h hVar, com.ss.android.downloadlib.addownload.a.c cVar) {
        DownloadInfo b10;
        List<g> list = this.f21402b;
        if (list == null || list.size() == 0 || bVar == null) {
            hVar.a(bVar);
        }
        if (!TextUtils.isEmpty(bVar.af())) {
            b10 = com.ss.android.downloadlib.i.a(com.ss.android.downloadlib.addownload.k.a()).a(bVar.af(), null, true);
        } else {
            b10 = com.ss.android.downloadlib.i.a(com.ss.android.downloadlib.addownload.k.a()).b(bVar.a());
        }
        if (b10 == null) {
            b10 = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(bVar.s());
        }
        if (b10 != null && "application/vnd.android.package-archive".equals(b10.getMimeType())) {
            if (new j().a(bVar, i10, hVar)) {
                return;
            }
            Iterator<g> it = this.f21402b.iterator();
            while (it.hasNext()) {
                if (it.next().a(bVar, i10, hVar, cVar)) {
                    return;
                }
            }
            hVar.a(bVar);
            return;
        }
        hVar.a(bVar);
    }
}
