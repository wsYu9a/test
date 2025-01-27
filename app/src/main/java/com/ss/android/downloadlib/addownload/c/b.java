package com.ss.android.downloadlib.addownload.c;

import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: a */
    private DownloadInfo f21245a;

    /* renamed from: com.ss.android.downloadlib.addownload.c.b$1 */
    public class AnonymousClass1 implements e {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21246a;

        public AnonymousClass1(com.ss.android.downloadad.api.a.b bVar) {
            a10 = bVar;
        }
    }

    public b(DownloadInfo downloadInfo) {
        this.f21245a = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.downloadad.api.a.b a10;
        if (this.f21245a == null || (a10 = f.a().a(this.f21245a)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_task", a10);
        long longValue = Double.valueOf((com.ss.android.downloadlib.g.e.a(this.f21245a.getId()) + 1.0d) * this.f21245a.getTotalBytes()).longValue() - this.f21245a.getCurBytes();
        long b10 = m.b(0L);
        if (k.n() != null) {
            k.n().e();
        }
        c.a();
        c.b();
        if (com.ss.android.downloadlib.g.e.g(a10.s())) {
            c.a(k.a());
        }
        long b11 = m.b(0L);
        if (b11 >= longValue) {
            a10.l("1");
            i.a().a(a10);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(b11 - b10));
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("cleanspace_download_after_quite_clean", jSONObject, a10);
            Downloader.getInstance(k.a()).restart(this.f21245a.getId());
            return;
        }
        if (k.n() != null) {
            a10.d(false);
            d.a().a(a10.a(), new e() { // from class: com.ss.android.downloadlib.addownload.c.b.1

                /* renamed from: a */
                final /* synthetic */ com.ss.android.downloadad.api.a.b f21246a;

                public AnonymousClass1(com.ss.android.downloadad.api.a.b a102) {
                    a10 = a102;
                }
            });
            if (k.n().a(this.f21245a.getId(), this.f21245a.getUrl(), true, longValue)) {
                a102.e(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("cleanspace_window_show", jSONObject2, a102);
    }
}
