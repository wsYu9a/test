package com.opos.cmn.an.i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    public final ExecutorService f16546a;

    /* renamed from: b */
    public final ExecutorService f16547b;

    /* renamed from: c */
    public final ExecutorService f16548c;

    /* renamed from: d */
    public final ExecutorService f16549d;

    /* renamed from: e */
    public final ExecutorService f16550e;

    /* renamed from: f */
    public final ScheduledExecutorService f16551f;

    public static class a {

        /* renamed from: a */
        private ExecutorService f16552a;

        /* renamed from: b */
        private ExecutorService f16553b;

        /* renamed from: c */
        private ExecutorService f16554c;

        /* renamed from: d */
        private ExecutorService f16555d;

        /* renamed from: e */
        private ExecutorService f16556e;

        /* renamed from: f */
        private ScheduledExecutorService f16557f;

        private void b() {
            if (this.f16552a == null) {
                this.f16552a = com.opos.cmn.an.i.a.a();
            }
            if (this.f16553b == null) {
                this.f16553b = com.opos.cmn.an.i.a.b();
            }
            if (this.f16554c == null) {
                this.f16554c = com.opos.cmn.an.i.a.d();
            }
            if (this.f16555d == null) {
                this.f16555d = com.opos.cmn.an.i.a.c();
            }
            if (this.f16556e == null) {
                this.f16556e = com.opos.cmn.an.i.a.e();
            }
            if (this.f16557f == null) {
                this.f16557f = com.opos.cmn.an.i.a.f();
            }
        }

        public a a(ExecutorService executorService) {
            this.f16552a = executorService;
            return this;
        }

        public a a(ScheduledExecutorService scheduledExecutorService) {
            this.f16557f = scheduledExecutorService;
            return this;
        }

        public d a() {
            b();
            return new d(this);
        }

        public a b(ExecutorService executorService) {
            this.f16553b = executorService;
            return this;
        }

        public a c(ExecutorService executorService) {
            this.f16554c = executorService;
            return this;
        }

        public a d(ExecutorService executorService) {
            this.f16555d = executorService;
            return this;
        }

        public a e(ExecutorService executorService) {
            this.f16556e = executorService;
            return this;
        }
    }

    public d(a aVar) {
        this.f16546a = aVar.f16552a;
        this.f16547b = aVar.f16553b;
        this.f16548c = aVar.f16554c;
        this.f16549d = aVar.f16555d;
        this.f16550e = aVar.f16556e;
        this.f16551f = aVar.f16557f;
    }

    public String toString() {
        return "ThreadPoolParams{netExecutorService=" + this.f16546a + ", ioExecutorService=" + this.f16547b + ", bizExecutorService=" + this.f16548c + ", dlExecutorService=" + this.f16549d + ", singleExecutorService=" + this.f16550e + ", scheduleExecutorService=" + this.f16551f + '}';
    }
}
