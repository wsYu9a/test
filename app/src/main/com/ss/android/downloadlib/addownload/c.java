package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static String f21237a = "c";

    /* renamed from: b */
    private static volatile c f21238b;

    /* renamed from: c */
    private ConcurrentHashMap<Long, Runnable> f21239c;

    /* renamed from: com.ss.android.downloadlib.addownload.c$1 */
    public class AnonymousClass1 implements com.ss.android.downloadlib.b.d {

        /* renamed from: a */
        final /* synthetic */ e f21240a;

        /* renamed from: b */
        final /* synthetic */ int f21241b;

        /* renamed from: c */
        final /* synthetic */ DownloadModel f21242c;

        public AnonymousClass1(e eVar, int i10, DownloadModel downloadModel) {
            eVar = eVar;
            i10 = i10;
            downloadModel = downloadModel;
        }

        @Override // com.ss.android.downloadlib.b.d
        public void a(boolean z10) {
            c.this.a(eVar, z10, i10, downloadModel);
        }
    }

    public c() {
        this.f21239c = null;
        this.f21239c = new ConcurrentHashMap<>();
    }

    public static c a() {
        if (f21238b == null) {
            synchronized (c.class) {
                try {
                    if (f21238b == null) {
                        f21238b = new c();
                    }
                } finally {
                }
            }
        }
        return f21238b;
    }

    public long b() {
        return k.j().optLong("quick_app_check_internal", 1200L);
    }

    public void a(e eVar, boolean z10, int i10, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id2 = downloadModel.getId();
        if (i10 == 4) {
            if (!z10) {
                a(id2, false, 2);
                eVar.b(false);
                return;
            } else {
                a(id2, true, 2);
                return;
            }
        }
        if (i10 == 5) {
            if (!z10) {
                a(id2, false, 1);
                eVar.c(false);
                return;
            } else {
                a(id2, true, 1);
                return;
            }
        }
        if (i10 != 7) {
            return;
        }
        Runnable remove = this.f21239c.remove(Long.valueOf(id2));
        if (z10) {
            com.ss.android.downloadlib.d.a.a().a(id2, 1);
            a(id2, true, 1);
        } else {
            if (remove != null) {
                com.ss.android.downloadlib.g.a().b().post(remove);
            }
            a(id2, false, 1);
        }
    }

    private void a(long j10, boolean z10, int i10) {
        com.ss.android.downloadlib.d.a.a().a(j10, z10, i10);
        if (z10) {
            k.v().a(null, null, null, null, null, 3);
        }
    }

    public void a(e eVar, int i10, DownloadModel downloadModel) {
        com.ss.android.downloadlib.b.e.a().a(new com.ss.android.downloadlib.b.d() { // from class: com.ss.android.downloadlib.addownload.c.1

            /* renamed from: a */
            final /* synthetic */ e f21240a;

            /* renamed from: b */
            final /* synthetic */ int f21241b;

            /* renamed from: c */
            final /* synthetic */ DownloadModel f21242c;

            public AnonymousClass1(e eVar2, int i102, DownloadModel downloadModel2) {
                eVar = eVar2;
                i10 = i102;
                downloadModel = downloadModel2;
            }

            @Override // com.ss.android.downloadlib.b.d
            public void a(boolean z10) {
                c.this.a(eVar, z10, i10, downloadModel);
            }
        }, b());
    }

    public static boolean a(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
