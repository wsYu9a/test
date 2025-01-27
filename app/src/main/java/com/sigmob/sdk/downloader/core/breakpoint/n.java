package com.sigmob.sdk.downloader.core.breakpoint;

import com.sigmob.sdk.downloader.core.breakpoint.m;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: a */
    public final m f19076a;

    /* renamed from: b */
    public long f19077b;

    public n(m.a aVar) {
        this(new m(aVar));
    }

    public void a(int i10) {
        this.f19076a.e(i10);
        this.f19076a.c(i10);
    }

    public void b(int i10) {
        this.f19076a.e(i10);
        try {
            if (!this.f19076a.a(i10)) {
                this.f19076a.d(i10);
            }
        } finally {
            this.f19076a.b(i10);
        }
    }

    public boolean c(int i10) {
        return !this.f19076a.a(i10);
    }

    public void d(int i10) {
        this.f19076a.e(i10);
        this.f19076a.a(i10, this.f19077b);
    }

    public n(m mVar) {
        this.f19076a = mVar;
        this.f19077b = qe.a.f30009d;
    }

    public void a() {
        this.f19076a.a();
    }
}
