package com.opos.cmn.func.dl.base.f;

import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.a.c;
import com.opos.cmn.func.dl.base.d;
import com.opos.cmn.func.dl.base.exception.DlException;
import com.opos.cmn.func.dl.base.g.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static final String f17333a = "a";

    /* renamed from: c */
    public d f17335c;

    /* renamed from: d */
    public b f17336d;

    /* renamed from: g */
    private com.opos.cmn.func.dl.base.a.a.d f17339g;

    /* renamed from: h */
    private com.opos.cmn.func.dl.base.d.b f17340h;

    /* renamed from: f */
    private Map<Integer, DownloadRequest> f17338f = new ConcurrentHashMap();

    /* renamed from: b */
    public Map<Integer, c> f17334b = new ConcurrentHashMap();

    /* renamed from: e */
    public com.opos.cmn.func.dl.base.a.a.b f17337e = new com.opos.cmn.func.dl.base.a.a.b();

    /* renamed from: com.opos.cmn.func.dl.base.f.a$1 */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17341a;

        /* renamed from: b */
        final /* synthetic */ boolean f17342b;

        AnonymousClass1(DownloadRequest downloadRequest, boolean z) {
            downloadRequest = downloadRequest;
            z = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2 = downloadRequest.f17196f;
            if (a.this.f17338f.get(Integer.valueOf(i2)) == null) {
                a.this.f17338f.put(Integer.valueOf(i2), downloadRequest);
            }
            c cVar = (c) a.this.f17334b.get(Integer.valueOf(i2));
            if (cVar == null) {
                cVar = new c(downloadRequest, a.this);
                a.this.f17334b.put(Integer.valueOf(i2), cVar);
            }
            a.this.f17340h.a(downloadRequest);
            cVar.a(z);
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.f.a$2 */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17344a;

        public AnonymousClass2(final DownloadRequest downloadRequest2) {
            downloadRequest = downloadRequest2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = (c) a.this.f17334b.get(Integer.valueOf(downloadRequest.f17196f));
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.f.a$3 */
    public final class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadRequest f17346a;

        public AnonymousClass3(final DownloadRequest downloadRequest2) {
            downloadRequest = downloadRequest2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = (c) a.this.f17334b.get(Integer.valueOf(downloadRequest.f17196f));
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    /* renamed from: com.opos.cmn.func.dl.base.f.a$a */
    final class C0393a extends com.opos.cmn.func.dl.base.a {

        /* renamed from: com.opos.cmn.func.dl.base.f.a$a$1 */
        final class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.cmn.func.dl.base.a.b f17349a;

            AnonymousClass1(com.opos.cmn.func.dl.base.a.b bVar) {
                bVar = bVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.opos.cmn.an.d.b.a.e(bVar.f17259i);
                com.opos.cmn.an.d.b.a.e(bVar.f17260j);
            }
        }

        C0393a() {
        }

        private void a(int i2) {
            a.this.f17338f.remove(Integer.valueOf(i2));
            a.this.f17334b.remove(Integer.valueOf(i2));
        }

        private void a(c cVar) {
            com.opos.cmn.func.dl.base.a.b bVar = cVar.f17265a;
            if (TextUtils.isEmpty(bVar.f17258h)) {
                return;
            }
            a.this.f17335c.g().d().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.a.1

                /* renamed from: a */
                final /* synthetic */ com.opos.cmn.func.dl.base.a.b f17349a;

                AnonymousClass1(com.opos.cmn.func.dl.base.a.b bVar2) {
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.opos.cmn.an.d.b.a.e(bVar.f17259i);
                    com.opos.cmn.an.d.b.a.e(bVar.f17260j);
                }
            });
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            com.opos.cmn.an.f.a.b(a.f17333a, "onError:" + dlException.toString());
            a.this.a().b(downloadRequest.f17196f);
            c cVar = (c) a.this.f17334b.get(Integer.valueOf(downloadRequest.f17196f));
            if (cVar != null && !cVar.f17265a.m) {
                a(cVar);
            }
            if (downloadRequest.f17197g) {
                return;
            }
            a(downloadRequest.f17196f);
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            com.opos.cmn.an.f.a.b(a.f17333a, "onPause:" + downloadRequest.f17191a);
            a.this.a().b(downloadRequest.f17196f);
            c cVar = (c) a.this.f17334b.get(Integer.valueOf(downloadRequest.f17196f));
            if (cVar == null || cVar.f17265a.m) {
                return;
            }
            a(cVar);
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void e(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            com.opos.cmn.an.f.a.b(a.f17333a, "onCancle:" + downloadRequest.f17191a);
            a.this.a().b(downloadRequest.f17196f);
            c cVar = (c) a.this.f17334b.get(Integer.valueOf(downloadRequest.f17196f));
            if (cVar != null) {
                a(cVar);
            }
            a(downloadRequest.f17196f);
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.b
        public final void f(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            com.opos.cmn.an.f.a.b(a.f17333a, "onComplete:" + downloadRequest.f17191a);
            c cVar = (c) a.this.f17334b.get(Integer.valueOf(downloadRequest.f17196f));
            if (cVar != null) {
                a(cVar);
            }
            a(downloadRequest.f17196f);
        }
    }

    public a(d dVar, b bVar) {
        this.f17335c = dVar;
        this.f17336d = bVar;
        this.f17340h = new com.opos.cmn.func.dl.base.d.b(this.f17335c.f(), this);
        dVar.a(new C0393a());
    }

    public final com.opos.cmn.func.dl.base.a.a.d a() {
        if (this.f17339g == null) {
            this.f17339g = new com.opos.cmn.func.dl.base.a.a.d(this.f17335c.f(), this, this.f17335c.b());
        }
        return this.f17339g;
    }

    public final void a(DownloadRequest downloadRequest, boolean z) {
        if (downloadRequest == null) {
            com.opos.cmn.an.f.a.d(f17333a, "Request is null,do nothing");
        } else {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.1

                /* renamed from: a */
                final /* synthetic */ DownloadRequest f17341a;

                /* renamed from: b */
                final /* synthetic */ boolean f17342b;

                AnonymousClass1(DownloadRequest downloadRequest2, boolean z2) {
                    downloadRequest = downloadRequest2;
                    z = z2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = downloadRequest.f17196f;
                    if (a.this.f17338f.get(Integer.valueOf(i2)) == null) {
                        a.this.f17338f.put(Integer.valueOf(i2), downloadRequest);
                    }
                    c cVar = (c) a.this.f17334b.get(Integer.valueOf(i2));
                    if (cVar == null) {
                        cVar = new c(downloadRequest, a.this);
                        a.this.f17334b.put(Integer.valueOf(i2), cVar);
                    }
                    a.this.f17340h.a(downloadRequest);
                    cVar.a(z);
                }
            });
        }
    }
}
