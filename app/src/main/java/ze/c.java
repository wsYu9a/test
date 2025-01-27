package ze;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.LoadAndDisplayImageTask;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public final ImageLoaderConfiguration f33788a;

    /* renamed from: b */
    public Executor f33789b;

    /* renamed from: c */
    public Executor f33790c;

    /* renamed from: e */
    public final Map<Integer, String> f33792e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f */
    public final Map<String, ReentrantLock> f33793f = new WeakHashMap();

    /* renamed from: g */
    public final AtomicBoolean f33794g = new AtomicBoolean(false);

    /* renamed from: h */
    public final AtomicBoolean f33795h = new AtomicBoolean(false);

    /* renamed from: i */
    public final AtomicBoolean f33796i = new AtomicBoolean(false);

    /* renamed from: j */
    public final Object f33797j = new Object();

    /* renamed from: d */
    public Executor f33791d = ze.a.i();

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ LoadAndDisplayImageTask f33798b;

        public a(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            this.f33798b = loadAndDisplayImageTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = c.this.f33788a.f16223o.get(this.f33798b.m());
            boolean z10 = file != null && file.exists();
            c.this.m();
            if (z10) {
                c.this.f33790c.execute(this.f33798b);
            } else {
                c.this.f33789b.execute(this.f33798b);
            }
        }
    }

    public c(ImageLoaderConfiguration imageLoaderConfiguration) {
        this.f33788a = imageLoaderConfiguration;
        this.f33789b = imageLoaderConfiguration.f16215g;
        this.f33790c = imageLoaderConfiguration.f16216h;
    }

    public void d(ef.a aVar) {
        this.f33792e.remove(Integer.valueOf(aVar.getId()));
    }

    public final Executor e() {
        ImageLoaderConfiguration imageLoaderConfiguration = this.f33788a;
        return ze.a.c(imageLoaderConfiguration.f16219k, imageLoaderConfiguration.f16220l, imageLoaderConfiguration.f16221m);
    }

    public void f(boolean z10) {
        this.f33795h.set(z10);
    }

    public void g(Runnable runnable) {
        this.f33791d.execute(runnable);
    }

    public String h(ef.a aVar) {
        return this.f33792e.get(Integer.valueOf(aVar.getId()));
    }

    public ReentrantLock i(String str) {
        ReentrantLock reentrantLock = this.f33793f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f33793f.put(str, reentrantLock2);
        return reentrantLock2;
    }

    public AtomicBoolean j() {
        return this.f33794g;
    }

    public Object k() {
        return this.f33797j;
    }

    public void l(boolean z10) {
        this.f33796i.set(z10);
    }

    public final void m() {
        if (!this.f33788a.f16217i && ((ExecutorService) this.f33789b).isShutdown()) {
            this.f33789b = e();
        }
        if (this.f33788a.f16218j || !((ExecutorService) this.f33790c).isShutdown()) {
            return;
        }
        this.f33790c = e();
    }

    public boolean n() {
        return this.f33795h.get();
    }

    public boolean o() {
        return this.f33796i.get();
    }

    public void p() {
        this.f33794g.set(true);
    }

    public void q(ef.a aVar, String str) {
        this.f33792e.put(Integer.valueOf(aVar.getId()), str);
    }

    public void r() {
        this.f33794g.set(false);
        synchronized (this.f33797j) {
            this.f33797j.notifyAll();
        }
    }

    public void s() {
        if (!this.f33788a.f16217i) {
            ((ExecutorService) this.f33789b).shutdownNow();
        }
        if (!this.f33788a.f16218j) {
            ((ExecutorService) this.f33790c).shutdownNow();
        }
        this.f33792e.clear();
        this.f33793f.clear();
    }

    public void t(LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.f33791d.execute(new a(loadAndDisplayImageTask));
    }

    public void u(e eVar) {
        m();
        this.f33790c.execute(eVar);
    }
}
