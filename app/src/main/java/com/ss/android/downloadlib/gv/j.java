package com.ss.android.downloadlib.gv;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.zx.gv;
import com.ss.android.socialbase.appdownloader.i.k;
import com.ss.android.socialbase.appdownloader.i.pa;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public class j implements pa {

    /* renamed from: com.ss.android.downloadlib.gv.j$1 */
    class AnonymousClass1 implements com.ss.android.downloadlib.guide.install.j {

        /* renamed from: j */
        final /* synthetic */ k f24260j;

        AnonymousClass1(k kVar) {
            kVar = kVar;
        }

        @Override // com.ss.android.downloadlib.guide.install.j
        public void j() {
            kVar.j();
        }
    }

    /* renamed from: com.ss.android.downloadlib.gv.j$2 */
    class AnonymousClass2 implements com.ss.android.downloadlib.guide.install.j {

        /* renamed from: j */
        final /* synthetic */ DownloadInfo f24262j;
        final /* synthetic */ com.ss.android.downloadlib.guide.install.j zx;

        AnonymousClass2(DownloadInfo downloadInfo, com.ss.android.downloadlib.guide.install.j jVar) {
            downloadInfo = downloadInfo;
            jVar = jVar;
        }

        @Override // com.ss.android.downloadlib.guide.install.j
        public void j() {
            j.this.zx(downloadInfo, jVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.gv.j$3 */
    class AnonymousClass3 implements com.ss.android.downloadlib.guide.install.j {

        /* renamed from: j */
        final /* synthetic */ com.ss.android.downloadlib.guide.install.j f24263j;

        AnonymousClass3(com.ss.android.downloadlib.guide.install.j jVar) {
            jVar = jVar;
        }

        @Override // com.ss.android.downloadlib.guide.install.j
        public void j() {
            jVar.j();
        }
    }

    public void zx(DownloadInfo downloadInfo, @NonNull com.ss.android.downloadlib.guide.install.j jVar) {
        com.ss.android.downloadad.api.j.zx j2 = gv.j().j(downloadInfo);
        boolean j3 = com.ss.android.downloadlib.zx.gv.j(j2);
        boolean zx = com.ss.android.downloadlib.zx.gv.zx(j2);
        if (j3 && zx) {
            com.ss.android.downloadlib.zx.i.j(j2, new com.ss.android.downloadlib.guide.install.j() { // from class: com.ss.android.downloadlib.gv.j.3

                /* renamed from: j */
                final /* synthetic */ com.ss.android.downloadlib.guide.install.j f24263j;

                AnonymousClass3(com.ss.android.downloadlib.guide.install.j jVar2) {
                    jVar = jVar2;
                }

                @Override // com.ss.android.downloadlib.guide.install.j
                public void j() {
                    jVar.j();
                }
            });
        } else {
            jVar2.j();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.i.pa
    public void j(DownloadInfo downloadInfo, k kVar) {
        j(downloadInfo, new com.ss.android.downloadlib.guide.install.j() { // from class: com.ss.android.downloadlib.gv.j.1

            /* renamed from: j */
            final /* synthetic */ k f24260j;

            AnonymousClass1(k kVar2) {
                kVar = kVar2;
            }

            @Override // com.ss.android.downloadlib.guide.install.j
            public void j() {
                kVar.j();
            }
        });
    }

    public void j(DownloadInfo downloadInfo, @NonNull com.ss.android.downloadlib.guide.install.j jVar) {
        com.ss.android.downloadad.api.j.zx j2 = gv.j().j(downloadInfo);
        if (j2 != null && com.ss.android.downloadlib.zx.k.j(j2)) {
            TTDelegateActivity.j(j2, new com.ss.android.downloadlib.guide.install.j() { // from class: com.ss.android.downloadlib.gv.j.2

                /* renamed from: j */
                final /* synthetic */ DownloadInfo f24262j;
                final /* synthetic */ com.ss.android.downloadlib.guide.install.j zx;

                AnonymousClass2(DownloadInfo downloadInfo2, com.ss.android.downloadlib.guide.install.j jVar2) {
                    downloadInfo = downloadInfo2;
                    jVar = jVar2;
                }

                @Override // com.ss.android.downloadlib.guide.install.j
                public void j() {
                    j.this.zx(downloadInfo, jVar);
                }
            });
        } else {
            zx(downloadInfo2, jVar2);
        }
    }
}
