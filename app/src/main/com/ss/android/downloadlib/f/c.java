package com.ss.android.downloadlib.f;

import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c implements j {

    /* renamed from: a */
    private static volatile c f21612a;

    /* renamed from: b */
    private List<j> f21613b;

    /* renamed from: com.ss.android.downloadlib.f.c$1 */
    public class AnonymousClass1 implements i {

        /* renamed from: a */
        final /* synthetic */ int f21614a;

        /* renamed from: b */
        final /* synthetic */ DownloadInfo f21615b;

        /* renamed from: c */
        final /* synthetic */ i f21616c;

        public AnonymousClass1(int i10, DownloadInfo downloadInfo, i iVar) {
            i10 = i10;
            downloadInfo = downloadInfo;
            iVar = iVar;
        }

        @Override // com.ss.android.socialbase.appdownloader.c.i
        public void a() {
            c.this.a(downloadInfo, i10 + 1, iVar);
        }
    }

    private c() {
        ArrayList arrayList = new ArrayList();
        this.f21613b = arrayList;
        arrayList.add(new b());
        this.f21613b.add(new a());
    }

    public static c a() {
        if (f21612a == null) {
            synchronized (c.class) {
                try {
                    if (f21612a == null) {
                        f21612a = new c();
                    }
                } finally {
                }
            }
        }
        return f21612a;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.j
    public void a(DownloadInfo downloadInfo, i iVar) {
        if (downloadInfo != null && this.f21613b.size() != 0) {
            a(downloadInfo, 0, iVar);
        } else if (iVar != null) {
            iVar.a();
        }
    }

    public void a(DownloadInfo downloadInfo, int i10, i iVar) {
        if (i10 != this.f21613b.size() && i10 >= 0) {
            this.f21613b.get(i10).a(downloadInfo, new i() { // from class: com.ss.android.downloadlib.f.c.1

                /* renamed from: a */
                final /* synthetic */ int f21614a;

                /* renamed from: b */
                final /* synthetic */ DownloadInfo f21615b;

                /* renamed from: c */
                final /* synthetic */ i f21616c;

                public AnonymousClass1(int i102, DownloadInfo downloadInfo2, i iVar2) {
                    i10 = i102;
                    downloadInfo = downloadInfo2;
                    iVar = iVar2;
                }

                @Override // com.ss.android.socialbase.appdownloader.c.i
                public void a() {
                    c.this.a(downloadInfo, i10 + 1, iVar);
                }
            });
        } else {
            iVar2.a();
        }
    }
}
