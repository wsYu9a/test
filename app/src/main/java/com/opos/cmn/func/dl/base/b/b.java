package com.opos.cmn.func.dl.base.b;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes4.dex */
public final class b implements c {

    /* renamed from: a */
    public ThreadPoolExecutor f17276a;

    /* renamed from: b */
    public ThreadPoolExecutor f17277b;

    /* renamed from: c */
    private c f17278c;

    /* renamed from: d */
    private Executor f17279d;

    /* renamed from: e */
    private ThreadPoolExecutor f17280e;

    public b(c cVar) {
        this.f17278c = cVar;
        this.f17279d = cVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final Executor a() {
        return this.f17279d;
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor b() {
        if (this.f17276a == null) {
            this.f17276a = this.f17278c.b();
        }
        return this.f17276a;
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor c() {
        if (this.f17277b == null) {
            this.f17277b = this.f17278c.c();
        }
        return this.f17277b;
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor d() {
        if (this.f17280e == null) {
            this.f17280e = this.f17278c.d();
        }
        return this.f17280e;
    }
}
