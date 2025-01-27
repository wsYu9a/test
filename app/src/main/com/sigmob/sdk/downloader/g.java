package com.sigmob.sdk.downloader;

import android.annotation.SuppressLint;
import android.content.Context;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.file.a;
import com.sigmob.sdk.downloader.core.file.b;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: j */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile g f19411j;

    /* renamed from: a */
    public final com.sigmob.sdk.downloader.core.dispatcher.b f19412a;

    /* renamed from: b */
    public final com.sigmob.sdk.downloader.core.dispatcher.a f19413b;

    /* renamed from: c */
    public final com.sigmob.sdk.downloader.core.breakpoint.g f19414c;

    /* renamed from: d */
    public final a.b f19415d;

    /* renamed from: e */
    public final a.InterfaceC0589a f19416e;

    /* renamed from: f */
    public final com.sigmob.sdk.downloader.core.file.e f19417f;

    /* renamed from: g */
    public final com.sigmob.sdk.downloader.core.download.g f19418g;

    /* renamed from: h */
    public final Context f19419h;

    /* renamed from: i */
    public d f19420i;

    public static class a {

        /* renamed from: a */
        public com.sigmob.sdk.downloader.core.dispatcher.b f19421a;

        /* renamed from: b */
        public com.sigmob.sdk.downloader.core.dispatcher.a f19422b;

        /* renamed from: c */
        public com.sigmob.sdk.downloader.core.breakpoint.j f19423c;

        /* renamed from: d */
        public a.b f19424d;

        /* renamed from: e */
        public com.sigmob.sdk.downloader.core.file.e f19425e;

        /* renamed from: f */
        public com.sigmob.sdk.downloader.core.download.g f19426f;

        /* renamed from: g */
        public a.InterfaceC0589a f19427g;

        /* renamed from: h */
        public d f19428h;

        /* renamed from: i */
        public final Context f19429i;

        public a(Context context) {
            this.f19429i = context.getApplicationContext();
        }

        public g a() {
            if (this.f19421a == null) {
                this.f19421a = new com.sigmob.sdk.downloader.core.dispatcher.b();
            }
            if (this.f19422b == null) {
                this.f19422b = new com.sigmob.sdk.downloader.core.dispatcher.a();
            }
            if (this.f19423c == null) {
                this.f19423c = com.sigmob.sdk.downloader.core.c.a(this.f19429i);
            }
            if (this.f19424d == null) {
                this.f19424d = com.sigmob.sdk.downloader.core.c.a();
            }
            if (this.f19427g == null) {
                this.f19427g = new b.a();
            }
            if (this.f19425e == null) {
                this.f19425e = new com.sigmob.sdk.downloader.core.file.e();
            }
            if (this.f19426f == null) {
                this.f19426f = new com.sigmob.sdk.downloader.core.download.g();
            }
            g gVar = new g(this.f19429i, this.f19421a, this.f19422b, this.f19423c, this.f19424d, this.f19427g, this.f19425e, this.f19426f);
            gVar.a(this.f19428h);
            com.sigmob.sdk.downloader.core.c.a("FileDownload", "downloadStore[" + this.f19423c + "] connectionFactory[" + this.f19424d);
            return gVar;
        }

        public a a(com.sigmob.sdk.downloader.core.dispatcher.a aVar) {
            this.f19422b = aVar;
            return this;
        }

        public a a(a.b bVar) {
            this.f19424d = bVar;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.dispatcher.b bVar) {
            this.f19421a = bVar;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.breakpoint.j jVar) {
            this.f19423c = jVar;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.download.g gVar) {
            this.f19426f = gVar;
            return this;
        }

        public a a(d dVar) {
            this.f19428h = dVar;
            return this;
        }

        public a a(a.InterfaceC0589a interfaceC0589a) {
            this.f19427g = interfaceC0589a;
            return this;
        }

        public a a(com.sigmob.sdk.downloader.core.file.e eVar) {
            this.f19425e = eVar;
            return this;
        }
    }

    public g(Context context, com.sigmob.sdk.downloader.core.dispatcher.b bVar, com.sigmob.sdk.downloader.core.dispatcher.a aVar, com.sigmob.sdk.downloader.core.breakpoint.j jVar, a.b bVar2, a.InterfaceC0589a interfaceC0589a, com.sigmob.sdk.downloader.core.file.e eVar, com.sigmob.sdk.downloader.core.download.g gVar) {
        this.f19419h = context;
        this.f19412a = bVar;
        this.f19413b = aVar;
        this.f19414c = jVar;
        this.f19415d = bVar2;
        this.f19416e = interfaceC0589a;
        this.f19417f = eVar;
        this.f19418g = gVar;
        bVar.a(com.sigmob.sdk.downloader.core.c.a(jVar));
    }

    public static g j() {
        if (f19411j == null) {
            synchronized (g.class) {
                try {
                    if (f19411j == null) {
                        if (com.sigmob.sdk.a.d() == null) {
                            throw new IllegalStateException("context == null");
                        }
                        f19411j = new a(com.sigmob.sdk.a.d()).a();
                    }
                } finally {
                }
            }
        }
        return f19411j;
    }

    public com.sigmob.sdk.downloader.core.breakpoint.g a() {
        return this.f19414c;
    }

    public com.sigmob.sdk.downloader.core.dispatcher.a b() {
        return this.f19413b;
    }

    public a.b c() {
        return this.f19415d;
    }

    public Context d() {
        return this.f19419h;
    }

    public com.sigmob.sdk.downloader.core.dispatcher.b e() {
        return this.f19412a;
    }

    public com.sigmob.sdk.downloader.core.download.g f() {
        return this.f19418g;
    }

    public d g() {
        return this.f19420i;
    }

    public a.InterfaceC0589a h() {
        return this.f19416e;
    }

    public com.sigmob.sdk.downloader.core.file.e i() {
        return this.f19417f;
    }

    public void a(d dVar) {
        this.f19420i = dVar;
    }

    public static void a(g gVar) {
        if (f19411j != null) {
            throw new IllegalArgumentException("FileDownload must be null.");
        }
        synchronized (g.class) {
            try {
                if (f19411j != null) {
                    throw new IllegalArgumentException("FileDownload must be null.");
                }
                f19411j = gVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
