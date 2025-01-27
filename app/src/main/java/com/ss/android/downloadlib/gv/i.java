package com.ss.android.downloadlib.gv;

import com.ss.android.socialbase.appdownloader.i.k;
import com.ss.android.socialbase.appdownloader.i.pa;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class i implements pa {

    /* renamed from: j */
    private static volatile i f24256j;
    private List<pa> zx;

    /* renamed from: com.ss.android.downloadlib.gv.i$1 */
    class AnonymousClass1 implements k {

        /* renamed from: i */
        final /* synthetic */ k f24258i;

        /* renamed from: j */
        final /* synthetic */ int f24259j;
        final /* synthetic */ DownloadInfo zx;

        AnonymousClass1(int i2, DownloadInfo downloadInfo, k kVar) {
            i2 = i2;
            downloadInfo = downloadInfo;
            kVar = kVar;
        }

        @Override // com.ss.android.socialbase.appdownloader.i.k
        public void j() {
            i.this.j(downloadInfo, i2 + 1, kVar);
        }
    }

    private i() {
        ArrayList arrayList = new ArrayList();
        this.zx = arrayList;
        arrayList.add(new zx());
        this.zx.add(new j());
    }

    public static i j() {
        if (f24256j == null) {
            synchronized (i.class) {
                if (f24256j == null) {
                    f24256j = new i();
                }
            }
        }
        return f24256j;
    }

    @Override // com.ss.android.socialbase.appdownloader.i.pa
    public void j(DownloadInfo downloadInfo, k kVar) {
        if (downloadInfo != null && this.zx.size() != 0) {
            j(downloadInfo, 0, kVar);
        } else if (kVar != null) {
            kVar.j();
        }
    }

    public void j(DownloadInfo downloadInfo, int i2, k kVar) {
        if (i2 != this.zx.size() && i2 >= 0) {
            this.zx.get(i2).j(downloadInfo, new k() { // from class: com.ss.android.downloadlib.gv.i.1

                /* renamed from: i */
                final /* synthetic */ k f24258i;

                /* renamed from: j */
                final /* synthetic */ int f24259j;
                final /* synthetic */ DownloadInfo zx;

                AnonymousClass1(int i22, DownloadInfo downloadInfo2, k kVar2) {
                    i2 = i22;
                    downloadInfo = downloadInfo2;
                    kVar = kVar2;
                }

                @Override // com.ss.android.socialbase.appdownloader.i.k
                public void j() {
                    i.this.j(downloadInfo, i2 + 1, kVar);
                }
            });
        } else {
            kVar2.j();
        }
    }
}
