package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: j */
    private static String f24158j = "i";
    private static volatile i zx;

    /* renamed from: i */
    private ConcurrentHashMap<Long, Runnable> f24159i;

    /* renamed from: com.ss.android.downloadlib.addownload.i$1 */
    class AnonymousClass1 implements com.ss.android.downloadlib.zx.g {

        /* renamed from: i */
        final /* synthetic */ DownloadModel f24161i;

        /* renamed from: j */
        final /* synthetic */ q f24162j;
        final /* synthetic */ int zx;

        AnonymousClass1(q qVar, int i2, DownloadModel downloadModel) {
            qVar = qVar;
            i2 = i2;
            downloadModel = downloadModel;
        }

        @Override // com.ss.android.downloadlib.zx.g
        public void j(boolean z) {
            i.this.j(qVar, z, i2, downloadModel);
        }
    }

    public i() {
        this.f24159i = null;
        this.f24159i = new ConcurrentHashMap<>();
    }

    public static i j() {
        if (zx == null) {
            synchronized (i.class) {
                if (zx == null) {
                    zx = new i();
                }
            }
        }
        return zx;
    }

    public long zx() {
        return pa.k().optLong("quick_app_check_internal", 1200L);
    }

    public void j(q qVar, boolean z, int i2, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i2 == 4) {
            if (!z) {
                j(id, false, 2);
                qVar.zx(false);
                return;
            } else {
                j(id, true, 2);
                return;
            }
        }
        if (i2 == 5) {
            if (!z) {
                j(id, false, 1);
                qVar.i(false);
                return;
            } else {
                j(id, true, 1);
                return;
            }
        }
        if (i2 != 7) {
            return;
        }
        Runnable remove = this.f24159i.remove(Long.valueOf(id));
        if (z) {
            com.ss.android.downloadlib.g.j.j().j(id, 1);
            j(id, true, 1);
        } else {
            if (remove != null) {
                com.ss.android.downloadlib.lg.j().zx().post(remove);
            }
            j(id, false, 1);
        }
    }

    private void j(long j2, boolean z, int i2) {
        com.ss.android.downloadlib.g.j.j().j(j2, z, i2);
        if (z) {
            pa.gm().j(null, null, null, null, null, 3);
        }
    }

    public void j(q qVar, int i2, DownloadModel downloadModel) {
        com.ss.android.downloadlib.zx.q.j().j(new com.ss.android.downloadlib.zx.g() { // from class: com.ss.android.downloadlib.addownload.i.1

            /* renamed from: i */
            final /* synthetic */ DownloadModel f24161i;

            /* renamed from: j */
            final /* synthetic */ q f24162j;
            final /* synthetic */ int zx;

            AnonymousClass1(q qVar2, int i22, DownloadModel downloadModel2) {
                qVar = qVar2;
                i2 = i22;
                downloadModel = downloadModel2;
            }

            @Override // com.ss.android.downloadlib.zx.g
            public void j(boolean z) {
                i.this.j(qVar, z, i2, downloadModel);
            }
        }, zx());
    }

    public static boolean j(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
