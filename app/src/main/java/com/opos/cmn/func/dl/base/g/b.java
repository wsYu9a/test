package com.opos.cmn.func.dl.base.g;

import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.b.c;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public class b implements com.opos.cmn.func.dl.base.b {

    /* renamed from: b */
    private static final String f17357b = "b";

    /* renamed from: a */
    public List<com.opos.cmn.func.dl.base.b> f17358a = new ArrayList();

    /* renamed from: c */
    private Executor f17359c;

    /* renamed from: com.opos.cmn.func.dl.base.g.b$1 */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17360a;

        /* renamed from: b */
        final /* synthetic */ DownloadResponse f17361b;

        AnonymousClass1(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            downloadRequest = downloadRequest;
            downloadResponse = downloadResponse;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = b.this.f17358a.iterator();
            while (it.hasNext()) {
                ((com.opos.cmn.func.dl.base.b) it.next()).a(downloadRequest, downloadResponse);
            }
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.g.b$2 */
    final class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17363a;

        /* renamed from: b */
        final /* synthetic */ DownloadResponse f17364b;

        AnonymousClass2(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            downloadRequest = downloadRequest;
            downloadResponse = downloadResponse;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = b.this.f17358a.iterator();
            while (it.hasNext()) {
                ((com.opos.cmn.func.dl.base.b) it.next()).b(downloadRequest, downloadResponse);
            }
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.g.b$3 */
    final class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17366a;

        /* renamed from: b */
        final /* synthetic */ DownloadResponse f17367b;

        AnonymousClass3(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            downloadRequest = downloadRequest;
            downloadResponse = downloadResponse;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = b.this.f17358a.iterator();
            while (it.hasNext()) {
                ((com.opos.cmn.func.dl.base.b) it.next()).c(downloadRequest, downloadResponse);
            }
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.g.b$4 */
    final class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17369a;

        /* renamed from: b */
        final /* synthetic */ DownloadResponse f17370b;

        AnonymousClass4(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            downloadRequest = downloadRequest;
            downloadResponse = downloadResponse;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = b.this.f17358a.iterator();
            while (it.hasNext()) {
                ((com.opos.cmn.func.dl.base.b) it.next()).d(downloadRequest, downloadResponse);
            }
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.g.b$5 */
    final class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17372a;

        /* renamed from: b */
        final /* synthetic */ DownloadResponse f17373b;

        AnonymousClass5(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            downloadRequest = downloadRequest;
            downloadResponse = downloadResponse;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = b.this.f17358a.iterator();
            while (it.hasNext()) {
                ((com.opos.cmn.func.dl.base.b) it.next()).e(downloadRequest, downloadResponse);
            }
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.g.b$6 */
    final class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17375a;

        /* renamed from: b */
        final /* synthetic */ DownloadResponse f17376b;

        AnonymousClass6(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            downloadRequest = downloadRequest;
            downloadResponse = downloadResponse;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = b.this.f17358a.iterator();
            while (it.hasNext()) {
                ((com.opos.cmn.func.dl.base.b) it.next()).f(downloadRequest, downloadResponse);
            }
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.g.b$7 */
    final class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17378a;

        /* renamed from: b */
        final /* synthetic */ DownloadResponse f17379b;

        /* renamed from: c */
        final /* synthetic */ DlException f17380c;

        AnonymousClass7(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            downloadRequest = downloadRequest;
            downloadResponse = downloadResponse;
            dlException = dlException;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = b.this.f17358a.iterator();
            while (it.hasNext()) {
                ((com.opos.cmn.func.dl.base.b) it.next()).a(downloadRequest, downloadResponse, dlException);
            }
        }
    }

    public b(boolean z, c cVar) {
        this.f17359c = z ? cVar.a() : cVar.d();
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.b(f17357b, "onQueued:" + downloadRequest.f17191a);
        this.f17359c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.1

            /* renamed from: a */
            final /* synthetic */ DownloadRequest f17360a;

            /* renamed from: b */
            final /* synthetic */ DownloadResponse f17361b;

            AnonymousClass1(DownloadRequest downloadRequest2, DownloadResponse downloadResponse2) {
                downloadRequest = downloadRequest2;
                downloadResponse = downloadResponse2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f17358a.iterator();
                while (it.hasNext()) {
                    ((com.opos.cmn.func.dl.base.b) it.next()).a(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
        com.opos.cmn.an.f.a.b(f17357b, "onError:" + dlException.toString());
        this.f17359c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.7

            /* renamed from: a */
            final /* synthetic */ DownloadRequest f17378a;

            /* renamed from: b */
            final /* synthetic */ DownloadResponse f17379b;

            /* renamed from: c */
            final /* synthetic */ DlException f17380c;

            AnonymousClass7(DownloadRequest downloadRequest2, DownloadResponse downloadResponse2, DlException dlException2) {
                downloadRequest = downloadRequest2;
                downloadResponse = downloadResponse2;
                dlException = dlException2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f17358a.iterator();
                while (it.hasNext()) {
                    ((com.opos.cmn.func.dl.base.b) it.next()).a(downloadRequest, downloadResponse, dlException);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void b(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.b(f17357b, "onStart:" + downloadRequest.f17191a);
        this.f17359c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.2

            /* renamed from: a */
            final /* synthetic */ DownloadRequest f17363a;

            /* renamed from: b */
            final /* synthetic */ DownloadResponse f17364b;

            AnonymousClass2(DownloadRequest downloadRequest2, DownloadResponse downloadResponse2) {
                downloadRequest = downloadRequest2;
                downloadResponse = downloadResponse2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f17358a.iterator();
                while (it.hasNext()) {
                    ((com.opos.cmn.func.dl.base.b) it.next()).b(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void c(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
        this.f17359c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.3

            /* renamed from: a */
            final /* synthetic */ DownloadRequest f17366a;

            /* renamed from: b */
            final /* synthetic */ DownloadResponse f17367b;

            AnonymousClass3(DownloadRequest downloadRequest2, DownloadResponse downloadResponse2) {
                downloadRequest = downloadRequest2;
                downloadResponse = downloadResponse2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f17358a.iterator();
                while (it.hasNext()) {
                    ((com.opos.cmn.func.dl.base.b) it.next()).c(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.b(f17357b, "onPause:" + downloadRequest.f17191a);
        this.f17359c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.4

            /* renamed from: a */
            final /* synthetic */ DownloadRequest f17369a;

            /* renamed from: b */
            final /* synthetic */ DownloadResponse f17370b;

            AnonymousClass4(DownloadRequest downloadRequest2, DownloadResponse downloadResponse2) {
                downloadRequest = downloadRequest2;
                downloadResponse = downloadResponse2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f17358a.iterator();
                while (it.hasNext()) {
                    ((com.opos.cmn.func.dl.base.b) it.next()).d(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void e(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.b(f17357b, "onCancle:" + downloadRequest.f17191a);
        this.f17359c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.5

            /* renamed from: a */
            final /* synthetic */ DownloadRequest f17372a;

            /* renamed from: b */
            final /* synthetic */ DownloadResponse f17373b;

            AnonymousClass5(DownloadRequest downloadRequest2, DownloadResponse downloadResponse2) {
                downloadRequest = downloadRequest2;
                downloadResponse = downloadResponse2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f17358a.iterator();
                while (it.hasNext()) {
                    ((com.opos.cmn.func.dl.base.b) it.next()).e(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.b
    public void f(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.b(f17357b, "onComplete:" + downloadRequest.f17191a);
        this.f17359c.execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.6

            /* renamed from: a */
            final /* synthetic */ DownloadRequest f17375a;

            /* renamed from: b */
            final /* synthetic */ DownloadResponse f17376b;

            AnonymousClass6(DownloadRequest downloadRequest2, DownloadResponse downloadResponse2) {
                downloadRequest = downloadRequest2;
                downloadResponse = downloadResponse2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.f17358a.iterator();
                while (it.hasNext()) {
                    ((com.opos.cmn.func.dl.base.b) it.next()).f(downloadRequest, downloadResponse);
                }
            }
        });
    }
}
