package com.opos.cmn.func.dl.base.b;

import com.opos.cmn.an.j.a;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class a implements c {

    /* renamed from: a */
    private int f17275a;

    public a(int i2) {
        this.f17275a = i2;
        if (i2 <= 0) {
            this.f17275a = 5;
        }
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final Executor a() {
        return new com.opos.cmn.an.j.b.c();
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor b() {
        int i2 = this.f17275a;
        return new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue());
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor c() {
        return new a.C0372a().b(Integer.MAX_VALUE).a(0).a("tp_thread").c(30000).a(new SynchronousQueue()).a();
    }

    @Override // com.opos.cmn.func.dl.base.b.c
    public final ThreadPoolExecutor d() {
        return com.opos.cmn.an.j.b.b();
    }
}
