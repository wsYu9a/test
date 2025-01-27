package com.opos.cmn.an.j;

import android.text.TextUtils;
import com.opos.cmn.an.j.a.c;
import com.opos.cmn.an.j.b.e;
import com.opos.cmn.an.j.b.f;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class a extends ThreadPoolExecutor {

    /* renamed from: a */
    private c f16560a;

    /* renamed from: b */
    private com.opos.cmn.an.j.a.b f16561b;

    /* renamed from: c */
    private ThreadLocal<f> f16562c;

    /* renamed from: com.opos.cmn.an.j.a$a */
    public static class C0372a {

        /* renamed from: g */
        private com.opos.cmn.an.j.a.b f16569g;

        /* renamed from: h */
        private c f16570h;

        /* renamed from: i */
        private BlockingQueue<Runnable> f16571i;

        /* renamed from: a */
        private int f16563a = 3;

        /* renamed from: b */
        private int f16564b = 5;

        /* renamed from: c */
        private int f16565c = 128;

        /* renamed from: d */
        private int f16566d = BaseConstants.Time.MINUTE;

        /* renamed from: f */
        private String f16568f = "cmn_thread";

        /* renamed from: e */
        private int f16567e = 5;

        public C0372a a(int i2) {
            this.f16563a = i2;
            return this;
        }

        public C0372a a(String str) {
            this.f16568f = str;
            return this;
        }

        public C0372a a(BlockingQueue<Runnable> blockingQueue) {
            this.f16571i = blockingQueue;
            return this;
        }

        public a a() {
            this.f16567e = Math.max(1, Math.min(10, this.f16567e));
            this.f16568f = TextUtils.isEmpty(this.f16568f) ? "cmn_thread" : this.f16568f;
            if (this.f16571i == null) {
                this.f16571i = new LinkedBlockingQueue(this.f16565c);
            }
            return new a(this.f16563a, this.f16564b, this.f16566d, TimeUnit.MILLISECONDS, this.f16571i, this.f16567e, this.f16568f, this.f16569g, this.f16570h);
        }

        public C0372a b(int i2) {
            this.f16564b = i2;
            return this;
        }

        public C0372a c(int i2) {
            this.f16566d = i2;
            return this;
        }
    }

    private a(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, int i4, String str, com.opos.cmn.an.j.a.b bVar, c cVar) {
        super(i2, i3, j2, timeUnit, blockingQueue, new com.opos.cmn.an.j.b.a(str, i4), new ThreadPoolExecutor.DiscardPolicy());
        this.f16562c = new ThreadLocal<>();
        this.f16561b = bVar;
        this.f16560a = cVar;
    }

    /* synthetic */ a(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue blockingQueue, int i4, String str, com.opos.cmn.an.j.a.b bVar, c cVar, AnonymousClass1 anonymousClass1) {
        this(i2, i3, j2, timeUnit, blockingQueue, i4, str, bVar, cVar);
    }

    private void a() {
        synchronized (this) {
            this.f16562c.set(null);
        }
    }

    private f b() {
        f fVar;
        synchronized (this) {
            fVar = this.f16562c.get();
            if (fVar == null) {
                fVar = new f();
                fVar.f16606b = this.f16560a;
                fVar.f16607c = this.f16561b;
                fVar.f16608d = com.opos.cmn.an.j.a.a.THREAD;
                this.f16562c.set(fVar);
            }
        }
        return fVar;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f b2 = b();
        b2.f16609e = runnable;
        super.execute(new e(b2));
        a();
    }
}
