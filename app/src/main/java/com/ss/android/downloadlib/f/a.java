package com.ss.android.downloadlib.f;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public class a implements j {

    /* renamed from: com.ss.android.downloadlib.f.a$1 */
    public class AnonymousClass1 implements com.ss.android.downloadlib.guide.install.a {

        /* renamed from: a */
        final /* synthetic */ i f21605a;

        public AnonymousClass1(i iVar) {
            iVar = iVar;
        }

        @Override // com.ss.android.downloadlib.guide.install.a
        public void a() {
            iVar.a();
        }
    }

    /* renamed from: com.ss.android.downloadlib.f.a$2 */
    public class AnonymousClass2 implements com.ss.android.downloadlib.guide.install.a {

        /* renamed from: a */
        final /* synthetic */ DownloadInfo f21607a;

        /* renamed from: b */
        final /* synthetic */ com.ss.android.downloadlib.guide.install.a f21608b;

        public AnonymousClass2(DownloadInfo downloadInfo, com.ss.android.downloadlib.guide.install.a aVar) {
            downloadInfo = downloadInfo;
            aVar = aVar;
        }

        @Override // com.ss.android.downloadlib.guide.install.a
        public void a() {
            a.this.b(downloadInfo, aVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.f.a$3 */
    public class AnonymousClass3 implements com.ss.android.downloadlib.guide.install.a {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadlib.guide.install.a f21610a;

        public AnonymousClass3(com.ss.android.downloadlib.guide.install.a aVar) {
            aVar = aVar;
        }

        @Override // com.ss.android.downloadlib.guide.install.a
        public void a() {
            aVar.a();
        }
    }

    public void b(DownloadInfo downloadInfo, @NonNull com.ss.android.downloadlib.guide.install.a aVar) {
        com.ss.android.downloadad.api.a.b a10 = f.a().a(downloadInfo);
        boolean a11 = com.ss.android.downloadlib.b.f.a(a10);
        boolean b10 = com.ss.android.downloadlib.b.f.b(a10);
        if (a11 && b10) {
            com.ss.android.downloadlib.b.c.a(a10, new com.ss.android.downloadlib.guide.install.a() { // from class: com.ss.android.downloadlib.f.a.3

                /* renamed from: a */
                final /* synthetic */ com.ss.android.downloadlib.guide.install.a f21610a;

                public AnonymousClass3(com.ss.android.downloadlib.guide.install.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.ss.android.downloadlib.guide.install.a
                public void a() {
                    aVar.a();
                }
            });
        } else {
            aVar2.a();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, i iVar) {
        a(downloadInfo, new com.ss.android.downloadlib.guide.install.a() { // from class: com.ss.android.downloadlib.f.a.1

            /* renamed from: a */
            final /* synthetic */ i f21605a;

            public AnonymousClass1(i iVar2) {
                iVar = iVar2;
            }

            @Override // com.ss.android.downloadlib.guide.install.a
            public void a() {
                iVar.a();
            }
        });
    }

    public void a(DownloadInfo downloadInfo, @NonNull com.ss.android.downloadlib.guide.install.a aVar) {
        com.ss.android.downloadad.api.a.b a10 = f.a().a(downloadInfo);
        if (a10 != null && com.ss.android.downloadlib.b.i.a(a10)) {
            TTDelegateActivity.a(a10, new com.ss.android.downloadlib.guide.install.a() { // from class: com.ss.android.downloadlib.f.a.2

                /* renamed from: a */
                final /* synthetic */ DownloadInfo f21607a;

                /* renamed from: b */
                final /* synthetic */ com.ss.android.downloadlib.guide.install.a f21608b;

                public AnonymousClass2(DownloadInfo downloadInfo2, com.ss.android.downloadlib.guide.install.a aVar2) {
                    downloadInfo = downloadInfo2;
                    aVar = aVar2;
                }

                @Override // com.ss.android.downloadlib.guide.install.a
                public void a() {
                    a.this.b(downloadInfo, aVar);
                }
            });
        } else {
            b(downloadInfo2, aVar2);
        }
    }
}
