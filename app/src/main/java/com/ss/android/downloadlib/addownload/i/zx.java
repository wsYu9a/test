package com.ss.android.downloadlib.addownload.i;

import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.addownload.zx.gv;
import com.ss.android.downloadlib.addownload.zx.k;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class zx implements Runnable {

    /* renamed from: j */
    private DownloadInfo f24167j;

    /* renamed from: com.ss.android.downloadlib.addownload.i.zx$1 */
    class AnonymousClass1 implements q {

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24168j;

        AnonymousClass1(com.ss.android.downloadad.api.j.zx zxVar) {
            j2 = zxVar;
        }
    }

    public zx(DownloadInfo downloadInfo) {
        this.f24167j = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.downloadad.api.j.zx j2;
        if (this.f24167j == null || (j2 = gv.j().j(this.f24167j)) == null) {
            return;
        }
        com.ss.android.downloadlib.g.j.j().j("cleanspace_task", j2);
        double j3 = com.ss.android.downloadlib.lg.q.j(this.f24167j.getId()) + 1.0d;
        double totalBytes = this.f24167j.getTotalBytes();
        Double.isNaN(totalBytes);
        long longValue = Double.valueOf(j3 * totalBytes).longValue() - this.f24167j.getCurBytes();
        long j4 = nt.j(0L);
        if (pa.nt() != null) {
            pa.nt().q();
        }
        i.j();
        i.zx();
        if (com.ss.android.downloadlib.lg.q.lg(j2.v())) {
            i.j(pa.getContext());
        }
        long j5 = nt.j(0L);
        if (j5 >= longValue) {
            j2.nt("1");
            k.j().j(j2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(j5 - j4));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.g.j.j().j("cleanspace_download_after_quite_clean", jSONObject, j2);
            Downloader.getInstance(pa.getContext()).restart(this.f24167j.getId());
            return;
        }
        if (pa.nt() != null) {
            j2.g(false);
            g.j().j(j2.j(), new q() { // from class: com.ss.android.downloadlib.addownload.i.zx.1

                /* renamed from: j */
                final /* synthetic */ com.ss.android.downloadad.api.j.zx f24168j;

                AnonymousClass1(com.ss.android.downloadad.api.j.zx j22) {
                    j2 = j22;
                }
            });
            if (pa.nt().j(this.f24167j.getId(), this.f24167j.getUrl(), true, longValue)) {
                j22.q(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().j("cleanspace_window_show", jSONObject2, j22);
    }
}
