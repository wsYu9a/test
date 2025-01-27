package com.opos.cmn.func.dl;

import android.content.Context;
import com.opos.cmn.func.dl.base.DownloadConfig;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.b;
import com.opos.cmn.func.dl.base.c;
import com.opos.cmn.func.dl.base.d;
import com.opos.cmn.func.dl.service.DownloadRemoteManager;
import com.opos.cmn.func.dl.service.DownloadService;

/* loaded from: classes4.dex */
public final class a implements c {

    /* renamed from: a */
    private static final String f17182a = "a";

    /* renamed from: b */
    private c f17183b;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, Class cls) {
        d dVar;
        if (context == null) {
            com.opos.cmn.an.f.a.d(f17182a, "Context should not be null!");
            return;
        }
        if (cls != null) {
            try {
                try {
                    if (DownloadService.class.isAssignableFrom(cls)) {
                        this.f17183b = new DownloadRemoteManager(context.getApplicationContext(), cls);
                    }
                } catch (NoClassDefFoundError unused) {
                    com.opos.cmn.an.f.a.d(f17182a, "library service not include!");
                    if (this.f17183b != null) {
                        return;
                    } else {
                        dVar = new d(context);
                    }
                }
            } catch (Throwable th) {
                if (this.f17183b == null) {
                    this.f17183b = new d(context);
                }
                throw th;
            }
        }
        if (this.f17183b == null) {
            dVar = new d(context);
            this.f17183b = dVar;
        }
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void a(DownloadConfig downloadConfig) {
        this.f17183b.a(downloadConfig);
        com.opos.cmn.an.f.a.c(f17182a, "DownloadManager init!");
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void a(DownloadRequest downloadRequest) {
        this.f17183b.a(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void a(b bVar) {
        this.f17183b.a(bVar);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void b(DownloadRequest downloadRequest) {
        this.f17183b.b(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void b(b bVar) {
        this.f17183b.b(bVar);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void c(DownloadRequest downloadRequest) {
        this.f17183b.c(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void d(DownloadRequest downloadRequest) {
        this.f17183b.d(downloadRequest);
    }
}
